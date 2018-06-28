package ru.solomatnikov.model.Staff;

import ru.solomatnikov.model.interfaces.Storable;

/**
 * Класс для реализации элементов организационной структуры
 */

public abstract class Staff implements Storable {
    /**
     * Идентификатор
     */
    private Long id;

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "№=" + id + " ";
    }
}
