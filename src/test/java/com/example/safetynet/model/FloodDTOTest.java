package com.example.safetynet.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloodDTOTest {

    private  FloodDTO underTest;

    @BeforeEach
    void setUp() {
        underTest = new FloodDTO(
                "rue",
                new FloodPersonInfoDTO(
                        "Mus",
                        "1",
                        6,
                        null
                )
        );
    }

    @Test
    void testEquals() {
        FloodDTO toCompare = new FloodDTO(
                "rue",
                new FloodPersonInfoDTO(
                        "Mus",
                        "1",
                        6,
                        null
                )
        );
        assertTrue(underTest.equals(toCompare));
    }

    @Test
    void canEqual() {
        FloodDTO toCompare = new FloodDTO(
                "rue",
                new FloodPersonInfoDTO(
                        "Mus",
                        "1",
                        6,
                        null
                )
        );
        assertTrue(underTest.equals(toCompare));
    }

    @Test
    void testHashCode() {
    }

    @Test
    void getAddress() {
        assertEquals("rue", underTest.getAddress());
    }

    @Test
    void getFloodPersonInfoDTO() {
        FloodPersonInfoDTO floodPersonInfoDTO = new FloodPersonInfoDTO(
                "Mus",
                "1",
                6,
                null
        );
        assertEquals(floodPersonInfoDTO, underTest.getFloodPersonInfoDTO());
    }

    @Test
    void setAddress() {
        underTest.setAddress("boulevard");
        assertEquals("boulevard", underTest.getAddress());
    }

    @Test
    void setFloodPersonInfoDTO() {
        FloodPersonInfoDTO floodPersonInfoDTO = new FloodPersonInfoDTO(
                "Mustang",
                "1",
                6,
                null
        );
        underTest.setFloodPersonInfoDTO(floodPersonInfoDTO);
        assertEquals(floodPersonInfoDTO, underTest.getFloodPersonInfoDTO());
    }
}