package com.example.safetynet.integration;

import com.example.safetynet.model.Person;
import com.example.safetynet.repository.PersonRepository;
import com.example.safetynet.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonIT {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PersonRepository personRepository;
    private Person person;


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
