package com.example.safetynet.controller;

import com.example.safetynet.service.PersonInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PersonInfoController.class)
class PersonInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PersonInfoService personInfoService;

    @Test
    void getPersonInfoOfAnInhabitant() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/personInfo")
                        .param("firstName", "mus")
                        .param("lastName", "mus")
        ).andExpect(status().isOk());
    }
}