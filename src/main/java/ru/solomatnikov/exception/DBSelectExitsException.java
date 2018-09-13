package ru.solomatnikov.exception;

public class DBSelectExitsException extends Exception {

    /**
     * Исключение на случай ошибки при операции Select
     * @param message Сообщение ошибки
     */
    public DBSelectExitsException(String message) {
        super(message);
    }
}
