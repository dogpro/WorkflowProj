package ru.solomatnikov.model.document;

import ru.solomatnikov.model.Staff.Person;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Класс нужен для описания Исходящего документа
 */
@XmlRootElement(name ="Outgoing")
public class Outgoing extends Document {
    /**
     *  Адресат
     */
    private Person addressName;
    /**
     * Способ доставки
     */
    private Person delivery;

    public Person getAddressName() {
        return addressName;
    }

    public void setAddressName(Person addressName) {
        this.addressName = addressName;
    }

    public Person getDelivery() {
        return delivery;
    }

    public void setDelivery(Person delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "Исходящий" + super.toString();
    }

    @Override
    public String getStoreName() {
        return "Outgoing";
    }
}