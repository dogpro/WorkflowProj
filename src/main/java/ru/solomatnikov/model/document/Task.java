package ru.solomatnikov.model.document;

import java.util.Date;

/**
 * Класс нужен для описания Задачи.
 */
public class Task extends Document {
    /**
     * Дата создания задачи
     */
    private Date creationDateT;
    /**
     * Срок исполнения задачи
     */
    private int performDate;
    /**
     * Ответственный исполнитель
     */
    private String executor;
    /**
     * Признак контроля
     */
    private int control;
    /**
     * Контроль поручения
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