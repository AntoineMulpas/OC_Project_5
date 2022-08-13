package com.example.safetynet.utils;

import com.example.safetynet.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.io.IOException;

@DataJpaTest
class SavingTheJsonInputToDBTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void gettingAndSavingDataFromJsonInputIntoDB() throws InterruptedException, IOException {
        SaveJsonInputToDB savingTheJsonInputToDB = new SaveJsonInputToDB(personRepository);
        savingTheJsonInputToDB.gettingAndSavingDataFromJsonInputIntoDB();

        personRepository.findAll().stream().forEach(System.out::println);
    }
}