package ru.solomatnikov.model;

/**
 * Класс для определения подразделений
 */
public class Department extends Staff {
    /**
     * Установка полного наименования депортамента
     */
    private String fullNameDepartament;
    /**
     * Установка краткого наименования депортамента
     */
    private String shortNameDepartament;
    /**
     * Установка руководителя депортамента
     */
    private String menagerDepartament;
    /**
     * Устнановка контактного номера депортамента
     */
    private String callPhoneDepartament;

    public String getFullNameDepartament() {
        return fullNameDepartament;
    }

    public void setFullNameDepartament(String fullNameDepartament) {
        this.fullNameDepartament = fullNameDepartament;
    }

    public String getShortNameDepartament() {
        return shortNameDepartament;
    }

    public void setShortNameDepartament(String shortNameDepartament) {
        this.shortNameDepartament = shortNameDepartament;
    }

    public String getMenagerDepartament() {
        return menagerDepartament;
    }

    public void setMenagerDepartament(String menagerDepartament) {
        this.menagerDepartament = menagerDepartament;
    }

    public String getCallPhoneDepartament() {
        return callPhoneDepartament;
    }

    public void setCallPhoneDepartament(String callPhoneDepartament) {
        this.callPhoneDepartament = callPhoneDepartament;
    }
}
