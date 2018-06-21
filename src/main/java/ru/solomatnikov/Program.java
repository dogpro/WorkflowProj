package ru.solomatnikov;

import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.factory.DocumentFactory;
import ru.solomatnikov.model.Person;
import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.model.document.Incoming;
import ru.solomatnikov.model.document.Outgoing;
import ru.solomatnikov.model.document.Task;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Random;
import java.util.TreeSet;
import java.util.Collections;

public class Program {

    /**
     * Метод, выполняющий сортировку полученных документов и выводящий результат на экран
     */
    private static void printSortDocument(List<Document> documentList) {
        System.out.println("-----------------------------------");
        System.out.println("\t\tСортировка:");

        Collections.sort(documentList);
        for (Document document : documentList) {
            System.out.println(document.toString());
        }
    }

    /**
     * Метод, выводящий документы, сгрупиированные по автору, на экран
     */
    private static void printReport(Map<Person, TreeSet<Document>> reportMap ) {
        System.out.println("\n----------------------------------");
        System.out.println("\t\tОтчет:");

        for (Map.Entry<Person, TreeSet<Document>> entry : reportMap.entrySet()) {
            Person key = entry.getKey();
            TreeSet<Document> value = entry.getValue();
            System.out.println(key + ":\n" + value.toString().replaceAll("^\\[|]$", " ")
                    .replaceAll(",", "\n"));
        }
    }

    public static void main(String[] args) {
        List<Document> listDocumentToSort = new ArrayList<>();
        Map<Person, TreeSet<Document>> reportOnAuthor = new TreeMap<>();
        List<Class> typeDocument = Arrays.asList(Incoming.class, Outgoing.class, Task.class);

        Document document = null;

        System.out.println("\t\tДобавление документов:");

        //Создание 10 различных документов
        for (int i = 0; i < 10; i++) {
            Class type = typeDocument.get(new Random().nextInt(typeDocument.size()));
            try {
                //Получение в переменную document нового документа
                document = DocumentFactory.getDocument(type);
                //Добавление документа в отдельный список для демонстрации сортировки
                listDocumentToSort.add(document);
                //Вывод полученного документа на экран в отфарматированном виде
                System.out.println("Документ №" + document.getIdDocument() + " от " + document.getAuthorDocument().getShortName() + ": добавлен!");

                //Проверка на существование автора документа и добавление его в отчете
                if (!reportOnAuthor.containsKey(document.getAuthorDocument())){
                    reportOnAuthor.put(document.getAuthorDocument(), new TreeSet<>());
                }
                reportOnAuthor.get(document.getAuthorDocument()).add(document);

            } catch (DocumentExistsException ok) {
                //Вывод полученного документа на экран в отфарматированном виде
                System.out.println("Документ №" + document.getIdDocument() + " от " + document.getAuthorDocument().getShortName() + ": Document Exits Exception");
            }
        }

        //Вызов печати сортировки документов
        printSortDocument(listDocumentToSort);
        //Вызов печати отчета документа по их авторам
        printReport(reportOnAuthor);
    }
}