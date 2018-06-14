package ru.solomatnikov.model;

import ru.solomatnikov.exception.DocumentExistsException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.HashMap;
import java.util.Date;

public abstract class FabricDocument {

    private static final Random RANDOM = new Random();
    private static final List<String> AUTHOR_LIST = Arrays.asList("user1", "user2", "user3", "user4");
    private static Map<Integer, String> documentIdMap = new HashMap<Integer, String>();
    private static int counter = 0;
    public static String id;
    public static String author;

    public String getId() {
        return id;
    }
    public String getAuthor() {
        return author;
    }

    //Проверка присутствия идентификатора документа в списке докумиентов
    private static boolean isIdExits(String id) {
        return (documentIdMap.containsValue(id));
    }

    /**
     * Метод по созданию необходимого документа в зависимости от переданного типа документа
     * @param clazz Класс одного из документов
     * @return Документ
     * @throws DocumentExistsException Исключение на случай создания документа с не укникальным идентификатором
     */
    public static Document getDocument(Class clazz) throws DocumentExistsException {
        Document document;

        //Проверка переданного класса
        if (clazz.isAssignableFrom(Task.class)) {
            //Создание нового объекта типа Задача и передача его полей в document
            Creator taskCreator = new TaskCreator();
            document = taskCreator.getDocumentType();
        } else if (clazz.isAssignableFrom(Incoming.class)) {
            //Создание нового объекта типа Входящие и передача его полей в document
            Creator incomingCreator = new IncomingCreator();
            document = incomingCreator.getDocumentType();
        } else {
            //Создание нового объекта типа Исходящие и передача его полей в document
            Creator outgoingCreator = new OutgoingCreator();
            document = outgoingCreator.getDocumentType();
        }

        //Заполнение документа значениями
        id = String.valueOf(RANDOM.nextInt(10) + 1);
        author = AUTHOR_LIST.get(RANDOM.nextInt(AUTHOR_LIST.size()));

        //Заполнение общих полей документа
        document.setIdDoc(id);
        document.setNameDoc("Название документа");
        document.setTextDoc("Текст документа...");
        document.setRegnumDoc((long) (RANDOM.nextInt(10000)+1));
        document.setDateDoc(new Date(Math.abs(System.currentTimeMillis() - RANDOM.nextLong())));
        document.setAuthorDoc(author);

        //Проверка на уникальности ID
        if (isIdExits(id)) {
            //Если идентификатор уже существует - вернуть ошибку
            throw new DocumentExistsException("Document Exits Exception");
        } else {
            //Если идентификатор уникальный - добавить идентификатор в список для проверка
            documentIdMap.put(counter, id);
            counter++;
        }

        return document;
    }
}