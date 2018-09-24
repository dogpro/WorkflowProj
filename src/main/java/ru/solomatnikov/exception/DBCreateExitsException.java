package ru.solomatnikov.exception;

public class DBCreateExitsException extends Exception{
    /**
     * Исключение на случай ошибки при создании записи
     * @param message Сообщение ошибки
     */
    public DBCreateExitsException(String message) {
        super(message);
    }
}
