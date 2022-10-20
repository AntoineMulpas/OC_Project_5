package com.example.safetynet.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FloodIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPersonsInformationByStationInCaseOfFlood() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/flood/station")
                        .param("stations", "1", "2")
        ).andExpect(status().isOk());
    }

}
