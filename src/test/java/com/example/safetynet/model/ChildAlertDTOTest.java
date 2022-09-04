package com.example.safetynet.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChildAlertDTOTest {

    private ChildAlertDTO underTest;

    @BeforeEach
    void setUp() {
        underTest = new ChildAlertDTO(
                "Mustang",
                "Mustang",
                6,
                null
        );
    }

    @Test
    void getFirstName() {
        assertEquals("Mustang", underTest.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Mustang", underTest.getLastName());
    }

    @Test
    void getAge() {
        assertEquals(6, underTest.getAge());

    }

    @Test
    void getFamilyMembers() {
        assertEquals(null, underTest.getFamilyMembers());
    }

    @Test
    void setFirstName() {
        underTest.setFirstName("Mus");
        assertEquals("Mus", underTest.getFirstName());
    }

    @Test
    void setLastName() {
        underTest.setLastName("Mus");
        assertEquals("Mus", underTest.getLastName());
    }

    @Test
    void setAge() {
        underTest.setAge(1);
        assertEquals(1, underTest.getAge());
    }

    @Test
    void setFamilyMembers() {
        underTest.setFirstName(null);
        assertEquals(null, underTest.getFamilyMembers());
    }
}