package ru.solomatnikov.model.Staff;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Класс для определения подразделений
 */
@XmlType
@XmlRootElement
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
    private String manager;

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
        return "Department";
    }


    @Override
    public String toString() {
        return super.toString() +
                " Наименование: " + fullName +
                ", Краткое наименование: " + shortName  +
                ", Менеджер: " + manager +
                ", Телефон: " + callPhone;
    }
}
