package ru.solomatnikov.model;

/**
 * Класс для определения подразделений
 */
public class Department extends Staff {
    /**
     * Полное наименование депортамента
     */
    private String fullName;
    /**
     * Краткое наименование депортамента
     */
    private String shortName;
    /**
     * Руководитель депортамента
     */
    private String menager;
    /**
     * Контактный номер депортамента
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
