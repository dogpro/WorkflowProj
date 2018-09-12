package ru.solomatnikov.controller;

import ru.solomatnikov.factory.Config;
import ru.solomatnikov.model.Staff.Person;
import ru.solomatnikov.service.ServerProcessing;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.time.Period;
import java.util.List;
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
    public static List getAuthor() throws IOException {
        Config<Person> config = new ServerProcessing().getDataInDBFromXML("Persons.xml");
        return config.getAny();
    }

    /**
     * Метод, возвращающий список документов по переданному в строку идентификатору
     * @param id Идентификатор автора
     * @return Список документов
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public TreeSet getDocumentByAuthor(@PathParam("id") Long id) {
        return new ServerProcessing().getDocumentsByAuthor(id);
    }
}

