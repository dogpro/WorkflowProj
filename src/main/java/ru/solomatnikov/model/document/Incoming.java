package ru.solomatnikov.model.document;

import ru.solomatnikov.model.Person;

import java.util.Date;

/**
 * Класс нужен для описания Входящего документа.
 */
public class Incoming extends Document {
    /**
     *Установка имени отправителя
     */
    private Person senderName;
    /**
     *Установка имени получателя
     */
    private Person addressName;
    /**
     *Установка номера отправления
     */
    private String sendNumreg;
    /**
     *Установка даты отправления
     */
    private Date sendDate;

    public Person getSenderName() {
        return senderName;
    }

    public void setSenderName(Person senderName) {
        this.senderName = senderName;
    }

    public Person getAddressName() {
        return addressName;
    }

    public void setAddressName(Person addressName) {
        this.addressName = addressName;
    }

    public String getSendNumreg() {
        return sendNumreg;
    }

    public void setSendNumreg(String sendNumreg) {
        this.sendNumreg = sendNumreg;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public String toString() {
        return "Входящий" + super.toString();
    }
}
