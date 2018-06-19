package ru.solomatnikov.factory;

import ru.solomatnikov.model.document.Document;

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
    protected final List<String> AUTHOR_LIST = Arrays.asList("user1", "user2", "user3", "user4");
    protected final List<String> EXECUTOR_LIST = Arrays.asList("executor1","executor2","executor3","executor4");
    protected final List<String> CONTROL_ASSIGN_LIST = Arrays.asList("Да", "Нет");

    protected abstract T initDocument();

    public T getDocument(){
        T document = initDocument();
        String id = String.valueOf(RANDOM.nextInt(10) + 1);
        String author = AUTHOR_LIST.get(RANDOM.nextInt(AUTHOR_LIST.size()));

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