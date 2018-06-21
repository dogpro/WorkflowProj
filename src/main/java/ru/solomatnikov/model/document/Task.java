package ru.solomatnikov.model.document;

import java.util.Date;

/**
 * Класс нужен для описания Задачи.
 */
public class Task extends Document {
    /**
     * Создание поля для даты создания задачи
     */
    private Date dateTask;
    /**
     * Создание поля для срока выполнения задачи
     */
    private int datePerform;
    /**
     * Создание поля для ответственного исполнителя
     */
    private String executor;
    /**
     * Создание поля для признака контроля
     */
    private int control;
    /**
     * Создание поля для контроллера поручения
     */
    private String controlAssig;

    public Date getDateTask() {
        return dateTask;
    }

    public void setDateTask(Date dateTask) {
        this.dateTask = dateTask;
    }

    public int getDatePerform() {
        return datePerform;
    }

    public void setDatePerform(int datePerform) {
        this.datePerform = datePerform;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public int getControl() {
        return control;
    }

    public void setControl(int control) {
        this.control = control;
    }

    public String getControlAssig() {
        return controlAssig;
    }

    public void setControlAssig(String controlAssig) {
        this.controlAssig = controlAssig;
    }

    @Override
    public String toString() {
        return "Поручение" + super.toString();
    }
}