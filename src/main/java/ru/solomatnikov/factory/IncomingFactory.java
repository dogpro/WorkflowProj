package ru.solomatnikov.factory;

import ru.solomatnikov.exception.DocumentExistsException;
import ru.solomatnikov.model.Person;
import ru.solomatnikov.model.document.Incoming;

import java.util.Date;

public class IncomingFactory extends Factory<Incoming> {

    /**
     * Метод для завполнения полей документа рандомнынми значениями
     * @return документ типа Входящие
     */
   @Override
   public Incoming getDocument() throws DocumentExistsException {
       Incoming document = super.getDocument();
       Person senderName = config.getPersonList().get(RANDOM.nextInt(config.getPersonList().size()));
       Person addresseeName = config.getPersonList().get(RANDOM.nextInt(config.getPersonList().size()));

       //Создание объекта Исходящие заполнение полей объекта
       document.setName("Исходящий документ");
       document.setText("Этот документ - Исходящий");
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