package com.example.safetynet.controller;

import com.example.safetynet.service.FireService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FireController.class)
class FireControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FireService fireService;

    @Test
    void getStationAndInhabitantsInformationByAddress() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fire")
                .param("address", "rue")
        ).andExpect(status().isOk());
    }
}