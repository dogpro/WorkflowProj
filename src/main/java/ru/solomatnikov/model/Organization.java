package ru.solomatnikov.model;

/**
 * Класс для определения организаций
 */
public class Organization extends Staff {
    /**
     * Полное наименование организации
     */
    private String fullName;
    /**
     * Краткое наименование организации
     */
    private String shortName;
    /**
     * Руководитель организации
     */
    private String manager;
    /**
     * Контактный номер организации
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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getCallPhone() {
        return callPhone;
    }

    public void setCallPhone(String callPhone) {
        this.callPhone = callPhone;
    }
}
