package ru.solomatnikov.model.document;

import ru.solomatnikov.model.Person;

import java.util.Date;

/**
 * Класс нужен для описания Входящего документа.
 */
public class Incoming extends Document {
    /**
     * Создание поля для имени отправителя
     */
    private Person sender;
    /**
     * Создание поля для имени получателя
     */
    private Person addressee;
    /**
     * Создание поля для номера отправления
     */
    private String numRegSender;
    /**
     * Создание поля для даты отправления
     */
    private Date senderDate;

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Person getAddressee() {
        return addressee;
    }

    public void setAddressee(Person addressee) {
        this.addressee = addressee;
    }

    public String getNumRegSender() {
        return numRegSender;
    }

    public void setNumRegSender(String numRegSender) {
        this.numRegSender = numRegSender;
    }

    public Date getSenderDate() {
        return senderDate;
    }

    public void setSenderDate(Date senderDate) {
        this.senderDate = senderDate;
    }

    @Override
    public String toString() {
        return "Входящий" + super.toString();
    }
}
