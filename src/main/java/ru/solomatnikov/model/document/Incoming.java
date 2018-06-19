package ru.solomatnikov.model.document;

import java.util.Date;

/**
 * Класс нужен для описания Входящего документа.
 */
public class Incoming extends Document {
    /**
     *Установка имени отправителя
     */
    private String senderName;
    /**
     *Установка имени получателя
     */
    private String addressName;
    /**
     *Установка номера отправления
     */
    private String sendNumreg;
    /**
     *Установка даты отправления
     */
    private Date sendDate;

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
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
