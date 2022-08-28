package com.example.safetynet.utils;

import java.time.LocalDate;

public class LocalDateParser {

    public static LocalDate dateParser(String date) {
        String getMonthFromDate = date.substring(0, date.indexOf("/"));
        String getDayFromDate = date.substring(date.indexOf("/") + 1, 5);
        String getYearFromDate = date.substring(6);
        String dateToParse = getYearFromDate + "-" + getMonthFromDate + "-" + getDayFromDate;
        return LocalDate.parse(dateToParse);
    }

}
