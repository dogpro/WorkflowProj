package ru.solomatnikov.model;

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
}
