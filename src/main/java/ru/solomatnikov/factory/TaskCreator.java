package ru.solomatnikov.factory;

import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.model.document.Task;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TaskCreator extends Creator<Task> {

    /**
     * Метод для завполнения полей документа рандомнынми значениями
     * @return документ типа Задача
     */
    @Override
    public Task getDocument() {
        Task document = super.getDocument();

        String executor = EXECUTOR_LIST.get(RANDOM.nextInt(EXECUTOR_LIST.size()));
        String controlAssign = CONTROL_ASSIGN_LIST.get(RANDOM.nextInt(CONTROL_ASSIGN_LIST.size()));
        Date date = new Date(Math.abs(System.currentTimeMillis() - RANDOM.nextLong()));

        //Создание объекта Задача заполнение полей объекта
        document.setDateTask(date);
        document.setDatePerform(RANDOM.nextInt(10)+1);
        document.setExecutor(executor);
        document.setControl(RANDOM.nextInt(10)+1);
        document.setControlAssig(controlAssign);

        return document;
    }

    @Override
    protected Task initDocument() {
        return new Task();
    }
}