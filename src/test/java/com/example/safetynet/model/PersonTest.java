package com.example.safetynet.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person underTest;

    @BeforeEach
    void setUp() {
        underTest = new Person(
                1L,
                "Antoine",
                "Antoine",
                "1 rue",
                "Lille",
                "59000",
                "07",
                "email@email.com"
        );
    }

    @Test
    void testEquals() {
        Person person = new Person(
                1L,
                "Antoine",
                "Antoine",
                "1 rue",
                "Lille",
                "59000",
                "07",
                "email@email.com"
        );
        assertEquals(person, underTest);
    }

    @Test
    void Equals() {
        Person person = new Person(
                1L,
                "Antoine",
                "Antoine",
                "1 rue",
                "Lille",
                "59000",
                "07",
                "email@email.com"
        );
        assertTrue(underTest.equals(person));
    }

    @Test
    void canEqual() {
        Person person = new Person(
                1L,
                "Antoine",
                "Antoine",
                "1 rue",
                "Lille",
                "59000",
                "07",
                "email@email.com"
        );
        assertEquals(person, underTest);
    }

    @Test
    void testHashCode() {
        Person person = new Person(
                1L,
                "Antoine",
                "Antoine",
                "1 rue",
                "Lille",
                "59000",
                "07",
                "email@email.com"
        );
        assertEquals(underTest.hashCode(), person.hashCode());
    }

    @Test
    void testHashCodeReturnFalse() {
        Person person = new Person(
                1L,
                "Antonio",
                "Antoine",
                "1 rue",
                "Lille",
                "59000",
                "07",
                "email@email.com"
        );
        assertNotEquals(underTest.hashCode(), person.hashCode());
    }


    @Test
    void setId() {
        underTest.setId(2L);
        assertEquals(2L, (long) underTest.getId());
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
    void setCity() {
        underTest.setCity("Roubaix");
        assertEquals("Roubaix", underTest.getCity());
    }

    @Test
    void setZip() {
        underTest.setZip("1000");
        assertEquals("1000", underTest.getZip());
    }

    @Test
    void setPhone() {
        underTest.setPhone("03");
        assertEquals("03", underTest.getPhone());
    }

    @Test
    void setEmail() {
        underTest.setEmail("@gmail.com");
        assertEquals("@gmail.com", underTest.getEmail());
    }
}