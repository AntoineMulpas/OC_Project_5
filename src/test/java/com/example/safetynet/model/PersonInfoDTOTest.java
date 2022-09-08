package com.example.safetynet.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonInfoDTOTest {

    private PersonInfoDTO underTest;

    @BeforeEach
    void setUp() {
        underTest = new PersonInfoDTO(
                "mustang",
                "rue",
                6,
                "gmail",
                null,
                null
        );
    }



    @Test
    void getLastName() {
        assertEquals("mustang", underTest.getLastName());
    }

    @Test
    void getAddress() {
        assertEquals("rue", underTest.getAddress());
    }

    @Test
    void getAge() {
        assertEquals(6, underTest.getAge());
    }

    @Test
    void getEmail() {
        assertEquals("gmail", underTest.getEmail());
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
    void setLastName() {
        String mus = "mus";
        underTest.setLastName(mus);
        assertEquals(mus, underTest.getLastName());
    }

    @Test
    void setAddress() {
        String boulevard = "boulevard";
        underTest.setAddress(boulevard);
        assertEquals(boulevard, underTest.getAddress());
    }

    @Test
    void setAge() {
        underTest.setAge(1);
        assertEquals(1, underTest.getAge());
    }

    @Test
    void setEmail() {
        underTest.setEmail("outlook");
        assertEquals("outlook", underTest.getEmail());
    }

    @Test
    void setMedications() {
        List<String> medications = List.of("doliprane");
        underTest.setMedications(medications);
        assertEquals(medications, underTest.getMedications());
    }

    @Test
    void setAllergies() {
        List<String> allergies = List.of("pollens");
        underTest.setAllergies(allergies);
        assertEquals(allergies, underTest.getAllergies());
    }
}