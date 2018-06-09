import javax.print.Doc;
import java.lang.reflect.Array;
import java.util.*;

public class Program {

    private static Map<String, ArrayList<Document>> ReportMap = new TreeMap<String, ArrayList<Document>>();
    private static ArrayList<Document> arrDoc = new ArrayList<Document>();


    static FabricDocument fdocument = new FabricDocument(){
        public String getAuthor(){
            return author;
        }

        public String getId() {
            return id;
        }
    };


    private static void printSortRegnum(){
        System.out.println("\t\tСортировка по дате:");
        Collections.sort(arrDoc);
        for (Document doc : arrDoc){
            System.out.print(doc.toString().replaceAll("\t", ""));
        }
    }

    private static void printReport(){
        System.out.println("\t\tОтчет:");
        for(Map.Entry<String, ArrayList<Document>> entry : ReportMap.entrySet()) {
            String key = entry.getKey();
            List<Document> value = entry.getValue();
            System.out.println(key + ":\n" + value.toString().replaceAll("^\\[|\\]$", "").replaceAll(",",""));
        }
    }


    public static void main(String[] args) {

        Random rand = new Random();
        ArrayList<String> typeDoc = new ArrayList<String>(){{
            add("task");
            add("incoming");
            add("outgoing");
        }};

        String type;
        Document document = null;
        String author;
        System.out.println("\t\tДобавление документов:");
        for (int i = 0; i < 10; i++) {
            try {
                type = typeDoc.get(rand.nextInt(typeDoc.size() - 1));
                document = FabricDocument.getDocument(type);
                arrDoc.add(document);

                author = fdocument.getAuthor();

                if (!ReportMap.containsKey(author)){
                    ReportMap.put(author, new ArrayList<Document>());
                }
                ReportMap.get(author).add(document);

                System.out.println("Документ №" + fdocument.getId() + " от " + author + ": добавлен!");
            } catch (DocumentExistsException e) {
                author = fdocument.getAuthor();
                System.out.println("Документ №" + fdocument.getId() + " от " + author + ": Document Exits Exception");
            }
        }
        System.out.println("-----------------------------------");
        printSortRegnum();
        System.out.println("\n----------------------------------");
        printReport();
    }
}
