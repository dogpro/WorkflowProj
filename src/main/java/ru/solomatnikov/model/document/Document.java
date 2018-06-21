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
    private String idDocument;
    /**
     * Создание поля для имени документа
     */
    private String nameDocument;
    /**
     * Создание поля для текста документа
     */
    private String textDocument;
    /**
     * Создание поля для номера регистрации
     */
    private Long regNumDocument;
    /**
     * Создание поля для даты создания документа
     */
    private Date creationDate;
    /**
     * Создание поля для автора документа
     */
    private Person authorDocument;

    public Document() { }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    public String getNameDocument() {
        return nameDocument;
    }

    public void setNameDocument(String nameDocument) {
        this.nameDocument = nameDocument;
    }

    public String getTextDocument() {
        return textDocument;
    }

    public void setTextDocument(String textDocument) {
        this.textDocument = textDocument;
    }

    public Long getRegNumDocument() {
        return regNumDocument;
    }

    public void setRegNumDocument(Long regNumDocument) {
        this.regNumDocument = regNumDocument;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Person getAuthorDocument() {
        return authorDocument;
    }

    public void setAuthorDocument(Person authorDocument) {
        this.authorDocument = authorDocument;
    }

    public int compareTo(Document o) {
        //Условие на проверку равенства дат
        if (creationDate.compareTo(o.creationDate) == 0) {
            //Если равны, сортировать по регистрационному номеру
            return regNumDocument.compareTo(o.regNumDocument);
        } else {
            //Если не равны, сортировать по дате
            return creationDate.compareTo(o.creationDate);
        }
    }
    
    @Override
    public String toString() {
        return  " №" + idDocument +
                " oт " + DateUtils.formatDate(creationDate) +
                ". " + nameDocument;
    }
}