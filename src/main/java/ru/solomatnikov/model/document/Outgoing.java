package ru.solomatnikov.model.document;
/**
 * Класс нужен для описания Исходящего документа
 */
public class Outgoing extends Document {
    /**
     * Установка адресата
     */
    private String addressName;
    /**
     * Установка способа доставки
     */
    private String delivery;

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "Исходящий" + super.toString();
    }
}