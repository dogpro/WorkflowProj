import java.time.LocalDate;
import java.util.Date;

public class Incoming extends Document {
    String sender_name;
    String adres_name;
    String send_numreg;
    Date send_date;

    public Incoming(String id_doc, String name_doc, String text_doc, long regnum_doc, Date date_doc, String author_doc, String sender_name, String adres_name, String send_num, Date send_date) {
        super(id_doc, name_doc, text_doc, regnum_doc, date_doc, author_doc);
        this.sender_name = sender_name;
        this.adres_name = adres_name;
        this.send_numreg = send_num;
        this.send_date = send_date;
    }

    @Override
    public String toString() {
        return "\t" +  "Входящий" + super.toString() + "\n";
    }
}
