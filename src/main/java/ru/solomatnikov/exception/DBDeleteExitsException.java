package ru.solomatnikov.exception;

public class DBDeleteExitsException extends Exception{
    /**
     * Исключение на случай ошибки в удалении записи
     * @param message Сообщение ошибки
     */
    public DBDeleteExitsException(String message) {
        super(message);
    }
}
