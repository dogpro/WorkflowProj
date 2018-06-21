package ru.solomatnikov.factory;

import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.model.document.Incoming;
import ru.solomatnikov.model.document.Outgoing;
import ru.solomatnikov.model.document.Task;

import java.util.Map;
import java.util.HashMap;

public final class DocumentFactory {

    private static Map<Class, Creator> documentFacrtoryMap = new HashMap<Class, Creator>() {{
        put(Task.class, new TaskCreator());
        put(Incoming.class, new IncomingCreator());
        put(Outgoing.class, new OutgoingCreator());
    }};
    private static Map<Integer, String> documentIdMap = new HashMap<Integer, String>();
    private static int counter = 0;

    private DocumentFactory(){}

    /**
     * Метод, проверяющий существование документа с одинаковым идентификатором
     * @param id Идентификатор документа
     * @return уже существует / не существует
     */
    private static boolean isIdExits(String id) {
        return (documentIdMap.containsValue(id));
    }

    /**
     * Метод, создающий документ исходя из переданного типа и проверяющий его уникальность
     * @param clazz Класс одного из возможных документов
     * @return Документ
     * @throws DocumentExistsException Ошибка на случай создания документа с уже существующим идентификатором
     */
    public static Document getDocument(Class clazz) throws DocumentExistsException {
        
        Document document = documentFacrtoryMap.get(clazz).getDocument();
        
        //Проверка на уникальности ID
        if (isIdExits(document.getIdDocument())) {
            //Если идентификатор уже существует - вернуть ошибку
            throw new DocumentExistsException("Document Exits Exception");
        } else {
            documentIdMap.put(counter, document.getIdDocument());
            counter++;
        }

        return document;
    }
}