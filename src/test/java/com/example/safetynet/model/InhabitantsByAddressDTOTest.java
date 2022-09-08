package com.example.safetynet.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InhabitantsByAddressDTOTest {

    private InhabitantsByAddressDTO underTest;

    @BeforeEach
    void setUp() {
        underTest = new InhabitantsByAddressDTO(
                "mustang",
                "07",
                6,
                new MedicalRecord(
                        1L,
                        "mustang",
                        "mustang",
                        "2016",
                        null,
                        null
                ),
                "1"
        );
    }

    @Test
    void getLastName() {
        assertEquals("mustang", underTest.getLastName());
    }

    @Test
    void getPhone() {
        assertEquals("07", underTest.getPhone());
    }

    @Test
    void getAge() {
        assertEquals(6, underTest.getAge());
    }

    @Test
    void getMedicalRecord() {
    }

    @Test
    void getStation() {
    }

    @Test
    void setLastName() {
    }

    @Test
    void setPhone() {
    }

    @Test
    void setAge() {
    }

    @Test
    void setMedicalRecord() {
    }

    @Test
    void setStation() {
    }
}