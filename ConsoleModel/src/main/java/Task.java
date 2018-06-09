import java.time.LocalDate;
import java.util.Date;

public class Task extends Document {
    private Date date_task;
    private int date_perform;
    private String executer;
    private int control;
    private String control_assig;

    public Task(String id_doc, String name_doc, String text_doc, long regnum_doc, Date date_doc, String author_doc, Date date_task, int date_perform, String executer, int control, String control_assig) {
        super(id_doc, name_doc, text_doc, regnum_doc, date_doc, author_doc);
        this.date_task = date_task;
        this.date_perform = date_perform;
        this.executer = executer;
        this.control = control;
        this.control_assig = control_assig;
    }


    @Override
    public String toString() {
        return "\t" +  "Поручение" + super.toString() + "\n";
    }
}
