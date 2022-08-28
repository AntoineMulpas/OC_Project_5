package com.example.safetynet.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;


    @Test
    void deleteByFirstNameEqualsAndLastNameEquals() {
    }

    @Test
    void getEmailForAllPeopleLivingInSpecificCity() {
    }
}