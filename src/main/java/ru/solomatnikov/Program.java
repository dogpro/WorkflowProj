package ru.solomatnikov;

import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.factory.DocumentFactory;
import ru.solomatnikov.model.Person;
import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.model.document.Incoming;
import ru.solomatnikov.model.document.Outgoing;
import ru.solomatnikov.model.document.Task;

import java.util.*;

public class Program {

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
            System.out.println(document.toString());
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
        List<Document> listDocumentToSort = new ArrayList<>();
        Map<String, TreeSet<Document>> reportOnAuthor = new TreeMap<>();
        List<Class> typeDocument = Arrays.asList( Task.class);

        Document document;

        System.out.println("\t\tДобавление документов:");

        //Создание 10 различных документов
        for (int i = 0; i < 10; i++) {
            Class type = typeDocument.get(new Random().nextInt(typeDocument.size()));
            try {
                //Получение в переменную document нового документа
                document = DocumentFactory.getDocument(type);

                if(document != null){
                    if (!reportOnAuthor.containsKey(document.getAuthor().getShortName())){
                        reportOnAuthor.put(document.getAuthor().getShortName(), new TreeSet<>());
                    }
                    reportOnAuthor.get(document.getAuthor().getShortName()).add(document);

                    listDocumentToSort.add(document);

                    System.out.println("Документ №" + document.getId() + " от " + document.getAuthor().getShortName() + ": добавлен!");
                }
            } catch (DocumentExistsException ok) {
                //Вывод полученного документа на экран в отфарматированном виде
                System.out.println(ok.getMessage());
            }
        }

        //Вызов печати сортировки документов
        printSortDocument(listDocumentToSort);
        //Вызов печати отчета документа по их авторам
        printReport(reportOnAuthor);
    }
}