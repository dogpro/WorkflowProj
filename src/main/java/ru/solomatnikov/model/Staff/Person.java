package ru.solomatnikov.model.Staff;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Класс для определения персонала
 */
@XmlType
@XmlRootElement
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
    /**
     * Фото
     */
    private String photo;
    /**
     * День рождения
     */
    private String birthday;

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


    public String getBirthday() {
        return birthday;
    }
    @XmlElement
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoto() {
        return photo;
    }
    @XmlElement
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Фамилия: " + surname +
                ", Имя: " + firstName +
                ", Отчество: " + lastName +
                ", Должность: " + post +
                ", День рождения: " + birthday +
                ", Фото: " + photo;
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
