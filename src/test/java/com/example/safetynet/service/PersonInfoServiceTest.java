package com.example.safetynet.service;

import com.example.safetynet.model.MedicalRecord;
import com.example.safetynet.model.Person;
import com.example.safetynet.repository.MedicalRecordsRepostiory;
import com.example.safetynet.repository.PersonRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonInfoServiceTest {

    @Mock
    private PersonRepository personRepository;
    @Mock
    private MedicalRecordsRepostiory medicalRecordsRepostiory;
    private PersonInfoService underTest;
    private Person person;

    @BeforeEach
    void setUp() {
        underTest = new PersonInfoService(personRepository, medicalRecordsRepostiory);
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
    void getPersonInfoOfAnInhabitant() {
        String[] medications = {"1", "2"};
        List<MedicalRecord> list = new ArrayList<>();
        String[] allergies = {"1, 2"};
        list.add(new MedicalRecord(
                1L,
                "Antoine",
                "Antoine",
                "03/29/1992",
                medications,
                allergies
        ));
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        when(personRepository.getAllPersonsBySpecificFirstNameAndLastName(anyString(), anyString())).thenReturn(personList);
        when(medicalRecordsRepostiory.getMedicalRecordsForSpecificFirstNameAndLastName(anyString(), anyString())).thenReturn(list);
        assertEquals("Antoine", underTest.getPersonInfoOfAnInhabitant("Antoine", "Antoine").get(0).getLastName());
    }

    @Test
    void getPersonInfoOfAnInhabitantWhereFirstNameNotEquals() {
        String[] medications = {"1", "2"};
        List<MedicalRecord> list = new ArrayList<>();
        String[] allergies = {"1, 2"};
        list.add(new MedicalRecord(
                1L,
                "Mustang",
                "Antoine",
                "03/29/1992",
                medications,
                allergies
        ));
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        when(personRepository.getAllPersonsBySpecificFirstNameAndLastName(anyString(), anyString())).thenReturn(personList);
        when(medicalRecordsRepostiory.getMedicalRecordsForSpecificFirstNameAndLastName(anyString(), anyString())).thenReturn(list);
        assertEquals(0, underTest.getPersonInfoOfAnInhabitant("Antoine", "Antoine").size());
    }

    @Test
    void getPersonInfoOfAnInhabitantWhereLastNameNotEquals() {
        String[] medications = {"1", "2"};
        List<MedicalRecord> list = new ArrayList<>();
        String[] allergies = {"1, 2"};
        list.add(new MedicalRecord(
                1L,
                "Antoine",
                "Mus",
                "03/29/1992",
                medications,
                allergies
        ));
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        when(personRepository.getAllPersonsBySpecificFirstNameAndLastName(anyString(), anyString())).thenReturn(personList);
        when(medicalRecordsRepostiory.getMedicalRecordsForSpecificFirstNameAndLastName(anyString(), anyString())).thenReturn(list);
        assertEquals(0, underTest.getPersonInfoOfAnInhabitant("Antoine", "Antoine").size());
    }
}