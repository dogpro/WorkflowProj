package ru.solomatnikov.factory;

import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.model.document.Task;

import java.io.IOException;
import java.util.Date;

public class TaskFactory extends Factory<Task> {

    /**
     * Метод для завполнения полей документа рандомнынми значениями
     * @return Документ типа Задача
     * @throws DocumentExistsException Исключение на случай создания документа с уже существующим идентификатором
     * @throws IOException Исключение на случай ошибки в работе с файлом
     */
    @Override
    public Task getDocument() throws DocumentExistsException, IOException {
        Task document = super.getDocument();
        String executor = EXECUTORS_LIST.get(RANDOM.nextInt(EXECUTORS_LIST.size()));
        String controlAssign = CONTROL_ASSIGN_LIST.get(RANDOM.nextInt(CONTROL_ASSIGN_LIST.size()));

        //Создание объекта Задача заполнение полей объекта
        document.setName("Документ Поручение");
        document.setText("Этот документ - Поручение");
        document.setCreationDateT(new Date(Math.abs(System.currentTimeMillis() - RANDOM.nextLong())));
        document.setPerformDate(RANDOM.nextInt(10)+1);
        document.setExecutor(executor);
        document.setControl(RANDOM.nextInt(10)+1);
        document.setControlAssign(controlAssign);

        return document;
    }

    @Override
    protected Task initialize() {
        return new Task();
    }
}