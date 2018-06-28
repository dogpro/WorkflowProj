package ru.solomatnikov.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.factory.Config;
import ru.solomatnikov.factory.DocumentFactory;
import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.model.document.Incoming;
import ru.solomatnikov.model.document.Outgoing;
import ru.solomatnikov.model.document.Task;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

public class ServerProcessing {
    private static final Logger logger = LoggerFactory.getLogger(ServerProcessing.class);
    public static final Map<Long, TreeSet<Document>> reportOnAuthor = new TreeMap<>();

    /**
     * Метод создания документов
     * @throws IOException Исключение на случай ошибки пути к XML файлу
     */
    public void getDocument() throws IOException {
        List<Class> typeDocument = Arrays.asList(Incoming.class, Outgoing.class, Task.class);
        for (int i = 0; i < 10; i++) {
            Class type = typeDocument.get(new Random().nextInt(typeDocument.size()));

            try {
                //Получение в переменную document нового документа
                Document document = DocumentFactory.getDocument(type);
                Long author = document.getAuthor().getId();
                if (document != null) {
                    //Добавление авторов и списка документов в лист для отчета
                    if (!reportOnAuthor.containsKey(author)) {
                        reportOnAuthor.put(author, new TreeSet<>());
                    }
                    reportOnAuthor.get(author).add(document);
                }
            } catch (DocumentExistsException dEX) {
                logger.debug(dEX.getMessage());
            }
        }
    }

    /**
     * Метод, с помощью которого просиходит получение данные из xml
     *      * и запись этих данных в поля объекта
     * @param clazz Параметр, задающий класс для созданного объекта
     * @return Список полученных объектов
     * @throws IOException сключение на случай ошибки пути к XML файлу
     */
    public Config getDateBaseFromXML(Class clazz) throws IOException {

        try(InputStream inputStream = ServerProcessing.class.getClassLoader().getResourceAsStream("Persons.xml")) {
            JAXBContext context = JAXBContext.newInstance(Config.class, clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Config) unmarshaller.unmarshal(inputStream);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Получение списка документов по идентификатору автора
     * @param id Идентификатор автора
     * @return список документов
     */
    public TreeSet<Document> getDocumentOnAuthor(Long id){
        for (Map.Entry<Long, TreeSet<Document>> entry : ServerProcessing.reportOnAuthor.entrySet()) {
            Long key = entry.getKey();
            TreeSet<Document> documents = entry.getValue();
            if (key.equals(id)) return documents;
        }
        return null;
    }
}
