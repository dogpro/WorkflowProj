package ru.solomatnikov.exception;

public class DBTableЕxistsException extends Exception {
    /**
     * Исключение на случай ошибки при попытке подключения к таблице
     * @param message Сообщение ошибки
     */
    public DBTableЕxistsException(String message) {
        super(message);
    }
}
