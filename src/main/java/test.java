import ru.solomatnikov.model.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class test {
    public static void main(String[] args) throws JAXBException {

            File file = new File("C:\\Users\\Student\\Desktop\\Persons.xml");
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Person person = (Person) unmarshaller.unmarshal(file);
            System.out.println(person);

    }
}
