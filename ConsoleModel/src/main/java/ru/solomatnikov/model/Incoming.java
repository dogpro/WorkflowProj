package ru.solomatnikov.model;

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
    private String adresName;
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

    public String getAdresName() {
        return adresName;
    }

    public void setAdresName(String adresName) {
        this.adresName = adresName;
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

    /**
     * Печать полей документа
     * @return Вывод всех полей Документа вместе с типом этого документа
     */
    @Override
    public String toString() {
        return "Входящий" + super.toString();
    }
}
