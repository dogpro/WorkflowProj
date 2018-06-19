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

    //Проверка присутствия идентификатора документа в списке докумиентов
    private static boolean isIdExits(String id) {
        return (documentIdMap.containsValue(id));
    }

    public static Document getDocument(Class clazz) throws DocumentExistsException {
        
        Document document = documentFacrtoryMap.get(clazz).getDocument();
        
        //Проверка на уникальности ID
        if (isIdExits(document.getIdDoc())) {
            //Если идентификатор уже существует - вернуть ошибку
            throw new DocumentExistsException("Document Exits Exception");
        } else {
            documentIdMap.put(counter, document.getIdDoc());
            counter++;
        }

        return document;
    }
}