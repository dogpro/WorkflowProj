package ru.solomatnikov.model;

/**
 * Класс для определения организаций
 */
public class Organization extends Staff {
    /**
     * Установка полного имении организации
     */
    private String fullNameOrganization;
    /**
     * Установка краткого имени организации
     */
    private String shortNameOrganization;
    /**
     * Установка руководителя организации
     */
    private String managerOrganization;
    /**
     * Установка номера организации
     */
    private String callPhoneOrganization;

    public String getFullNameOrganization() {
        return fullNameOrganization;
    }

    public void setFullNameOrganization(String fullNameOrganization) {
        this.fullNameOrganization = fullNameOrganization;
    }

    public String getShortNameOrganization() {
        return shortNameOrganization;
    }

    public void setShortNameOrganization(String shortNameOrganization) {
        this.shortNameOrganization = shortNameOrganization;
    }

    public String getManagerOrganization() {
        return managerOrganization;
    }

    public void setManagerOrganization(String managerOrganization) {
        this.managerOrganization = managerOrganization;
    }

    public String getCallPhoneOrganization() {
        return callPhoneOrganization;
    }

    public void setCallPhoneOrganization(String callPhoneOrganization) {
        this.callPhoneOrganization = callPhoneOrganization;
    }
}
