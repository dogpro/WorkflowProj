package ru.solomatnikov.factory;

import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.model.document.Task;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TaskCreator extends Creator {

    private static final Random RANDOM = new Random();
    private static final List<String> EXECUTOR_LIST = Arrays.asList("executor1","executor2","executor3","executor4");
    private static final List<String> CONTROL_ASSIGN_LIST = Arrays.asList("Да", "Нет");

    /**
     * Метод для завполнения полей документа рандомнынми значениями
     * @return документ типа Задача
     */
    @Override
    public Document getDocumentType() {
        String executor = EXECUTOR_LIST.get(RANDOM.nextInt(EXECUTOR_LIST.size()));
        String controlAssign = CONTROL_ASSIGN_LIST.get(RANDOM.nextInt(CONTROL_ASSIGN_LIST.size()));
        Date date = new Date(Math.abs(System.currentTimeMillis() - RANDOM.nextLong()));

        //Создание объекта Задача заполнение полей объекта
        Document document = new Task();
        ((Task) document).setDateTask(date);
        ((Task) document).setDatePerform(RANDOM.nextInt(10)+1);
        ((Task) document).setExecutor(executor);
        ((Task) document).setControl(RANDOM.nextInt(10)+1);
        ((Task) document).setControlAssig(controlAssign);

        return document;
    }
}