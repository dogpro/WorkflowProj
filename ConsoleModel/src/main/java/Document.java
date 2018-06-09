
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class Document implements Comparable<Document>, Storable {
    private String id_doc;
    private String name_doc;
    private String text_doc;
    private Long regnum_doc;
    private Date date_doc;
    private String author_doc;

    public Document() {

    }


    public int compareTo(Document o) {
        return date_doc.compareTo(o.date_doc);
    }

    public Document(String id_doc, String name_doc, String text_doc, long regnum_doc, Date date_doc, String author_doc) {
        this.id_doc = id_doc;
        this.name_doc = name_doc;
        this.text_doc = text_doc;
        this.regnum_doc = regnum_doc;
        this.date_doc = date_doc;
        this.author_doc = author_doc;
    }

    @Override
    public String toString() {
        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        return  " №" + id_doc +
                " oт " + f.format(date_doc)+
                ". " + name_doc;

    }
}
