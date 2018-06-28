package ru.solomatnikov.model.interfaces;

/**
 * Интерфейс для реализации метода получения идентификатора документа и наименования хранилища
 */
public interface Storable {
    Long getId();
    String getStoreName();

}
