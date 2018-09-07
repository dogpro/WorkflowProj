package ru.solomatnikov.model.document;
import ru.solomatnikov.model.interfaces.Storable;
import ru.solomatnikov.model.Staff.Person;
import ru.solomatnikov.utils.DateUtils;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Класс нуден для описания документа
 */
@XmlRootElement(name ="Document")
public abstract class Document implements Comparable<Document>, Storable {
    /**
     * Номер документа
     */
    private Long id;
    /**
     * Имя документа
     */
    private String name;
    /**
     * Текс документа
     */
    private String text;
    /**
     * Номер регистрации
     */
    private Long registrationNumber;
    /**
     * Дата создания документа
     */
    private Date creationDate;
    /**
     * Автор документа
     */
    private Person author;

    public Document() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDateT) {
        this.creationDate = creationDateT;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public int compareTo(Document document) {
        int compareToDate = creationDate.compareTo(document.creationDate);
        //Условие на проверку равенства дат
        if (compareToDate == 0) {
            //Если равны, сортировать по регистрационному номеру
            return registrationNumber.compareTo(document.registrationNumber);
        } else {
            //Если не равны, сортировать по дате
            return creationDate.compareTo(document.creationDate);
        }
    }
    
    /*@Override
    public String toString() {
        return  " №" + id +
                " oт " + DateUtils.formatDate(creationDate) +
                ". " + name + "  = " + author;
    }*/

    @Override
    public String toString() {
        return  ", Название: " + name + '\'' +
                ", Текст: " + text + '\'' +
                ", Регистрационный номер: " + registrationNumber +
                ", Дата создания: " + creationDate +
                ", Автор документа: " + author;
    }
}