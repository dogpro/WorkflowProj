package ru.solomatnikov;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.factory.DocumentFactory;
import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.model.document.Incoming;
import ru.solomatnikov.model.document.Outgoing;
import ru.solomatnikov.model.document.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
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
    private static final Logger logger = LoggerFactory.getLogger(Program.class);
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static final Map<Integer, Long> documentIdMap = new HashMap<Integer, Long>();
    public static int counter = 0;

    /**
     * Метод, выполняющий сортировку полученных документов и выводящий результат на экран
     * @param documentList Список всех документов
     */
    private static void printSortDocument(List<Document> documentList) {
        System.out.println("-----------------------------------");
        System.out.println("\t\tСортировка:");
        Collections.sort(documentList);
        for (Document document : documentList) {
            logger.debug(document.toString());
        }
    }

    /**
     * Метод, выводящий документы, сгрупиированные по автору, в консоль и записывает их в JSON файл
     * @param reportMap Спсиок документов, распределенный по авторам
     * @throws URISyntaxException Исключение на случай ошибки в пути к файлу
     */
    private static void printReport(Map<String, TreeSet<Document>> reportMap ) throws URISyntaxException {
        System.out.println("\n----------------------------------");
        System.out.println("\t\tОтчет:");

        for (Map.Entry<String, TreeSet<Document>> entry : reportMap.entrySet()) {
            String key = entry.getKey();
            TreeSet<Document> documents = entry.getValue();
            //Создание файла с именем автора
            String pathToFile = (Program.class.getProtectionDomain().getCodeSource().getLocation()
                    .toURI().getPath() + key + ".json");

            try (FileWriter writer = new FileWriter(pathToFile)){
                //Запись документов в созданный файл
                writer.write(gson.toJson(documents) + "\n\n");

            } catch (IOException ex) {
                //Исключение на случай ошибки при создании файла или при записи в него
                logger.error(ex.getMessage());
            }
            //Вывод отчет в консоль
            logger.info(key + ":\n" + documents.toString().replaceAll("^\\[|]$", " ")
                    .replaceAll(",", "\n"));
        }
    }


    public static void main(String[] args) throws URISyntaxException, IOException {
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
                    logger.debug("Документ №{} от {} добавлен!", document.getId(), author);
                }
            } catch (DocumentExistsException dEX) {
                logger.debug(dEX.getMessage());
            }
        }

        //Вызов печати сортировки документов
        printSortDocument(listDocumentToSort);
        //Вызов печати отчета документа по их авторам
        printReport(reportOnAuthor);
    }
}