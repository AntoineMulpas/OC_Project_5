package com.example.safetynet.repository;

import com.example.safetynet.model.FireStation;
import com.example.safetynet.model.MedicalRecord;
import com.example.safetynet.model.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository underTest;
    @Autowired
    private MedicalRecordsRepostiory medicalRecordsRepostiory;
    @Autowired
    private FireStationRepository fireStationRepository;
    private Person person;
    private Person person2;
    private MedicalRecord medicalRecord;
    private FireStation fireStation;

    @BeforeEach
    void setUp() {
        person = new Person(
                1L,
                "Antoine",
                "Antoine",
                "1 rue",
                "Lille",
                "59000",
                "06",
                "email@email.com"
        );
        underTest.save(person);

        person2 = new Person(
                2L,
                "Pauline",
                "Pauline",
                "1 rue",
                "Lille",
                "59000",
                "07",
                "gmail@email.com"
        );
        underTest.save(person2);

        person2 = new Person(
                3L,
                "Mustang",
                "Mustang",
                "2 rue",
                "Lille",
                "59000",
                "07",
                "gmailgmail@email.com"
        );
        underTest.save(person2);

        medicalRecord = new MedicalRecord(
                1L,
                "Antoine",
                "Antoine",
                "1992-03-29",
                null,
                null
        );
        medicalRecordsRepostiory.save(medicalRecord);

        fireStation = new FireStation(
                1L,
                "1 rue",
                "1"
        );
        fireStationRepository.save(fireStation);

    }

    @AfterEach
    void tearDown() {
        person = null;
        person2 = null;
        medicalRecord = null;
    }

    @Test
    void deleteByFirstNameEqualsAndLastNameEquals() {
        // given
        // when
        underTest.deleteByFirstNameEqualsAndLastNameEquals(person.getFirstName(), person.getLastName());
        // then
        assertTrue(underTest.findById(1L).isEmpty());
    }

    @Test
    void getEmailForAllPeopleLivingInSpecificCity() {
        String email = "email@email.com";
        assertTrue(underTest.getEmailForAllPeopleLivingInSpecificCity("Lille").contains(email));
    }

    @Test
    void getLastNameAndAddressAndAgeAndEmailAndMedicalRecordsForAPerson() {

    }

    @Test
    void getFirstNameAndLastNameAndAddressAndPhoneNumberOfPersonsCoveredBySpecificFireStation() {
        assertEquals(2, underTest.getFirstNameAndLastNameAndAddressAndPhoneNumberOfPersonsCoveredBySpecificFireStation("1").size());
    }

    @Test
    void getStationAndInhabitantsInformationByAddress() {
    }

    @Test
    void getAllPersonsBySpecificFirstNameAndLastName() {
        String firstName = "Antoine";
        String lastName = "Antoine";
        assertEquals(1, underTest.getAllPersonsBySpecificFirstNameAndLastName(firstName, lastName).size());
    }

    @Test
    void getListOfPersonLivingAtSpecificAddress() {
        String address = "1 rue";
        assertEquals(2, underTest.getListOfPersonLivingAtSpecificAddress(address).size());
    }
}