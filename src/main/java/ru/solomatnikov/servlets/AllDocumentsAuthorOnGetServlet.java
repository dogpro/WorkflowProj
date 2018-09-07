package ru.solomatnikov.servlets;

import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.service.ServerProcessing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class AllDocumentsAuthorOnGetServlet extends HttpServlet {

    public static List<Document> doc1 = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    /**
     * Get запрос, возвращающий все документы конкретного автора по его ID
     * @param request Запрос
     * @param response Ответ
     * @throws ServletException Исключение на случай ошибки в выполнении сервлета
     * @throws IOException Исключение на случай ошибки при работе с файлом *.jsp
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Получение ID автора из URL
        Long id = Long.valueOf(request.getParameter("id"));
        //Получение списка документов одного автора по ID
        ServerProcessing serverProcessing = new ServerProcessing();
        TreeSet<Document> documents = serverProcessing.getDocumentOnAuthor(id);
        doc1 = new ArrayList<>(documents);
        request.setAttribute("document", documents);
        request.getRequestDispatcher("/documents.jsp").forward(request, response);

    }
}