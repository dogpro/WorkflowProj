package ru.solomatnikov.exception;

public class DocumentExistsException extends Exception {
    /**
     * Исключение на случай потоврения идентификатора
     * @param message Сообщение ошибки
     */
    public DocumentExistsException(String message) {
        super(message);
    }
}
