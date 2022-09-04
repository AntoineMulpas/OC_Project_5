package com.example.safetynet.service;

import com.example.safetynet.model.FireStation;
import com.example.safetynet.model.MedicalRecord;
import com.example.safetynet.model.Person;
import com.example.safetynet.repository.FireStationRepository;
import com.example.safetynet.repository.MedicalRecordsRepostiory;
import com.example.safetynet.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FireServiceTest {

    private FireService underTest;
    @Mock
    private PersonRepository personRepository;
    @Mock
    private MedicalRecordsRepostiory medicalRecordsRepostiory;
    @Mock
    private FireStationRepository fireStationRepository;
    private Person person;

    @BeforeEach
    void setUp() {
        underTest = new FireService(personRepository, medicalRecordsRepostiory, fireStationRepository);
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
    void getStationAndInhabitantsInformationByAddress() {
        FireStation fireStation = new FireStation(
                1L,
                "1 rue",
                "1"
        );
        String[] medications = {"1", "2"};
        String[] allergies = {"1, 2"};
        MedicalRecord medicalRecord = new MedicalRecord(
                1L,
                "Antoine",
                "Antoine",
                "03/29/1992",
                medications,
                allergies
        );
        List<Person> personList = new ArrayList<>();

        personList.add(person);
        when(personRepository.getListOfPersonLivingAtSpecificAddress(anyString())).thenReturn(personList);
        when(medicalRecordsRepostiory.findByLastNameEqualsAndFirstNameEquals(anyString(), anyString())).thenReturn(medicalRecord);
        when(fireStationRepository.findByAddressEquals(person.getAddress())).thenReturn(fireStation);
        assertEquals(person.getPhone(), underTest.getStationAndInhabitantsInformationByAddress(person.getAddress()).get(0).getPhone());
    }
}