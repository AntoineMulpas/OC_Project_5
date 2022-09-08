package com.example.safetynet.controller;

import com.example.safetynet.service.FloodService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FloodController.class)
class FloodControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FloodService floodService;

    @Test
    void getPersonsInformationByStationInCaseOfFlood() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/flood")
                        .param("stations", "1", "2")
        ).andExpect(status().isOk());
    }
}