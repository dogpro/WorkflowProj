package ru.solomatnikov.factory;

import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.model.Person;
import ru.solomatnikov.model.document.Outgoing;

public class OutgoingFactory extends Factory<Outgoing> {

    /**
     * Метод для завполнения полей документа рандомнынми значениями
     * @return документ типа Исходящие
     */
    @Override
    public Outgoing getDocument() throws DocumentExistsException {
        Outgoing document = super.getDocument();
        Person deliveryName = config.getPersonList().get(RANDOM.nextInt(config.getPersonList().size()));
        Person addresseeName = config.getPersonList().get(RANDOM.nextInt(config.getPersonList().size()));

        //Создание объекта Исходящие заполнение полей объекта
        document.setName("Входящий документ");
        document.setText("Этот документ - Входящий");
        document.setAddressName(deliveryName);
        document.setDelivery(addresseeName);

        return document;
    }

    @Override
    protected Outgoing initialize() {
        return new Outgoing();
    }
}