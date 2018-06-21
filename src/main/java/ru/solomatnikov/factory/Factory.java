package ru.solomatnikov.factory;

import ru.solomatnikov.Program;
import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.model.Person;
import ru.solomatnikov.model.document.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.*;

/**
 * Абстрактный класс для создания общего метода получения документа
 */
public abstract class Factory<T extends Document> {
    /**
     * Создание общего метода получения документа
     */
    protected final Random RANDOM = new Random();
    protected final List<String> EXECUTORS_LIST = Arrays.asList("executor1","executor2","executor3","executor4");
    protected final List<String> CONTROL_ASSIGN_LIST = Arrays.asList("Да", "Нет");
    protected Config config;



    protected abstract T initialization();

    /**
     * Метод, с помощью которого просиходит получение данные из xml
     * и запись этих данных в поля объекта
     * @param fileName параметр, указывающий путь к файлу
     * @param clazz параметр, задающий класс для созданного объекта
     * @return список полученных объектов
     */
    protected Config getDateBaseFromXML(String fileName, Class clazz){
        try {

            File file = new File(fileName);
            JAXBContext context = JAXBContext.newInstance(Config.class, clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Config config = (Config) unmarshaller.unmarshal(file);
            return config;
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Метод, проверяющий существование документа с одинаковым идентификатором
     * @param id Идентификатор документа
     * @return уже существует / не существует
     */
    private static boolean isIdExits(Long id) {
        return (Program.documentIdMap.containsValue(id));
    }

    /**
     * Метод заполняюший поля документа
     * @return готовый документ
     */
    public T getDocument() throws DocumentExistsException{
        Long id = (long)RANDOM.nextInt(10)+1;
        //Проверка на уникальности ID
        if (isIdExits(id)) {
            //Если идентификатор уже существует - вернуть ошибку
            throw new DocumentExistsException("Документ №" + id + " Document Exits Exception");
        } else {
            Program.documentIdMap.put(Program.counter++, id);

            T document = initialization();
            config = getDateBaseFromXML("src\\main\\resource\\Persons.xml", Person.class);
            Person author = config.getPersonList().get(RANDOM.nextInt(config.getPersonList().size()));
            Date date = new Date(Math.abs(System.currentTimeMillis() - RANDOM.nextLong()));
            //Заполнение общих полей документа
            document.setId(id);
            document.setRegistrationNumber((long) (RANDOM.nextInt(10000)+1));
            document.setCreationDate(date);
            document.setAuthor(author);
            return document;
        }
    }
}