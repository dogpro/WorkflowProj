package ru.solomatnikov.factory;

import ru.solomatnikov.exception.DBSelectExitsException;
import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.model.document.Incoming;
import ru.solomatnikov.model.document.Outgoing;
import ru.solomatnikov.model.document.Task;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public final class DocumentFactory {

    private static Map<Class, Factory> documentFactoryMap = new HashMap<Class, Factory>() {{
        put(Task.class, new TaskFactory());
        put(Incoming.class, new IncomingFactory());
        put(Outgoing.class, new OutgoingFactory());
    }};

    private DocumentFactory(){}

    /**
     * Метод, создающий документ исходя из переданного типа и проверяющий его уникальность
     * @param clazz Класс одного из возможных документов
     * @return Готовый документ
     * @throws DocumentExistsException Исключение на случай создания документа с уже существующим идентификатором
     * @throws IOException Исключение на случай ошибки в работе с файлом
     */
    public static Document getDocument(Class clazz) throws DocumentExistsException, IOException, DBSelectExitsException {
        return documentFactoryMap.get(clazz).getDocument();
    }
}