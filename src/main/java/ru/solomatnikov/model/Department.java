package ru.solomatnikov.model;

/**
 * Класс для определения подразделений
 */
public class Department extends Staff {
    /**
     * Создание поля для полного наименования депортамента
     */
    private String fullName;
    /**
     * Создание поля для краткого наименования депортамента
     */
    private String shortName;
    /**
     * Создание поля для руководителя депортамента
     */
    private String menager;
    /**
     * Создание поля для контактного номера депортамента
     */
    private String callPhone;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getMenager() {
        return menager;
    }

    public void setMenager(String menager) {
        this.menager = menager;
    }

    public String getCallPhone() {
        return callPhone;
    }

    public void setCallPhone(String callPhone) {
        this.callPhone = callPhone;
    }
}
