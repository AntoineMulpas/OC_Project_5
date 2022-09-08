package com.example.safetynet.controller;

import com.example.safetynet.model.FireStation;
import com.example.safetynet.service.FireStationService;
import com.example.safetynet.service.PersonCoveredByFireStationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FireStationController.class)
class FireStationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FireStationService fireStationService;
    @MockBean
    private PersonCoveredByFireStationService personCoveredByFireStationService;

    private FireStation fireStation;

    @BeforeEach
    void setUp() {
        fireStation = new FireStation(
                1L,
                "rue",
                "1"
        );
    }

    @Test
    void addAFireStation() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(
                MockMvcRequestBuilders.post("/firestation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(fireStation))
        ).andExpect(status().isOk());
    }

    @Test
    void deleteAFireStation() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/firestation/1")
        ).andExpect(status().isOk());
    }

    @Test
    void updateAFireStation() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(
                MockMvcRequestBuilders.put("/firestation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(fireStation))
        ).andExpect(status().isOk());
    }

    @Test
    void getListOfPersonByFireStation() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/firestation")
                        .param("stationNumber", "1")
        ).andExpect(status().isOk());
    }
}