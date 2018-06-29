package ru.solomatnikov.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.solomatnikov.service.ServerProcessing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class getAllAuthorServlet extends HttpServlet {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private ServerProcessing serverProcessing = new ServerProcessing();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }

    /**
     * Сервел для обработки авторов всех документов
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        serverProcessing.getDocument();

       /* if (ServerProcessing.authorList == null)
            throw new FileNotFoundException("File: Person.xml not found");

        out.println(gson.toJson(ServerProcessing.authorList));*/
    }
}
