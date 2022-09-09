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
public class CommunityEmailIT {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void getEmailForAllPeopleLivingInSpecificCity() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/communityEmail")
                .param("city", "1")
        ).andExpect(status().isOk());
    }

}
