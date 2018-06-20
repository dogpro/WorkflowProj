package ru.solomatnikov.factory;

import ru.solomatnikov.model.Person;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "PersonList")
public class Config {

    private List<Person> personList = new ArrayList<>();

    public List<Person> getPersonList() {
        return personList;
    }

    @XmlElement(name="person")
    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
