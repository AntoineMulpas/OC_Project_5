package com.example.safetynet.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireStationTest {

    private FireStation underTest;

    @BeforeEach
    void setUp() {
        underTest = new FireStation(
                1L,
                "rue",
                "1"
        );
    }

    @Test
    void testEquals() {
        FireStation toCompare = new FireStation(
                1L,
                "rue",
                "1"
        );
        assertTrue(underTest.equals(toCompare));
    }

    @Test
    void canEqual() {
        FireStation toCompare = new FireStation(
                1L,
                "rue",
                "1"
        );
        assertTrue(underTest.canEqual(toCompare));
    }

    @Test
    void testHashCode() {
        FireStation toCompare = new FireStation(
                1L,
                "rue",
                "1"
        );
        assertEquals(underTest.hashCode(), toCompare.hashCode());
    }

    @Test
    void testHashCodeNotEquals() {
        FireStation toCompare = new FireStation(
                1L,
                "boulevard",
                "1"
        );
        assertNotEquals(underTest.hashCode(), toCompare.hashCode());
    }

    @Test
    void getId() {
        assertEquals(1L, underTest.getId());
    }

    @Test
    void getAddress() {
        assertEquals("rue", underTest.getAddress());
    }

    @Test
    void getStation() {
        assertEquals("1", underTest.getStation());
    }

    @Test
    void setId() {
        underTest.setId(2L);
        assertEquals(2L, underTest.getId());
    }

    @Test
    void setAddress() {
        underTest.setAddress("boulevard");
        assertEquals("boulevard", underTest.getAddress());
    }

    @Test
    void setStation() {
        underTest.setStation("2");
        assertEquals("2", underTest.getStation());
    }
}