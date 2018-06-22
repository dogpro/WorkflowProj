package ru.solomatnikov.exception;

public class FileNotFoundException extends RuntimeException {

    /**
     * Исключение на случай отсутствия файла
     * @param message Сообщение ошибки
     */
    public FileNotFoundException(String message) {
        super(message);
    }
}
