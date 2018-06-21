package ru.solomatnikov.factory;

import ru.solomatnikov.model.Person;
import ru.solomatnikov.model.document.Outgoing;

public class OutgoingCreator extends Creator<Outgoing> {

    /**
     * Метод для завполнения полей документа рандомнынми значениями
     * @return документ типа Исходящие
     */
    @Override
    public Outgoing getDocument() {
        Outgoing document = super.getDocument();
        Config config = getDateBaseFromXML("C:\\Users\\Student\\Desktop\\Persons.xml", Person.class);
        Person deliveryAndAddressName = config.getPersonList().get(RANDOM.nextInt(config.getPersonList().size()));

        //Создание объекта Исходящие заполнение полей объекта
        document.setNameDocument("Входящий документ");
        document.setTextDocument("Этот документ - Входящий");
        document.setAddressName(deliveryAndAddressName);
        document.setDelivery(deliveryAndAddressName);

        return document;
    }

    @Override
    protected Outgoing initDocument() {
        return new Outgoing();
    }
}