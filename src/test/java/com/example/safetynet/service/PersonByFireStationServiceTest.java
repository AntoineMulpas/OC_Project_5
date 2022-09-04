package com.example.safetynet.service;

import com.example.safetynet.model.Person;
import com.example.safetynet.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonByFireStationServiceTest {

    private PersonByFireStationService underTest;
    @Mock
    private PersonRepository personRepository;
    private Person person;

    @BeforeEach
    void setUp() {
        underTest = new PersonByFireStationService(personRepository);
        person = new Person(
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
    void getFirstNameAndLastNameAndAddressAndPhoneForPersonsCoveredByFireStation() {
        assertEquals(0, underTest.getFirstNameAndLastNameAndAddressAndPhoneForPersonsCoveredByFireStation("1").size());
    }
}