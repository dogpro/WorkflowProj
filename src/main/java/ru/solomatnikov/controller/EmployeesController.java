package ru.solomatnikov.controller;

import ru.solomatnikov.DAO.PersonDAO;
import ru.solomatnikov.exception.DBCreateExitsException;
import ru.solomatnikov.exception.DBDeleteExitsException;
import ru.solomatnikov.exception.DBSelectByIdExitsException;
import ru.solomatnikov.exception.DBSelectExitsException;
import ru.solomatnikov.exception.DBUpdateExitsException;
import ru.solomatnikov.exception.DocumentsNullPointerException;
import ru.solomatnikov.model.Staff.Person;
import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.service.ServerProcessing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Path("/persons")
public class EmployeesController {

    public static List<Document> documents = new ArrayList<>();

    /**
     * Метод, который возвращает спсиок всех авторов
     *
     * @throws IOException Исключение на случай ошибки пути к XML файлу
     */
    @GET
    public void getAuthor(@Context HttpServletRequest request, @Context HttpServletResponse response) throws IOException, ServletException, DBSelectExitsException {
        //Генерация авторов из XML файла
        //Config<Person> config = new ServerProcessing().getDataInDBFromXML("Persons.xml");
        PersonDAO personDAO = PersonDAO.getInstance();
        List<Person> personList = personDAO.select();
        request.setAttribute("persons", personList);
        request.getRequestDispatcher("/authors.jsp").forward(request, response);
    }


    /**
     * Метод, возвращающий список документов по переданному в строку идентификатору
     *
     * @param id Идентификатор автора
     * @return Список документов
     */
    @GET
    @Path("documents/{id}")
    public void getDocumentsByAuthor(@Context HttpServletRequest request, @Context HttpServletResponse response,
                                     @PathParam("id") Long id) throws ServletException, IOException, DocumentsNullPointerException {
        ServerProcessing serverProcessing = new ServerProcessing();
        //Получение ID автора из URL
        //Получение списка документов одного автора по ID
        TreeSet<Document> documents = serverProcessing.getDocumentsByAuthor(id);
        if (documents != null) {
            EmployeesController.documents = new ArrayList<>(documents);

            request.setAttribute("document", documents);
            request.getRequestDispatcher("/documents.jsp").forward(request, response);
        } else {
            throw new DocumentsNullPointerException("Documents not found");
        }
    }

    @GET
    @Path("document/{id}")
    public void getDocumentByAuthor(@Context HttpServletRequest request, @Context HttpServletResponse response,
                                    @PathParam("id") Long id) throws ServletException, IOException {
        ServerProcessing serverProcessing = new ServerProcessing();

        request.setAttribute("document", serverProcessing.getDocumentByAuthor(id));
        request.getRequestDispatcher("/documentField.jsp").forward(request, response);

    }

    @POST
    @Consumes("application/json")
    @Path("createAuthor/")
    public static void createPerson(@Context HttpServletRequest request, @Context HttpServletResponse response, Person body)
            throws DBCreateExitsException {
        PersonDAO personDAO = PersonDAO.getInstance();
        personDAO.create(body);
    }

    @GET
    @Consumes("application/json")
    @Path("update/{id}")
    public void viewPerson(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("id") Long id)
            throws ServletException, IOException, DBSelectExitsException, DBSelectByIdExitsException {

        PersonDAO personDAO = PersonDAO.getInstance();
        for(Person person : personDAO.getById(id)){
            request.setAttribute("person", person);
            request.getRequestDispatcher("/viewAuthor.jsp").forward(request, response);
        }

    }

    @POST
    @Consumes("application/json")
    @Path("update/")
    public void updatePerson(@Context HttpServletRequest request, @Context HttpServletResponse response, Person body)
            throws DBUpdateExitsException {
        PersonDAO personDAO = PersonDAO.getInstance();
        personDAO.update(body, body.getId());
    }

    @POST
    @Consumes("application/json")
    @Path("update/delete")
    public void deleteUser(@Context HttpServletRequest request, @Context HttpServletResponse response, Person body)
            throws DBDeleteExitsException {
        PersonDAO personDAO = PersonDAO.getInstance();
        personDAO.delete(body.getId());
    }
}

