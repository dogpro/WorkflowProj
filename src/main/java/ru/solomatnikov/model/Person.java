package ru.solomatnikov.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Класс для определения персонала
 */
@XmlRootElement(name ="Person")
public class Person extends Staff implements Comparable<Person> {
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
    private String lastName;
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

    public String getLastName() {
        return lastName;
    }
    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
                " lastName= " + lastName + ' ' +
                " post= " + post;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }

    public String getShortName() {
        StringBuilder shortName = new StringBuilder();
        shortName
                .append(surname != null ? surname : "")
                .append(" ")
                .append(name != null ? name : "")
                .append(" ")
                .append(lastName != null ? lastName : "");
        return shortName.toString();
    }
}
