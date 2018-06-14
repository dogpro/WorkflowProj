package ru.solomatnikov.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class IncomingCreator extends Creator {

    private static final Random RANDOM = new Random();
    private static final List<String> AUTHOR_LIST = Arrays.asList("user1", "user2", "user3", "user4");

    /**
     * Метод для завполнения полей документа рандомнынми значениями
     * @return документ типа Входящие
     */
   @Override
   public Document getDocumentType() {
       String senderAndAdresName = AUTHOR_LIST.get(RANDOM.nextInt(AUTHOR_LIST.size()));
       Date date = new Date(Math.abs(System.currentTimeMillis() - RANDOM.nextLong()));

       //Создание объекта Исходящие заполнение полей объекта
       Document document = new Incoming();
       ((Incoming) document).setSenderName(senderAndAdresName);
       ((Incoming) document).setAdresName(senderAndAdresName);
       ((Incoming) document).setSendNumreg(String.valueOf(RANDOM.nextInt(100000000)+1));
       ((Incoming) document).setSendDate(date);

        return document;
   }
}