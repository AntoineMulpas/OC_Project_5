package com.example.safetynet.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
    void testEquals() {
        PersonInfoDTO toCompare = new PersonInfoDTO(
                "mustang",
                "rue",
                6,
                "gmail",
                null,
                null
        );
        assertTrue(underTest.equals(toCompare));
    }

    @Test
    void canEqual() {
        PersonInfoDTO toCompare = new PersonInfoDTO(
                "mustang",
                "rue",
                6,
                "gmail",
                null,
                null
        );
        assertTrue(underTest.canEqual(toCompare));
    }

    @Test
    void testHashCode() {
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
        assertEquals(null, underTest.getMedications());
    }

    @Test
    void getAllergies() {
        assertEquals(null, underTest.getAllergies());
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
        List<String> medications = Arrays.asList("doliprane");
        underTest.setMedications(medications);
        assertEquals(medications, underTest.getMedications());
    }

    @Test
    void setAllergies() {
        List<String> allergies = Arrays.asList("pollens");
        underTest.setAllergies(allergies);
        assertEquals(allergies, underTest.getAllergies());
    }
}