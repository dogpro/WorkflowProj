import java.time.LocalDate;
import java.util.Date;

public class Outgoing extends Document {
    String addres_name;
    String delivery;

    public Outgoing(String id_doc, String name_doc, String text_doc, long regnum_doc, Date date_doc, String author_doc, String addres_name, String delivery) {
        super(id_doc, name_doc, text_doc, regnum_doc, date_doc, author_doc);
        this.addres_name = addres_name;
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "\t" + "Исходящий" + super.toString() + "\n";
    }
}
