package ru.solomatnikov.servlets;

import ru.solomatnikov.DAO.DBTablesCreator;
import ru.solomatnikov.exception.DBCreateExitsException;
import ru.solomatnikov.exception.DBTableЕxistsException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class InitializationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }

    /**
     * Get запрос, инициализирующий таблицы БД
     * @param request request
     * @param response response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
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
    }
}
