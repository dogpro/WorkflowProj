package ru.solomatnikov.model.Staff;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Класс для определения подразделений
 */
@XmlRootElement(name ="Department")
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
    public String getMenager() {
        return menager;
    }

    @XmlElement
    public void setMenager(String menager) {
        this.menager = menager;
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
        return "Department";
    }
}
