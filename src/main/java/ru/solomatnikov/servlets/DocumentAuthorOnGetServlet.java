package ru.solomatnikov.servlets;

import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.service.ServerProcessing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class DocumentAuthorOnGetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    /**
     * Get запрос, возвращающий поля документа
     * @param request  Запрос
     * @param response Ответ
     * @throws ServletException Исключение на случай ошибки в выполнении сервлета
     * @throws IOException Исключение на случай ошибки при работе с файлом *.jsp
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));

        for(Document document : AllDocumentsAuthorOnGetServlet.doc1){
            if (document.getId().equals(id)) {
                request.setAttribute("document", document);
                request.getRequestDispatcher("/documentField.jsp").forward(request, response);
            }
        }


//        ServerProcessing serverProcessing = new ServerProcessing();
//        TreeSet<Document> ddd = serverProcessing.getDocumentOnAuthor(id);
//        for (Document dd : ddd) {
//            if (dd.getId().equals(id)) {
//                request.setAttribute("document", dd);
//                request.getRequestDispatcher("/documentField.jsp").forward(request, response);
//            }
//        }
    }
}
        /*List<Document> arrayList = new ArrayList<Document>();
        for (Map.Entry<Long, TreeSet<Document>> entry : ServerProcessing.reportOnAuthor.entrySet()) {
            TreeSet<Document> documents = entry.getValue();
            arrayList = new ArrayList<>(documents);
        }

        for (Document document : arrayList) {
            if (document.getId().equals(id)) {
                request.setAttribute("document", document);
                request.getRequestDispatcher("/documentField.jsp").forward(request, response);
                break;
            }
        }
    }*/




