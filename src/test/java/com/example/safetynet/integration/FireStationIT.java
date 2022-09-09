package com.example.safetynet.integration;

import com.example.safetynet.model.FireStation;
import com.example.safetynet.repository.FireStationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FireStationIT {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FireStationRepository fireStationRepository;

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
        fireStationRepository.save(fireStation);
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
