package com.example.safetynet.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloodPersonInfoDTOTest {

    private FloodPersonInfoDTO underTest;

    @BeforeEach
    void setUp() {
        underTest = new FloodPersonInfoDTO(
                "antoine",
                "07",
                30,
                new FloodMedicalRecordDTO(
                        new String[]{"1", "2"},
                        new String[]{"1", "2"}
                )
        );
    }

    @Test
    void getLastName() {
        assertEquals("antoine", underTest.getLastName());
    }

    @Test
    void getPhone() {
        assertEquals("07", underTest.getPhone());
    }

    @Test
    void getAge() {
        assertEquals(30, underTest.getAge());
    }

    @Test
    void getFloodMedicalRecordDTO() {
        String[] medications = {"1", "2"};
        String[] allergies = {"1", "2"};
        FloodMedicalRecordDTO floodMedicalRecordDTO = new FloodMedicalRecordDTO(
                medications,
                allergies

        );
        assertEquals(medications.length, underTest.getFloodMedicalRecordDTO().getMedications().length);

    }

    @Test
    void setLastName() {
        underTest.setLastName("mus");
        assertEquals("mus", underTest.getLastName());
    }

    @Test
    void setPhone() {
        underTest.setPhone("123");
        assertEquals("123", underTest.getPhone());
    }

    @Test
    void setAge() {
        underTest.setAge(12);
        assertEquals(12, underTest.getAge());
    }

    @Test
    void setFloodMedicalRecordDTO() {
        String[] medications = {"1", "2", "3"};
        String[] allergies = {"1", "2"};
        FloodMedicalRecordDTO floodMedicalRecordDTO = new FloodMedicalRecordDTO(
                medications,
                allergies
        );
        underTest.setFloodMedicalRecordDTO(floodMedicalRecordDTO);
        assertEquals(3, underTest.getFloodMedicalRecordDTO().getMedications().length);
    }
}