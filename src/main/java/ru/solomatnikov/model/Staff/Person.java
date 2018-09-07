package ru.solomatnikov.model.Staff;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Класс для определения персонала
 */
@XmlRootElement(name ="Person")
public class Person extends Staff implements Comparable<Person> {
    /**
     * Фамилия
     */
    private String surname;
    /**
     * Имя
     */
    private String firstName;
    /**
     * Отчество
     */
    private String lastName;
    /**
     * Должность
     */
    private String post;

    public String getSurname() {
        return surname;
    }
    @XmlElement
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }
    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
                " Фамилия: " + surname +
                ", Имя: " + firstName +
                ", Отчество: " + lastName +
                ", Должность: " + post;
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
                .append(firstName != null ? firstName : "")
                .append(" ")
                .append(lastName != null ? lastName : "");
        return shortName.toString();
    }

    @Override
    public String getStoreName() {
        return "Person";
    }
}
