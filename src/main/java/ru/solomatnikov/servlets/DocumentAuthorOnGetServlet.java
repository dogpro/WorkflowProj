package ru.solomatnikov.servlets;

import ru.solomatnikov.service.ServerProcessing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import java.io.IOException;

public class DocumentAuthorOnGetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Context HttpServletRequest request;
    /**
     * Get запрос, возвращающий поля документа
     * @param request  Запрос
     * @param response Ответ
     * @throws ServletException Исключение на случай ошибки в выполнении сервлета
     * @throws IOException Исключение на случай ошибки при работе с файлом *.jsp
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServerProcessing serverProcessing = new ServerProcessing();
        Long id = Long.valueOf(request.getParameter("id"));

        request.setAttribute("document", serverProcessing.getDocumentByAuthor(id));
        request.getRequestDispatcher("/documentField.jsp").forward(request, response);

    }
}





