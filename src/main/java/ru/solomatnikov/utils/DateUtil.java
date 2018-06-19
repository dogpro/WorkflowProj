package ru.solomatnikov.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    /**
     * Метод, принимающий дату и возвращаюй ее в формате 01.01.2011
     * @param date Дата
     * @return Форматированная дата
     */
    public static String dateUtil(Date date){
        DateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        return simpleDateFormat.format(date);
    }
}
