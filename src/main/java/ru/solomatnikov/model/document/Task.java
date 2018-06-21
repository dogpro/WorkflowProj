package ru.solomatnikov.model.document;

import java.util.Date;

/**
 * Класс нужен для описания Задачи.
 */
public class Task extends Document {
    /**
     * Создание поля для даты создания задачи
     */
    private Date creationDateT;
    /**
     * Создание поля для срока выполнения задачи
     */
    private int performDate;
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
    private String controlAssign;

    public Date getCreationDateT() {
        return creationDateT;
    }

    public void setCreationDateT(Date creationDateT) {
        this.creationDateT = creationDateT;
    }

    public int getPerformDate() {
        return performDate;
    }

    public void setPerformDate(int performDate) {
        this.performDate = performDate;
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

    public String getControlAssign() {
        return controlAssign;
    }

    public void setControlAssign(String controlAssign) {
        this.controlAssign = controlAssign;
    }

    @Override
    public String toString() {
        return "Поручение" + super.toString();
    }
}