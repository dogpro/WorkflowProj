package ru.solomatnikov.controller;

import ru.solomatnikov.service.ServerProcessing;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.IOException;

@ApplicationPath("ecm")
public class MyApplication extends Application {
    /**
     * Метод, осуществляющий загрузку сервера и создание документов с авторами
     * @throws IOException Искючение на случай ошибки в работе с файлом
     */
    public MyApplication() throws IOException {
        new ServerProcessing().getDocument();
    }
}
