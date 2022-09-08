package com.example.safetynet.controller;

import com.example.safetynet.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = PersonController.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void addAPerson() {
    }

    @Test
    void deleteAPerson() {
    }

    @Test
    void updateAPerson() {
    }

    @Test
    void getAllPerson() {
    }
}