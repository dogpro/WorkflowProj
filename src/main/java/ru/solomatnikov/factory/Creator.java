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
    protected final List<String> EXECUTOR_LIST = Arrays.asList("executor1","executor2","executor3","executor4");
    protected final List<String> CONTROL_ASSIGN_LIST = Arrays.asList("Да", "Нет");

    protected abstract T initDocument();

    protected Config getDateBaseFromXML(String xml, Class clazz){
        //
        try {
            File file = new File(xml);
            JAXBContext context = JAXBContext.newInstance(Config.class, clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Config config = (Config) unmarshaller.unmarshal(file);
            return config;
            //config.getPersonList().forEach(System.out::println);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public T getDocument(){
        T document = initDocument();
        Config config = getDateBaseFromXML("C:\\Users\\Student\\Desktop\\Persons.xml", Person.class);
        String id = String.valueOf(RANDOM.nextInt(10) + 1);
        Person author = config.getPersonList().get(RANDOM.nextInt(config.getPersonList().size()));
        //String author = AUTHOR_LIST.get(RANDOM.nextInt(AUTHOR_LIST.size()));

        //Заполнение общих полей документа
        document.setIdDoc(id);
        document.setNameDoc("Название документа");
        document.setTextDoc("Текст документа...");
        document.setRegnumDoc((long) (RANDOM.nextInt(10000)+1));
        document.setDateDoc(new Date(Math.abs(System.currentTimeMillis() - RANDOM.nextLong())));
        document.setAuthorDoc(author);

        return document;
    }
}