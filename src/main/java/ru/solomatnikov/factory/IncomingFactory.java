package ru.solomatnikov.factory;

import ru.solomatnikov.DAO.PersonDAO;
import ru.solomatnikov.exception.DBSelectExitsException;
import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.model.Staff.Person;
import ru.solomatnikov.model.document.Incoming;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class IncomingFactory extends Factory<Incoming> {

    /**
     * Метод для завполнения полей документа рандомнынми значениями
     * @return Документ типа Входящие
     * @throws DocumentExistsException Исключение на случай создания документа с уже существующим идентификатором
     * @throws IOException Исключение на случай ошибки в работе с файлом
     */
   @Override
   public Incoming getDocument() throws DocumentExistsException, IOException, DBSelectExitsException {
       Incoming document = super.getDocument();
       PersonDAO personDAO = PersonDAO.getInstance();
       List<Person> personList = personDAO.select();
       Person senderName = personList.get(RANDOM.nextInt(personList.size()));
       Person addresseeName = personList.get(RANDOM.nextInt(personList.size()));

       //Создание объекта Исходящие заполнение полей объекта
       document.setName("Входящий документ");
       document.setText("Этот документ - Входящий");
       document.setSender(senderName);
       document.setAddressee(addresseeName);
       document.setRegistrationNumberSender(String.valueOf(RANDOM.nextInt(100000000)+1));
       document.setSenderDate(new Date(Math.abs(System.currentTimeMillis() - RANDOM.nextLong())));

       return document;
   }

    @Override
    protected Incoming initialize() {
        return new Incoming();
    }
}