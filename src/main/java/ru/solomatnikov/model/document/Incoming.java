package ru.solomatnikov.model.document;

import ru.solomatnikov.model.Staff.Person;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Класс нужен для описания Входящего документа.
 */
@XmlRootElement(name ="Incoming")
public class Incoming extends Document {
    /**
     * Имя отправителя
     */
    private Person sender;
    /**
     * Имя получателя
     */
    private Person addressee;
    /**
     * Номер отправления
     */
    private String registrationNumberSender;
    /**
     * Дата отправления
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

    public String getRegistrationNumberSender() {
        return registrationNumberSender;
    }

    public void setRegistrationNumberSender(String registrationNumberSender) {
        this.registrationNumberSender = registrationNumberSender;
    }

    public Date getSenderDate() {
        return senderDate;
    }

    public void setSenderDate(Date senderDate) {
        this.senderDate = senderDate;
    }

    @Override
    public String toString() {
        return "Исходящий: " +
                " Отправитель: " + sender +
                ", Получатель: " + addressee +
                ", Регистрационный номер отправителя: " + registrationNumberSender +
                ", Дата отправки: " + senderDate +
                  super.toString();
    }

    @Override
    public String getStoreName() {
        return "Incoming";
    }
}
