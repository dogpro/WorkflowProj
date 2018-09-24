package ru.solomatnikov.servlets;

import ru.solomatnikov.exception.DBSelectExitsException;
import ru.solomatnikov.factory.Config;
import ru.solomatnikov.model.Staff.Person;
import ru.solomatnikov.service.ServerProcessing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import java.io.IOException;

public class AllAuthorsOnGetServlet extends HttpServlet {

    private ServerProcessing serverProcessing = new ServerProcessing();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }


    @Context HttpServletRequest request;
    /**
     * Get запрос, возвращающий список всех авторов
     * @param request Запрос
     * @param response Ответ
     * @throws ServletException Исключение на случай ошибки в выполнении сервлета
     * @throws IOException Исключение на случай ошибки при работе с файлом *.jsp
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Генерация документов
        try {
            serverProcessing.getDocument();
        } catch (DBSelectExitsException e) {
            e.printStackTrace();
        }
        //Генерация авторов из XML файла
        Config<Person> config = new ServerProcessing().getDataInDBFromXML("Persons.xml");

        request.setAttribute("persons", config.getAny());
        request.getRequestDispatcher("/authors.jsp").forward(request, response);
    }
}