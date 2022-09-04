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
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FloodServiceTest {

    private FloodService underTest;
    @Mock
    private PersonRepository personRepository;
    @Mock
    private FireStationRepository fireStationRepository;
    @Mock
    private MedicalRecordsRepostiory medicalRecordsRepostiory;
    private Person person;
    private FireStation fireStation;
    private FireStation fireStation1;

    @BeforeEach
    void setUp() {

        underTest = new FloodService(personRepository, fireStationRepository, medicalRecordsRepostiory);
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
        fireStation = new FireStation(1L, "1 rue", "1");
        fireStation1 = new FireStation(2L, "1 rue", "2");
    }

    @Test
    void getPersonsInformationByStationInCaseOfFlood() {
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        List<FireStation> fireStationList = new ArrayList<>();
        fireStationList.add(fireStation);
        fireStationList.add(fireStation1);
        MedicalRecord medicalRecord = new MedicalRecord(
                1L,
                "Antoine",
                "Antoine",
                "03/29/1992",
                null,
                null
        );

        when(fireStationRepository.findByStationEquals(fireStation.getStation())).thenReturn(fireStationList);
        when(personRepository.getListOfPersonLivingAtSpecificAddress(person.getAddress())).thenReturn(personList);
        when(medicalRecordsRepostiory.findByLastNameEqualsAndFirstNameEquals(medicalRecord.getLastName(), medicalRecord.getFirstName())).thenReturn(medicalRecord);
        List <String> stationsList = Arrays.asList("1", "2");
        assertEquals(30, underTest.getPersonsInformationByStationInCaseOfFlood(stationsList).get(0).getFloodPersonInfoDTO().getAge());
    }
}