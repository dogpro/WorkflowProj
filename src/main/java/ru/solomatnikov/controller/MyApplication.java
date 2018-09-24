package ru.solomatnikov.controller;

import ru.solomatnikov.DAO.DBTablesCreator;
import ru.solomatnikov.exception.DBCreateExitsException;
import ru.solomatnikov.exception.DBSelectExitsException;
import ru.solomatnikov.exception.DBTableЕxistsException;
import ru.solomatnikov.service.ServerProcessing;

import javax.ejb.Singleton;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.IOException;
import java.sql.SQLException;

@ApplicationPath("ecm")
public class MyApplication extends Application {

    /**
     * Метод, осуществляющий загрузку сервера и создание документов с авторами
     *
     * @throws IOException Искючение на случай ошибки в работе с файлом
     */
    public MyApplication() throws IOException, DBSelectExitsException {
        try {
            DBTablesCreator.createTableStaff();
            DBTablesCreator.createTableDepartments();
            DBTablesCreator.createTableOrganizations();
        } catch (DBTableЕxistsException | SQLException | IOException | DBCreateExitsException ex) {
            try {
                throw new DBTableЕxistsException("Ошибка при создании таблицы");
            } catch (DBTableЕxistsException e) {
                e.printStackTrace();
            }
        }

        new ServerProcessing().getDocument();
    }
}
