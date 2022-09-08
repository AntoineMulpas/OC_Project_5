package com.example.safetynet.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicalRecordTest {

    private MedicalRecord underTest;

    @BeforeEach
    void setUp() {
        underTest = new MedicalRecord(
                1L,
                "mustang",
                "mustang",
                "2016-04-06",
                null,
                null
        );
    }

    @Test
    void getId() {
        assertEquals(1L, underTest.getId());
    }

    @Test
    void getFirstName() {
        assertEquals("mustang", underTest.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("mustang", underTest.getLastName());
    }

    @Test
    void getBirthdate() {
        assertEquals("2016-04-06", underTest.getBirthdate());
    }

    @Test
    void getMedications() {
        assertNull(underTest.getMedications());
    }

    @Test
    void getAllergies() {
        assertNull(underTest.getAllergies());
    }

    @Test
    void setId() {
        underTest.setId(2L);
        assertEquals(2L, underTest.getId());
    }

    @Test
    void setFirstName() {
        underTest.setFirstName("mus");
        assertEquals("mus", underTest.getFirstName());
    }

    @Test
    void setLastName() {
        underTest.setLastName("mus");
        assertEquals("mus", underTest.getLastName());
    }

    @Test
    void setBirthdate() {
        underTest.setBirthdate("2022");
        assertEquals("2022", underTest.getBirthdate());
    }

    @Test
    void setMedications() {
        String[] medications = {"ball"};
        underTest.setMedications(medications);
        assertEquals(medications, underTest.getMedications());
    }

    @Test
    void setAllergies() {
        String[] allergies = {"vegetables"};
        underTest.setAllergies(allergies);
        assertEquals(allergies, underTest.getAllergies());
    }
}