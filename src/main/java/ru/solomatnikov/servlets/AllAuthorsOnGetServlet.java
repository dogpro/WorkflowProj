package ru.solomatnikov.servlets;

import ru.solomatnikov.factory.Config;
import ru.solomatnikov.model.Staff.Person;
import ru.solomatnikov.service.ServerProcessing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllAuthorsOnGetServlet extends HttpServlet {

    private ServerProcessing serverProcessing = new ServerProcessing();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }

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
        serverProcessing.getDocument();
        //Генерация авторов из XML файла
        Config config = new ServerProcessing().getDateBaseFromXML(Person.class);
        List<Person> persons = config.getPersonList();

        request.setAttribute("persons", persons);
        request.getRequestDispatcher("/authors.jsp").forward(request, response);
    }
}