package ru.solomatnikov.model.document;

import ru.solomatnikov.model.Person;

/**
 * Класс нужен для описания Исходящего документа
 */
public class Outgoing extends Document {
    /**
     * Создание поля для адресата
     */
    private Person addressName;
    /**
     * Создание поля для способа доставки
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
}