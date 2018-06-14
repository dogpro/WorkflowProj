package ru.solomatnikov;

import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.factory.FabricDocument;
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

    private static final Random RANDOM = new Random();
    private static final List<Class> typeDocument = Arrays.asList(Incoming.class, Outgoing.class, Task.class);
    private static Map<String, TreeSet<Document>> reportMap = new TreeMap<String, TreeSet<Document>>();
    private static List<Document> listDocumentToSort = new ArrayList<Document>();

    //Вывод на экран отсротированного документа
    private static void printSortDocument() {
        System.out.println("\t\tСортировка:");
        Collections.sort(listDocumentToSort);
        for (Document doc : listDocumentToSort) {
            System.out.println(doc.toString());
        }
    }

    //Печать отчета документа
    private static void printReport() {
        System.out.println("\t\tОтчет:");
        for (Map.Entry<String, TreeSet<Document>> entry : reportMap.entrySet()) {
            String key = entry.getKey();
            TreeSet<Document> value = entry.getValue();
            System.out.println(key + ":\n" + value.toString().replaceAll("^\\[|\\]$", " ")
                    .replaceAll(",", "\n"));
        }
    }

    public static void main(String[] args) throws DocumentExistsException {
        Class type;
        Document document = null;
        FabricDocument fdocument = new FabricDocument();
        System.out.println("\t\tДобавление документов:");

        //Создание 10 различных документов
        for (int i = 0; i < 10; i++) {
            type = typeDocument.get(RANDOM.nextInt(typeDocument.size()));
            try {
                //Получение в переменную document нового документа
                document = fdocument.getDocument(type);
                //Добавление документа в отдельный список для демонстрации сортировки
                listDocumentToSort.add(document);
                System.out.println("Документ №" + document.getIdDoc() + " от " + document.getAuthorDoc() + ": добавлен!");

                //Проверка на существование автора документа в отчете
                if (!reportMap.containsKey(document.getAuthorDoc())){
                    //Создание нового ключа - автора с пустым списком документов
                    reportMap.put(document.getAuthorDoc(), new TreeSet<Document>());
                }
                //Добавление документа к уже существующему автору
                reportMap.get(document.getAuthorDoc()).add(document);

            } catch (DocumentExistsException ok) {
                System.out.println("Документ №" + document.getIdDoc() + " от " + document.getAuthorDoc() + ": Document Exits Exception");
            }
        }

        System.out.println("-----------------------------------");
        //Вызов печати сортировки документов
        printSortDocument();

        System.out.println("\n----------------------------------");
        //Вызов печати отчета документа по их авторам
        printReport();
    }
}