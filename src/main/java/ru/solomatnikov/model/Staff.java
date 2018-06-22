package ru.solomatnikov.model;

/**
 * Класс для реализации элементов организационной структуры
 */

public abstract class Staff {
    /**
     * Идентификатор
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
