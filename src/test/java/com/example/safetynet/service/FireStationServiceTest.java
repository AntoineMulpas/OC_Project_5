package com.example.safetynet.service;

import com.example.safetynet.model.FireStation;
import com.example.safetynet.repository.FireStationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FireStationServiceTest {

    private FireStationService underTest;
    @Mock
    private FireStationRepository fireStationRepository;
    private FireStation fireStation;

    @BeforeEach
    void setUp() {
        underTest = new FireStationService(fireStationRepository);
        fireStation = new FireStation(
                1L,
                "1 rue",
                "1"
        );
    }

    @Test
    void addAFireStation() {
        underTest.addAFireStation(fireStation);
        ArgumentCaptor<FireStation> argumentCaptor = ArgumentCaptor.forClass(FireStation.class);
        verify(fireStationRepository).save(argumentCaptor.capture());
        FireStation fireStationArgumentCaptorValue = argumentCaptor.getValue();
        assertThat(fireStationArgumentCaptorValue).isEqualTo(fireStation);
    }

    @Test
    void deleteAFireStation() {
        underTest.deleteAFireStation(1L);
        verify(fireStationRepository).deleteById(1L);
    }

    @Test
    @Disabled
    void updateAFireStations() {
        when(fireStationRepository.findByAddressEqualsAndStationEquals("1 rue", "1")).thenReturn(fireStation);
        FireStation fireStationToUpdate = new FireStation(1L, "2 boulevard", "1");
        underTest.updateAFireStations(fireStationToUpdate);
        verify(fireStationRepository).save(fireStationToUpdate);
    }

    @Test
    void getPhoneNumberOfPeopleForSpecificFirestation() {
        underTest.getPhoneNumberOfPeopleForSpecificFirestation("1L");
        verify(fireStationRepository).getPhoneNumberOfPeopleForSpecificFireStation("1L");
    }
}