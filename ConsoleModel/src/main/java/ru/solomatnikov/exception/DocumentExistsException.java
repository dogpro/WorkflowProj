package ru.solomatnikov.exception;

public class DocumentExistsException extends Throwable {
    public DocumentExistsException(String message) {
        super(message);
    }
}
