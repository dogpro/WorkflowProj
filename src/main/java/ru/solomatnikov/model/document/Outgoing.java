package ru.solomatnikov.model.document;
/**
 * Класс нужен для описания Исходящего документа
 */
public class Outgoing extends Document {
    /**
     * Установка адресата
     */
    private String addresName;
    /**
     * Установка способа доставки
     */
    private String delivery;

    public String getAddresName() {
        return addresName;
    }

    public void setAddresName(String addresName) {
        this.addresName = addresName;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    /**
     * Печать полей документа
     * @return Вывод всех полей Документа вместе с типом этого документа
     */
    @Override
    public String toString() {
        return "Исходящий" + super.toString();
    }
}