package com.example.safetynet.controller;

import com.example.safetynet.service.ChildAlertService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ChildAlertController.class)
class ChildAlertControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ChildAlertService childAlertService;

    @Test
    void getListOfChildLivingAtSpecificAddress() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/childAlert")
                        .param("address", "1")
        ).andExpect(status().isOk());
    }
}