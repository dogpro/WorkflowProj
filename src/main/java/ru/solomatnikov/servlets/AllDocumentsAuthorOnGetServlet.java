package ru.solomatnikov.servlets;

import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.service.ServerProcessing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class AllDocumentsAuthorOnGetServlet extends HttpServlet {

    public static List<Document> documents = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Context HttpServletRequest request;
    /**
     * Get запрос, возвращающий все документы конкретного автора по его ID
     * @param request Запрос
     * @param response Ответ
     * @throws ServletException Исключение на случай ошибки в выполнении сервлета
     * @throws IOException Исключение на случай ошибки при работе с файлом *.jsp
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServerProcessing serverProcessing = new ServerProcessing();
        //Получение ID автора из URL
        Long id = Long.valueOf(request.getParameter("id"));
        //Получение списка документов одного автора по ID
        TreeSet<Document> documents = serverProcessing.getDocumentsByAuthor(id);
        AllDocumentsAuthorOnGetServlet.documents = new ArrayList<>(documents);

        request.setAttribute("document", documents);
        request.getRequestDispatcher("/documents.jsp").forward(request, response);

    }
}