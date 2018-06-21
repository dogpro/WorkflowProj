package ru.solomatnikov.model.document;
import ru.solomatnikov.interfaces.Storable;
import ru.solomatnikov.model.Person;
import ru.solomatnikov.utils.DateUtils;

import java.util.Date;

/**
 * Класс нуден для описания документа
 */
public abstract class Document implements Comparable<Document>, Storable {
    /**
     * Создание поля для номера документа
     */
    private Long id;
    /**
     * Создание поля для имени документа
     */
    private String name;
    /**
     * Создание поля для текста документа
     */
    private String text;
    /**
     * Создание поля для номера регистрации
     */
    private Long registrationNumber;
    /**
     * Создание поля для даты создания документа
     */
    private Date creationDate;
    /**
     * Создание поля для автора документа
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
        //Условие на проверку равенства дат
        if (creationDate.compareTo(document.creationDate) == 0) {
            //Если равны, сортировать по регистрационному номеру
            return registrationNumber.compareTo(document.registrationNumber);
        } else {
            //Если не равны, сортировать по дате
            return creationDate.compareTo(document.creationDate);
        }
    }
    
    @Override
    public String toString() {
        return  " №" + id +
                " oт " + DateUtils.formatDate(creationDate) +
                ". " + name;
    }
}