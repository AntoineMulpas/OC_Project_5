package com.example.safetynet.utils;

import com.example.safetynet.repository.FireStationRepository;
import com.example.safetynet.repository.MedicalRecordsRepostiory;
import com.example.safetynet.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class SavingTheJsonInputToDBTest {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private FireStationRepository fireStationRepository;
    @Autowired
    private MedicalRecordsRepostiory medicalRecordsRepostiory;

    @Test
    void gettingAndSavingDataFromJsonInputIntoDB() {
        SaveJsonInputToDB savingTheJsonInputToDB = new SaveJsonInputToDB(personRepository, fireStationRepository, medicalRecordsRepostiory);
        savingTheJsonInputToDB.gettingAndSavingDataFromJsonInputIntoDB();
        personRepository.findAll().forEach(System.out::println);
        fireStationRepository.findAll().forEach(System.out::println);
        medicalRecordsRepostiory.findAll().forEach(System.out::println);
    }
}