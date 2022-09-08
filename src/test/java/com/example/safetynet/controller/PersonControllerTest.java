package com.example.safetynet.controller;

import com.example.safetynet.model.Person;
import com.example.safetynet.service.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PersonController.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Person person;

    @MockBean
    private PersonService personService;

    @BeforeEach
    void setUp() {
        person = new Person(
                1L,
                "mus",
                "mus",
                "rue",
                "lille",
                "59",
                "07",
                "gmail"
        );
    }

    @Test
    void addAPerson() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(
                MockMvcRequestBuilders.post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(person)))
                .andExpect(status().isOk());
    }

    @Test
    void deleteAPerson() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/person")
                        .param("firstName", "antoine")
                        .param("lastName", "Antoine")
                )
                .andExpect(status().isOk());
    }

    @Test
    void updateAPerson() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(
                        MockMvcRequestBuilders.put("/person")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(person)))
                .andExpect(status().isOk());
    }

    @Test
    void getAllPerson() throws Exception {
        mockMvc.perform(get("/person/all")).andExpect(status().isOk());
    }
}