package ru.solomatnikov.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Класс для реализации элементов организационной структуры
 */

public abstract class Staff {
    /**
     * Установка идентификатора
     */
    private String id;

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "№=" + id + " ";
    }
}
