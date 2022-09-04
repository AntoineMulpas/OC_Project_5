package com.example.safetynet.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonCoveredByFireStationDTOTest {

    private PersonCoveredByFireStationDTO underTest;


    @BeforeEach
    void setUp() {
        underTest = new PersonCoveredByFireStationDTO(
                "Mus",
                "Mus",
                "rue",
                "1",
                new CountOfPersonDTO(
                        10L,
                        5L
                )
        );
    }

    @Test
    void getFirstName() {
        assertEquals("Mus", underTest.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Mus", underTest.getLastName());
    }

    @Test
    void getAddress() {
        assertEquals("rue", underTest.getAddress());
    }

    @Test
    void getPhone() {
        assertEquals("1", underTest.getPhone());
    }

    @Test
    void getCountOfPersonDTO() {
        CountOfPersonDTO countOfPersonDTO = new CountOfPersonDTO(
                10L,
                5L
        );
        assertEquals(countOfPersonDTO.getAdultCount(), underTest.getCountOfPersonDTO().getAdultCount());
    }

    @Test
    void setFirstName() {
        underTest.setFirstName("Mustang");
        assertEquals("Mustang", underTest.getFirstName());
    }

    @Test
    void setLastName() {
        underTest.setLastName("Mustang");
        assertEquals("Mustang", underTest.getLastName());
    }

    @Test
    void setAddress() {
        underTest.setAddress("boulevard");
        assertEquals("boulevard", underTest.getAddress());
    }

    @Test
    void setPhone() {
        underTest.setPhone("123");
        assertEquals("123", underTest.getPhone());
    }

    @Test
    void setCountOfPersonDTO() {
        CountOfPersonDTO countOfPersonDTO = new CountOfPersonDTO(
                20L,
                10L
        );
        underTest.setCountOfPersonDTO(countOfPersonDTO);
        assertEquals(countOfPersonDTO.getAdultCount(), underTest.getCountOfPersonDTO().getAdultCount());
    }
}