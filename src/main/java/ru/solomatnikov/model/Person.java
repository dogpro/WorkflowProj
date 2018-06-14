package ru.solomatnikov.model;

/**
 * Класс для определения персонала
 */
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

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
