package ru.solomatnikov.factory;

import ru.solomatnikov.model.Person;
import ru.solomatnikov.model.document.Document;
import ru.solomatnikov.model.document.Incoming;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
       document.setSenderName(senderAndAddressName);
       document.setAddressName(senderAndAddressName);
       document.setSendNumreg(String.valueOf(RANDOM.nextInt(100000000)+1));
       document.setSendDate(date);

       return document;
   }

    @Override
    protected Incoming initDocument() {
        return new Incoming();
    }
}