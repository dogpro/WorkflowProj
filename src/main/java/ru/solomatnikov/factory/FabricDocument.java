package ru.solomatnikov.factory;

import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.model.document.Incoming;
import ru.solomatnikov.model.document.Task;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.HashMap;
import java.util.Date;

public final class FabricDocument {

    private final Random RANDOM = new Random();
    public final List<String> AUTHOR_LIST = Arrays.asList("user1", "user2", "user3", "user4");
    private Map<Integer, String> documentIdMap = new HashMap<Integer, String>();
    private int counter = 0;
    public String id;
    public String author;

    //Проверка присутствия идентификатора документа в списке докумиентов
    private  boolean isIdExits(String id) {
        return (documentIdMap.containsValue(id));
    }

    /**
     * Метод по созданию необходимого документа в зависимости от переданного типа документа
     * @param clazz Класс одного из документов
     * @return Документ
     * @throws DocumentExistsException Исключение на случай создания документа с не укникальным идентификатором
     */
    public Document getDocument(Class clazz) throws DocumentExistsException {
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