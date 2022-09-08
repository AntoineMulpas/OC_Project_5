package com.example.safetynet.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloodMedicalRecordDTOTest {

    private FloodMedicalRecordDTO underTest;

    @BeforeEach
    void setUp() {
        String[] medications = {"doliprane", "gaviscon"};
        String[] allergies = {"pollens"};
        underTest = new FloodMedicalRecordDTO(medications, allergies);
    }



    @Test
    void getMedications() {
        assertEquals(2, underTest.getMedications().length);
    }

    @Test
    void getAllergies() {
        assertEquals(1, underTest.getAllergies().length);
    }

    @Test
    void setMedications() {
        String[] med = {"doliprane"};
        underTest.setMedications(med);
        assertEquals(1, underTest.getMedications().length);
    }

    @Test
    void setAllergies() {
        String[] al = {};
        underTest.setAllergies(al);
        assertEquals(0, underTest.getAllergies().length);
    }
}