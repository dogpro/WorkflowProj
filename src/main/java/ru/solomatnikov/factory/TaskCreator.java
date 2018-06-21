package ru.solomatnikov.factory;

import ru.solomatnikov.model.document.Task;

import java.util.Date;

public class TaskCreator extends Creator<Task> {

    /**
     * Метод для завполнения полей документа рандомнынми значениями
     * @return документ типа Задача
     */
    @Override
    public Task getDocument() {
        Task document = super.getDocument();

        String executor = EXECUTORS_LIST.get(RANDOM.nextInt(EXECUTORS_LIST.size()));
        String controlAssign = CONTROL_ASSIGN_LIST.get(RANDOM.nextInt(CONTROL_ASSIGN_LIST.size()));
        Date date = new Date(Math.abs(System.currentTimeMillis() - RANDOM.nextLong()));

        //Создание объекта Задача заполнение полей объекта
        document.setNameDocument("Документ Поручение");
        document.setTextDocument("Этот документ - Поручение");
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