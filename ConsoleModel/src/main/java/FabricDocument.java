import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FabricDocument{

    private static Random rand = new Random();
    private static int counter = 0;
    private static Map<Integer, String> map = new HashMap<Integer, String>();
    private static ArrayList<String> authorList = new ArrayList<String>(){{
        add("user1");
        add("user2");
        add("user3");
        add("user4");
    }};

    static String id;
    private static String name_doc;
    private static String text_doc;
    private static long regnum_doc;
    private static Date date_doc;
    private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
    static String author;

    private static boolean isIdExits(String id) {
        return (map.containsValue(id));
    }

    private static void randDocValGenerate(){
        id = String.valueOf(rand.nextInt(10)+1);
        name_doc = "Название документа";
        text_doc = "Текст документ...";
        regnum_doc = rand.nextInt(10000)+1;
        date_doc = new Date(Math.abs(System.currentTimeMillis() - rand.nextLong()));
        author = authorList.get(rand.nextInt(authorList.size()));
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public static Document getDocument(String type) throws DocumentExistsException{

        randDocValGenerate();
        if(isIdExits(id)) {
            throw new DocumentExistsException();
        }
        else{
            map.put(counter, id);
            counter++;
        }


        if(type.equals("task")) {
            ArrayList<String> executerList = new ArrayList<String>(){{
                add("executer1");
                add("executer2");
                add("executer3");
                add("executer4");
            }};

            ArrayList<String> controlAssignList = new ArrayList<String>(){{
                add("Да");
                add("Нет");
            }};

            int date_perform = rand.nextInt(20)+1;
            String executer = executerList.get(rand.nextInt(executerList.size()));
            int control = rand.nextInt(10)+1;
            String control_assign = controlAssignList.get(rand.nextInt(controlAssignList.size()));
            Date date = new Date(Math.abs(System.currentTimeMillis() - rand.nextLong()));
            return new Task(id, name_doc, text_doc, regnum_doc, date_doc, author, date, date_perform, executer, control, control_assign);
        }
        else{
            if(type.equals("incoming")){
                String sender_name = authorList.get(rand.nextInt(authorList.size()));
                String address_name = authorList.get(rand.nextInt(authorList.size()));
                String sender_numreg = String.valueOf(rand.nextInt(100000000)+1);
                Date date = new Date(Math.abs(System.currentTimeMillis() - rand.nextLong()));
                return new Incoming(id, name_doc, text_doc, regnum_doc, date_doc, author, sender_name, address_name, sender_numreg, date);
            }
            else{
                if(type.equals("outgoing")){
                    String address_name = authorList.get(rand.nextInt(authorList.size()));
                    String delivery = authorList.get(rand.nextInt(authorList.size()));

                    return new Outgoing(id, name_doc, text_doc, regnum_doc, date_doc, author, address_name, delivery);
                }
            }
        }
        return null;


    }
}
