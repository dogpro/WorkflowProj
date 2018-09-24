package ru.solomatnikov.exception;

public class DBUpdateExitsException extends Exception{
    /**
     * Исключение на случай ошибки с обновлением записи
     * @param message Сообщение ошибки
     */
    public DBUpdateExitsException(String message) {
        super(message);
    }
}
