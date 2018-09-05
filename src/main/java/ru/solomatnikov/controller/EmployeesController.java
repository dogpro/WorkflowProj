package ru.solomatnikov.controller;

import ru.solomatnikov.factory.Config;
import ru.solomatnikov.model.Staff.Person;
import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.model.document.Incoming;
import ru.solomatnikov.service.ServerProcessing;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

@Path("/employees")
public class EmployeesController {

    /**
     * Метод, который возвращает спсиок всех авторов
     * @return Список авторов
     * @throws IOException Исключение на случай ошибки пути к XML файлу
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAuthor() throws IOException {
        Config config = new ServerProcessing().getDateBaseFromXML(Person.class);
        return config.getPersonList();
    }

    /**
     * Метод, возвращающий список документов по переданному в строку идентификатору
     * @param id Идентификатор автора
     * @return Список документов
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public TreeSet<Document> getDocumentByAuthor(@PathParam("id") Long id) {
        return new ServerProcessing().getDocumentOnAuthor(id);
    }
}

