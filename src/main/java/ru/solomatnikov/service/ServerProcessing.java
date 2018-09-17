package ru.solomatnikov.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.solomatnikov.controller.EmployeesController;
import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.factory.Config;
import ru.solomatnikov.factory.DocumentFactory;
import ru.solomatnikov.model.Staff.Department;
import ru.solomatnikov.model.Staff.Organization;
import ru.solomatnikov.model.Staff.Person;
import ru.solomatnikov.model.Staff.Staff;
import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.model.document.Incoming;
import ru.solomatnikov.model.document.Outgoing;
import ru.solomatnikov.model.document.Task;
import ru.solomatnikov.servlets.AllDocumentsAuthorOnGetServlet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ServerProcessing <T extends Staff> {
    private static final Logger logger = LoggerFactory.getLogger(ServerProcessing.class);
    private static final Map<Long, TreeSet<Document>> reportOnAuthor = new TreeMap<>();

    /**
     * Метод создания документов
     *
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
     * Метод для чтения данных из XML файла
     * @param fileName Имя файла
     * @return Лист значений из файла
     * @throws IOException Икулючение на случай ошибки в работе с файлом
     */
    public Config<T> getDataInDBFromXML(String fileName) throws IOException {
        try (InputStream inputStream = ServerProcessing.class.getClassLoader().getResourceAsStream(fileName)) {
            JAXBContext context = JAXBContext.newInstance(Config.class, Person.class, Department.class, Organization.class);
            Source source = new StreamSource(inputStream);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Config<T>) unmarshaller.unmarshal(source, Config.class).getValue();
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
    public TreeSet<Document> getDocumentsByAuthor(Long id) {
        for (Map.Entry<Long, TreeSet<Document>> entry : ServerProcessing.reportOnAuthor.entrySet()) {
            Long key = entry.getKey();
            TreeSet<Document> documents = entry.getValue();
            if (key.equals(id)) return documents;
        }
        return null;
    }

    /**
     * Получение документа из списка по его идентификатору
     * @param id Идентификатор документа
     * @return Документ
     */
    public Document getDocumentByAuthor(Long id) {
        for (Document document : EmployeesController.documents) {
            if (document.getId().equals(id)) {
                return document;
            }
        }
        return null;
    }

    public Long getAuthorID(Long id){
        for (Map.Entry<Long, TreeSet<Document>> entry : ServerProcessing.reportOnAuthor.entrySet()) {
            Long key = entry.getKey();
            if (key.equals(id)) return key;
        }
        return null;
    }
}