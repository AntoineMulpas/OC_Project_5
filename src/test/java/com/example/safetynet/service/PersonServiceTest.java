package com.example.safetynet.service;

import com.example.safetynet.model.Person;
import com.example.safetynet.repository.PersonRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;
    private PersonService underTest;
    private Person person;

    @BeforeEach
    void setUp() {
        underTest = new PersonService(personRepository);
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

    @AfterEach
    void tearDown() {
        underTest = null;
    }

    @Test
    void addAPerson() {
        underTest.addAPerson(person);
        ArgumentCaptor<Person> personArgumentCaptor =
                ArgumentCaptor.forClass(Person.class);
        verify(personRepository).save(personArgumentCaptor.capture());

        Person personArgumentCaptorValue = personArgumentCaptor.getValue();
        assertThat(personArgumentCaptorValue).isEqualTo(person);
    }

    @Test
    void getAllPerson() {
        underTest.getAllPerson();
        verify(personRepository).findAll();
    }

    @Test
    void deleteAPerson() {
        underTest.deleteAPerson("Antoine", "Antoine");
        verify(personRepository).deleteByFirstNameEqualsAndLastNameEquals("Antoine", "Antoine");
    }

    @Test
    @Disabled
    void updateAPerson() {

    }

    @Test
    void getEmailForAllPeopleLivingInSpecificCity() {
        underTest.getEmailForAllPeopleLivingInSpecificCity("Culver");
        verify(personRepository).getEmailForAllPeopleLivingInSpecificCity("Culver");
    }

    @Test
    void getLastNameAndAddressAndAgeAndEmailAndMedicalRecordsForAPerson() {
        underTest.getLastNameAndAddressAndAgeAndEmailAndMedicalRecordsForAPerson("Antoine", "Antoine");
        verify(personRepository).getLastNameAndAddressAndAgeAndEmailAndMedicalRecordsForAPerson("Antoine", "Antoine");
    }
}