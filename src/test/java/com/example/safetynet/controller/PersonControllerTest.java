package com.example.safetynet.controller;

import com.example.safetynet.model.MedicalRecord;
import com.example.safetynet.model.Person;
import com.example.safetynet.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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