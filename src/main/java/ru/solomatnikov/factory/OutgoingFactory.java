package ru.solomatnikov.factory;

import ru.solomatnikov.DAO.PersonDAO;
import ru.solomatnikov.exception.DBSelectExitsException;
import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.model.Staff.Person;
import ru.solomatnikov.model.document.Outgoing;

import java.io.IOException;
import java.util.List;

public class OutgoingFactory extends Factory<Outgoing> {

    /**
     * Метод для завполнения полей документа рандомнынми значениями
     * @return Документ типа Исходящие
     * @throws DocumentExistsException Исключение на случай создания документа с уже существующим идентификатором
     * @throws IOException Исключение на случай ошибки в работе с файлом
     */
    @Override
    public Outgoing getDocument() throws DocumentExistsException, IOException, DBSelectExitsException {
        Outgoing document = super.getDocument();
        PersonDAO personDAO = PersonDAO.getInstance();
        List<Person> personList = personDAO.select();
        Person deliveryName = personList.get(RANDOM.nextInt(personList.size()));
        Person addresseeName = personList.get(RANDOM.nextInt(personList.size()));

        //Создание объекта Исходящие заполнение полей объекта
        document.setName("Исходящий документ");
        document.setText("Этот документ - Исходящий");
        document.setAddressName(deliveryName);
        document.setDelivery(addresseeName);

        return document;
    }

    @Override
    protected Outgoing initialize() {
        return new Outgoing();
    }
}