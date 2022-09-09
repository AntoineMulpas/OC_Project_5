package com.example.safetynet.integration;

import com.example.safetynet.model.MedicalRecord;
import com.example.safetynet.repository.MedicalRecordsRepostiory;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MedicalRecordIT {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MedicalRecordsRepostiory medicalRecordsRepostiory;

    private MedicalRecord medicalRecord;

    @BeforeEach
    void setUp() {
        medicalRecord = new MedicalRecord(
                1L,
                "mus",
                "mus",
                "2000-01-01",
                new String[] {"1"},
                new String[] {"2"}
        );
    }

    @Test
    void addAMedicalRecord() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders.post("/medicalRecord")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(medicalRecord))
        ).andExpect(status().isOk());
    }

    @Test
    void deleteAMedicalRecord() throws Exception {
        medicalRecordsRepostiory.save(medicalRecord);
        mockMvc.perform(delete("/medicalRecord/antoine/antoine"))
                .andExpect(status().isOk());
    }

    @Test
    void updateAMedicalRecord() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders.put("/medicalRecord")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(medicalRecord))
        ).andExpect(status().isOk());
    }

}
