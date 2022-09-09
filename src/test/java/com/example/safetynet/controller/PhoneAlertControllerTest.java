package com.example.safetynet.controller;

import com.example.safetynet.service.FireStationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PhoneAlertController.class)
class PhoneAlertControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FireStationService fireStationService;

    @Test
    void getPhoneNumberOfPeopleForSpecificFirestation() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/phoneAlert")
                        .param("firestation", "1")
        ).andExpect(status().isOk());

    }
}