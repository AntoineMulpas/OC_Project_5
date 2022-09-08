package com.example.safetynet.service;

import com.example.safetynet.model.FireStation;
import com.example.safetynet.model.MedicalRecord;
import com.example.safetynet.model.Person;
import com.example.safetynet.repository.FireStationRepository;
import com.example.safetynet.repository.MedicalRecordsRepostiory;
import com.example.safetynet.repository.PersonRepository;
import com.example.safetynet.utils.LocalDateParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonCoveredByFireStationServiceTest {

    @Mock
    private PersonRepository personRepository;
    @Mock
    private MedicalRecordsRepostiory medicalRecordsRepostiory;
    @Mock
    private FireStationRepository fireStationRepository;
    @Autowired
    private PersonCoveredByFireStationService underTest;
    private Person person;

    @BeforeEach
    void setUp() {
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
        underTest = new PersonCoveredByFireStationService(personRepository, fireStationRepository, medicalRecordsRepostiory);
    }


    @Test
    void getPersonCoveredByFireStationAgeSuperiorEighteen() {
        String[] medications = {"1", "2"};
        String[] allergies = {"1, 2"};
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        List<FireStation> fireStationList = new ArrayList<>();
        fireStationList.add(new FireStation(
                1L,
                "1 rue",
                "1"
                ));
        when(personRepository.getListOfPersonLivingAtSpecificAddress("1 rue")).thenReturn(personList);
        when(fireStationRepository.getAddressForSpecificStation("1")).thenReturn(fireStationList);
        when(medicalRecordsRepostiory.findByLastNameEqualsAndFirstNameEquals("Antoine", "Antoine")).thenReturn(new MedicalRecord(
                1L,
                "Antoine",
                "Antoine",
                "03/29/1992",
                medications,
                allergies
        ));

        assertEquals("Antoine", underTest.getPersonCoveredByFireStation("1").get(0).getLastName());
    }

    @Test
    void getPersonCoveredByFireStationAgeInferiorEighteen() {
        String[] medications = {"1", "2"};
        String[] allergies = {"1, 2"};
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        List<FireStation> fireStationList = new ArrayList<>();
        fireStationList.add(new FireStation(
                1L,
                "1 rue",
                "1"
        ));
        when(personRepository.getListOfPersonLivingAtSpecificAddress("1 rue")).thenReturn(personList);
        when(fireStationRepository.getAddressForSpecificStation("1")).thenReturn(fireStationList);
        when(medicalRecordsRepostiory.findByLastNameEqualsAndFirstNameEquals("Antoine", "Antoine")).thenReturn(new MedicalRecord(
                1L,
                "Antoine",
                "Antoine",
                "03/29/2019",
                medications,
                allergies
        ));

        assertEquals("Antoine", underTest.getPersonCoveredByFireStation("1").get(0).getLastName());
    }
}