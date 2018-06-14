package ru.solomatnikov.model;

import ru.solomatnikov.interfaces.Storable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Класс нуден для описания документа
 */
public abstract class Document implements Comparable<Document>, Storable {
    /**
     * Установка номера документа
     */
    private String idDoc;
    /**
     * Установка имени документа
     */
    private String nameDoc;
    /**
     * Установка текста документа
     */
    private String textDoc;
    /**
     * Установка номера регистрации
     */
    private Long regnumDoc;
    /**
     * Установка даты создания документа
     */
    private Date dateDoc;
    /**
     * Установка автора документа
     */
    private String authorDoc;

    public Document() { }

    public String getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public String getNameDoc() {
        return nameDoc;
    }

    public void setNameDoc(String nameDoc) {
        this.nameDoc = nameDoc;
    }

    public String getTextDoc() {
        return textDoc;
    }

    public void setTextDoc(String textDoc) {
        this.textDoc = textDoc;
    }

    public Long getRegnumDoc() {
        return regnumDoc;
    }

    public void setRegnumDoc(Long regnumDoc) {
        this.regnumDoc = regnumDoc;
    }

    public Date getDateDoc() {
        return dateDoc;
    }

    public void setDateDoc(Date dateDoc) {
        this.dateDoc = dateDoc;
    }

    public String getAuthorDoc() {
        return authorDoc;
    }

    public void setAuthorDoc(String authorDoc) {
        this.authorDoc = authorDoc;
    }

    public int compareTo(Document o) {
        //Условие на проверку равенства дат
        if (dateDoc.compareTo(o.dateDoc) == 0) {
            //Если равны, сортировать по регистрационному номеру
            return regnumDoc.compareTo(o.regnumDoc);
        } else {
            //Если не равны, сортировать по дате
            return dateDoc.compareTo(o.dateDoc);
        }
    }

    /**
     * Печать полей документа
     * @return Вывод всех полей Документа вместе с типом этого документа
     */
    @Override
    public String toString() {
        return  " №" + idDoc +
                " oт " + dateUtil(dateDoc) +
                ". " + nameDoc;
    }

    /**
     * Метод, принимающий дату и возвращаюй ее в формате 01.01.2011
     * @param date Дата
     * @return Форматированная дата
     */
    private static String dateUtil(Date date){
        DateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        return simpleDateFormat.format(date);
    }
}