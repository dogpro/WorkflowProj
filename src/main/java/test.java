import ru.solomatnikov.model.Person;
import ru.solomatnikov.model.Staff;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class test {

    public static List<Person> ttt = new ArrayList<>();

    private static void Read(){

    }

    public static void main(String[] args) {

        Staff customer = new Person();
//        customer.setId("1");
//        ((Person) customer).setName("1");
//        ((Person) customer).setSurname("1");
//        ((Person) customer).setLastName("1");
//        ((Person) customer).setPost("1");

//        try {
//            File file = new File("C:\\Users\\Student\\Desktop\\Persons.xml");
//            JAXBContext context = JAXBContext.newInstance(Person.class);
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.marshal(customer, file);
//            marshaller.marshal(customer, System.out);
//        } catch (JAXBException ex) {
//            ex.printStackTrace();
//        }

//        try {
//            File file = new File("C:\\Users\\Student\\Desktop\\Persons.xml");
//            JAXBContext context = JAXBContext.newInstance(ru.solomatnikov.factory.Config.class, Person.class);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            ru.solomatnikov.factory.Config config = (ru.solomatnikov.factory.Config) unmarshaller.unmarshal(file);
//            config.getPersonList().forEach(person -> System.out.println(person));
//        } catch (JAXBException ex) {
//            ex.printStackTrace();
//        }

//
//        for (Person e: ttt){
//            System.out.println(e);
//        }
    }
}
