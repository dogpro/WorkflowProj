package ru.solomatnikov.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Класс для определения персонала
 */
@XmlRootElement(name ="Person")
public class Person extends Staff {
    /**
     * Установка фамилии
     */
    private String surname;
    /**
     * Установка имени
     */
    private String name;
    /**
     * Установка отчества
     */
    private String otchestvo;
    /**
     * Установка должности
     */
    private String post;

    public String getSurname() {
        return surname;
    }
    @XmlElement
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getOtchestvo() {
        return otchestvo;
    }
    @XmlElement
    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getPost() {
        return post;
    }
    @XmlElement
    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return super.toString() +
                "surname= " + surname + ' ' +
                " name= " + name + ' ' +
                " otchestvo= " + otchestvo + ' ' +
                " post= " + post;
    }
}
