package com.example.safetynet.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LocalDateParserTest {

    @Test
    void dateParser() {
        LocalDateParser.dateParser("03/06/1984");
    }
}