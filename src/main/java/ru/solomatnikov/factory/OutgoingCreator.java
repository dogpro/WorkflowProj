package ru.solomatnikov.factory;

import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.model.document.Incoming;
import ru.solomatnikov.model.document.Outgoing;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OutgoingCreator extends Creator<Outgoing> {

    /**
     * Метод для завполнения полей документа рандомнынми значениями
     * @return документ типа Исходящие
     */
    @Override
    public Outgoing getDocument() {
        Outgoing document = super.getDocument();

        String deliveryAndAddressName = AUTHOR_LIST.get(RANDOM.nextInt(AUTHOR_LIST.size()));

        //Создание объекта Исходящие заполнение полей объекта
        document.setAddressName(deliveryAndAddressName);
        document.setDelivery(deliveryAndAddressName);

        return document;
    }

    @Override
    protected Outgoing initDocument() {
        return new Outgoing();
    }
}