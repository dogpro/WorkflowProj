package ru.solomatnikov.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Deprecated
public class getDocumentOnAuthorServlet extends HttpServlet {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/xml");
        PrintWriter out = resp.getWriter();
        Long id = Long.valueOf(req.getParameter("id"));

       /* for (Map.Entry<Person, TreeSet<Document>> entry : ServerProcessing.reportOnAuthor.entrySet()) {
            Person key = entry.getKey();
            TreeSet<Document> documents = entry.getValue();

            if (key.getId().equals(id)) {
                out.print(gson.toJson(documents));
            }
        }*/
    }
}

