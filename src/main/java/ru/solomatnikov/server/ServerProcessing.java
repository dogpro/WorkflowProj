package ru.solomatnikov.server;

import ru.solomatnikov.Program;
import ru.solomatnikov.exception.FileNotFoundException;
import ru.solomatnikov.factory.Config;
import sun.misc.IOUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ServerProcessing {

    public static InputStream getPersonFromXML() {
        InputStream inputStream = ServerProcessing.class.getClassLoader().getResourceAsStream("Persons.xml");
        return inputStream;

    }
}
