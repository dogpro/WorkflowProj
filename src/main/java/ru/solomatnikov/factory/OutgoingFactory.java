package ru.solomatnikov.factory;

import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.model.Staff.Person;
import ru.solomatnikov.model.document.Outgoing;

import java.io.IOException;

public class OutgoingFactory extends Factory<Outgoing> {

    /**
     * Метод для завполнения полей документа рандомнынми значениями
     * @return Документ типа Исходящие
     * @throws DocumentExistsException Исключение на случай создания документа с уже существующим идентификатором
     * @throws IOException Исключение на случай ошибки в работе с файлом
     */
    @Override
    public Outgoing getDocument() throws DocumentExistsException, IOException {
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