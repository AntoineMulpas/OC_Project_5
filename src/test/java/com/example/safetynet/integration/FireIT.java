package com.example.safetynet.integration;

import com.example.safetynet.repository.FireStationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FireIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getStationAndInhabitantsInformationByAddress() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fire")
                .param("address", "rue")
        ).andExpect(status().isOk());
    }

}
