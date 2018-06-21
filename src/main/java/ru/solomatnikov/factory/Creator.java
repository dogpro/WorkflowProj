package ru.solomatnikov.factory;

import ru.solomatnikov.model.Person;
import ru.solomatnikov.model.document.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Абстрактный класс для создания общего метода получения документа
 */
public abstract class Creator<T extends Document> {
    /**
     * Создание общего метода получения документа
     */
    protected final Random RANDOM = new Random();
    protected final List<String> EXECUTORS_LIST = Arrays.asList("executor1","executor2","executor3","executor4");
    protected final List<String> CONTROL_ASSIGN_LIST = Arrays.asList("Да", "Нет");

    protected abstract T initDocument();

    /**
     * Метод, с помощью которого просиходит получение данные из xml
     * и запись этих данных в поля объекта
     * @param fileName параметр, указывающий путь к файлу
     * @param clazz параметр, задающий класс для созданного объекта
     * @return список полученных объектов
     */
    protected Config getDateBaseFromXML(String fileName, Class clazz){
        //
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
     * Метод заполняюший поля документа
     * @return готовый документ
     */
    public T getDocument(){
        T document = initDocument();
        Config config = getDateBaseFromXML("C:\\Users\\Student\\Desktop\\Persons.xml", Person.class);
        String id = String.valueOf(RANDOM.nextInt(10) + 1);
        Person author = config.getPersonList().get(RANDOM.nextInt(config.getPersonList().size()));

        //Заполнение общих полей документа
        document.setIdDocument(id);
        document.setRegNumDocument((long) (RANDOM.nextInt(10000)+1));
        document.setCreationDate(new Date(Math.abs(System.currentTimeMillis() - RANDOM.nextLong())));
        document.setAuthorDocument(author);

        return document;
    }
}