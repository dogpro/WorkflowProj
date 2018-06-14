package ru.solomatnikov.factory;

import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.model.document.Outgoing;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OutgoingCreator extends Creator {

    private static final Random RANDOM = new Random();
    private static final List<String> AUTHOR_LIST = Arrays.asList("user1", "user2", "user3", "user4");

    /**
     * Метод для завполнения полей документа рандомнынми значениями
     * @return документ типа Исходящие
     */
    @Override
    public Document getDocumentType() {
        String deliveryAndAdresName = AUTHOR_LIST.get(RANDOM.nextInt(AUTHOR_LIST.size()));

        //Создание объекта Исходящие заполнение полей объекта
        Document document = new Outgoing();
        ((Outgoing) document).setAddresName(deliveryAndAdresName);
        ((Outgoing) document).setDelivery(deliveryAndAdresName);

        return document;
    }
}