package com.example.safetynet.service;

import com.example.safetynet.model.MedicalRecord;
import com.example.safetynet.model.Person;
import com.example.safetynet.repository.MedicalRecordsRepostiory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MedicalRecordServiceTest {

    @Mock
    private MedicalRecordsRepostiory medicalRecordsRepostiory;
    private MedicalRecordService underTest;
    private MedicalRecord medicalRecord;

    @BeforeEach
    void setUp() {
        underTest = new MedicalRecordService(medicalRecordsRepostiory);
        String[] medications = {"1", "2"};
        String[] allergies = {"1, 2"};
        medicalRecord = new MedicalRecord(
                1L,
                "Antoine",
                "Antoine",
                "03/29/1992",
                medications,
                allergies
        );
    }

    @Test
    void addMedicalRecord() {
        underTest.addMedicalRecord(medicalRecord);
        ArgumentCaptor<MedicalRecord> medicalRecordArgumentCaptor = ArgumentCaptor.forClass(MedicalRecord.class);
        verify(medicalRecordsRepostiory).save(medicalRecordArgumentCaptor.capture());
        MedicalRecord medicalRecordArgumentCaptorValue = medicalRecordArgumentCaptor.getValue();
        assertThat(medicalRecordArgumentCaptorValue).isEqualTo(medicalRecord);
    }

    @Test
    void deleteAMedicalRecord() {
        medicalRecordsRepostiory.save(medicalRecord);
        underTest.deleteAMedicalRecord("Antoine", "Antoine");
        assertTrue(medicalRecordsRepostiory.findById(1L).isEmpty());
    }

    @Test
    void updateAMedicalRecord() {
        when(medicalRecordsRepostiory.findById(1L)).thenReturn(Optional.ofNullable(medicalRecord));
        String[] medications = {"5", "5"};
        String[] allergies = {"5, 5"};
        MedicalRecord toUpdate = new MedicalRecord(
                1L,
                "Antoine",
                "Antoine",
                "01/01/1992",
                medications,
                allergies
        );
        underTest.updateAMedicalRecord(toUpdate);
        verify(medicalRecordsRepostiory).save(toUpdate);

    }

    @Test
    void updateAMedicalRecordIsNotPresent() {
        when(medicalRecordsRepostiory.findById(1L)).thenReturn(Optional.empty());
        String[] medications = {"5", "5"};
        String[] allergies = {"5, 5"};
        MedicalRecord toUpdate = new MedicalRecord(
                1L,
                "Antoine",
                "Antoine",
                "01/01/1992",
                medications,
                allergies
        );
        underTest.updateAMedicalRecord(toUpdate);
        verify(medicalRecordsRepostiory, never()).save(toUpdate);

    }
}