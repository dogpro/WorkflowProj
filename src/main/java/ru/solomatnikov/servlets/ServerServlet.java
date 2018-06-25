package ru.solomatnikov.servlets;

import ru.solomatnikov.factory.Config;
import ru.solomatnikov.model.Person;
import ru.solomatnikov.server.ServerProcessing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet("/ecm/employees")
public class ServerServlet extends HttpServlet {
    ServerProcessing serverProcessing = new ServerProcessing();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        InputStream inputStream = ServerProcessing.getPersonFromXML();
        out.println(inputStream);
    }
}
