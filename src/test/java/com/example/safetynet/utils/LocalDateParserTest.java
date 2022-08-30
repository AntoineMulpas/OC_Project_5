package com.example.safetynet.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LocalDateParserTest {

    @Test
    void dateParser() {
        String dateToParseFromMethod = "01/01/2022";
        String dateToCompareWith = "2022-01-01";
        assertEquals(LocalDateParser.dateParser(dateToParseFromMethod), LocalDate.parse(dateToCompareWith));
    }
}