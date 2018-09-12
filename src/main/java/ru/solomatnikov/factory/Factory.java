package ru.solomatnikov.factory;

import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.model.Staff.Person;
import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.service.ServerProcessing;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


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
    protected static final Map<Integer, Long> documentIdMap = new HashMap<Integer, Long>();
    protected static int counter = 0;
    public static Config<Person> config;



    /**
     * Инициализирует документ по переданному типу с уже заполненнымии полями
     * @return Документ, по переданному типу
     */
    protected abstract T initialize();

    /**
     * Метод, проверяющий существование документа с одинаковым идентификатором
     * @param id Идентификатор документа
     * @return уже существует / не существует
     */
    private static boolean isIdExits(Long id) {
        return (documentIdMap.containsValue(id));
    }

    /**
     * Метод заполняюший поля документа
     * @return готовый документ
     * @throws DocumentExistsException Исключение на случай создания документа с уже существующим идентификатором
     * @throws IOException Исключение на случай ошибки в работе с файлом
     */
    public T getDocument() throws DocumentExistsException, IOException {
        Long id = (long)RANDOM.nextInt(10)+1;
        //Проверка на уникальности ID
        if (isIdExits(id)) {
            //Если идентификатор уже существует - вернуть ошибку
            throw new DocumentExistsException("Документ №" + id + " Document Exits Exception");
        } else {
            documentIdMap.put(counter++, id);

            T document = initialize();
            config = new ServerProcessing().getDataInDBFromXML("Persons.xml");
            Person author = config.getAny().get(RANDOM.nextInt(config.getAny().size()));
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