package ru.solomatnikov.exception;

public class DBSelectByIdExitsException extends Exception {

    /**
     * Исключение на случай ошибки при операции Select c ID
     * @param message Сообщение ошибки
     */
    public DBSelectByIdExitsException(String message) {
        super(message);
    }
}
