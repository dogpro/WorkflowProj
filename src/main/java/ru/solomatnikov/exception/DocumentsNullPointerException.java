package ru.solomatnikov.exception;

public class DocumentsNullPointerException extends Exception {

    /**
     * Исключение на случай отсутствия документов
     * @param message Сообщение ошибки
     */
    public DocumentsNullPointerException(String message) {
        super(message);
    }
}
