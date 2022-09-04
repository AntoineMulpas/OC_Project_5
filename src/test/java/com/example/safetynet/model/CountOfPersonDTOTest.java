package com.example.safetynet.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountOfPersonDTOTest {

    private CountOfPersonDTO underTest;

    @BeforeEach
    void setUp() {
        underTest = new CountOfPersonDTO(
                10L,
                5L
        );
    }

    @Test
    void getAdultCount() {
        assertEquals(10L, underTest.getAdultCount());
    }

    @Test
    void getChildCount() {
        assertEquals(5L, underTest.getChildCount());
    }

    @Test
    void setAdultCount() {
        underTest.setAdultCount(20L);
        assertEquals(20L, underTest.getAdultCount());
    }

    @Test
    void setChildCount() {
        underTest.setChildCount(10L);
        assertEquals(10L, underTest.getChildCount());
    }
}