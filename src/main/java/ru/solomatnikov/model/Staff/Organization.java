package ru.solomatnikov.model.Staff;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Класс для определения организаций
 */
@XmlRootElement(name ="Organization")
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

    @XmlElement
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getShortName() {
        return shortName;
    }

    @XmlElement
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    public String getManager() {
        return manager;
    }

    @XmlElement
    public void setManager(String manager) {
        this.manager = manager;
    }
    public String getCallPhone() {
        return callPhone;
    }

    @XmlElement
    public void setCallPhone(String callPhone) {
        this.callPhone = callPhone;
    }

    @Override
    public String getStoreName() {
        return "Organization";
    }
}
