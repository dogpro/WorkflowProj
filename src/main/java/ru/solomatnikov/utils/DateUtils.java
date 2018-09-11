package ru.solomatnikov.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    /**
     * Метод, принимающий дату и возвращаюй ее в формате 01.01.2011
     * @param date Дата
     * @return Форматированная дата
     */
    public static String formatDate(Date date){
        return new SimpleDateFormat("dd.MM.yyyy").format(date);
    }
}
