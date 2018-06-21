package ru.solomatnikov.model;

/**
 * Класс для определения организаций
 */
public class Organization extends Staff {
    /**
     * Создание поля для полного имении организации
     */
    private String fullName;
    /**
     * Создание поля для краткого имени организации
     */
    private String shortName;
    /**
     * Создание поля для руководителя организации
     */
    private String manager;
    /**
     * Создание поля для номера организации
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
