package ru.solomatnikov;

import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.factory.DocumentFactory;
import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.model.document.Incoming;
import ru.solomatnikov.model.document.Outgoing;
import ru.solomatnikov.model.document.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

public class Program {

    public static String fileName;
    public static final Map<Integer, Long> documentIdMap = new HashMap<>();
    public static int counter = 0;
    /**
     * Метод, выполняющий сортировку полученных документов и выводящий результат на экран
     */
    private static void printSortDocument(List<Document> documentList) {
        System.out.println("-----------------------------------");
        System.out.println("\t\tСортировка:");

        Collections.sort(documentList);
        for (Document document : documentList) {
            System.out.println(document);
        }
    }

    /**
     * Метод, выводящий документы, сгрупиированные по автору, на экран
     */
    private static void printReport(Map<String, TreeSet<Document>> reportMap ) {


        System.out.println("\n----------------------------------");
        System.out.println("\t\tОтчет:");

        for (Map.Entry<String, TreeSet<Document>> entry : reportMap.entrySet()) {
            String key = entry.getKey();
            TreeSet<Document> value = entry.getValue();
            System.out.println(key + ":\n" + value.toString().replaceAll("^\\[|]$", " ")
                    .replaceAll(",", "\n"));
        }
    }


    public static void main(String[] args) {
        fileName = args[0];
        List<Document> listDocumentToSort = new ArrayList<>();
        Map<String, TreeSet<Document>> reportOnAuthor = new TreeMap<>();
        List<Class> typeDocument = Arrays.asList(Incoming.class, Outgoing.class, Task.class);

        System.out.println("\t\tДобавление документов:");

        //Создание 10 различных документов
        for (int i = 0; i < 10; i++) {
            Class type = typeDocument.get(new Random().nextInt(typeDocument.size()));

            try {
                //Получение в переменную document нового документа
                Document document = DocumentFactory.getDocument(type);
                String author = document.getAuthor().getShortName();
                if(document != null){
                    //Добавление авторов и списка документов в лист для отчета
                    if (!reportOnAuthor.containsKey(author)){
                        reportOnAuthor.put(author, new TreeSet<>());
                    }
                    reportOnAuthor.get(author).add(document);

                    //Добавлени документов в лист для демонстрации сортировки
                    listDocumentToSort.add(document);

                    System.out.println("Документ №" + document.getId() + " от " + author + ": добавлен!");
                }
            } catch (DocumentExistsException dEX) {
                //Вывод сообщения об ошибке на случай повторяющегося идентификатора
                System.out.println(dEX.getMessage());
            }
        }

        //Вызов печати сортировки документов
        printSortDocument(listDocumentToSort);
        //Вызов печати отчета документа по их авторам
        printReport(reportOnAuthor);
    }
}