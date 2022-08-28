package com.example.safetynet.service;

import com.example.safetynet.repository.FireStationRepository;
import com.example.safetynet.repository.MedicalRecordsRepostiory;
import com.example.safetynet.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonCoveredByFireStationServiceTest {


    private PersonCoveredByFireStationService underTest;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private MedicalRecordsRepostiory medicalRecordsRepostiory;
    @Autowired
    private FireStationRepository fireStationRepository;

    @BeforeEach
    void setUp() {
        underTest = new PersonCoveredByFireStationService(personRepository, fireStationRepository, medicalRecordsRepostiory);
    }

    @Test
    void getPersonCoveredByFireStation() {
        underTest.getPersonCoveredByFireStation("1");
    }
}