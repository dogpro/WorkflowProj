package ru.solomatnikov.factory;

import ru.solomatnikov.model.Person;
import ru.solomatnikov.model.document.Incoming;

import java.util.Date;

public class IncomingCreator extends Creator<Incoming> {

    /**
     * Метод для завполнения полей документа рандомнынми значениями
     * @return документ типа Входящие
     */
   @Override
   public Incoming getDocument() {
       Incoming document = super.getDocument();

       Config config = getDateBaseFromXML("C:\\Users\\Student\\Desktop\\Persons.xml", Person.class);
       Person senderAndAddressName = config.getPersonList().get(RANDOM.nextInt(config.getPersonList().size()));
       Date date = new Date(Math.abs(System.currentTimeMillis() - RANDOM.nextLong()));

       //Создание объекта Исходящие заполнение полей объекта
       document.setNameDocument("Исходий документ");
       document.setTextDocument("Этот документ - Исходящий");
       document.setSender(senderAndAddressName);
       document.setAddressee(senderAndAddressName);
       document.setNumRegSender(String.valueOf(RANDOM.nextInt(100000000)+1));
       document.setSenderDate(date);

       return document;
   }

    @Override
    protected Incoming initDocument() {
        return new Incoming();
    }
}