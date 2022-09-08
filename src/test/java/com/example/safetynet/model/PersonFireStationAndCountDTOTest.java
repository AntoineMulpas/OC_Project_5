package com.example.safetynet.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonFireStationAndCountDTOTest {

    private PersonFireStationAndCountDTO underTest;

    @BeforeEach
    void setUp() {
        underTest = new PersonFireStationAndCountDTO(
                new PersonCoveredByFireStationDTO(
                        "mustang",
                        "mustang",
                        "rue",
                        "07",
                        new CountOfPersonDTO(
                                10L,
                                5L
                        )),
                new CountOfPersonDTO(10L, 5L));
        PersonFireStationAndCountDTO personFireStationAndCountDTO = new PersonFireStationAndCountDTO();
    }

    @Test
    void getPersonCoveredByFireStationDTO() {
        PersonCoveredByFireStationDTO toCompare = new PersonCoveredByFireStationDTO(
                "mustang",
                "mustang",
                "rue",
                "07",
                new CountOfPersonDTO(
                        10L,
                        5L
                ));
        assertEquals(toCompare.getLastName(), underTest.getPersonCoveredByFireStationDTO().getLastName());
    }

    @Test
    void getCountOfPersonDTO() {
        CountOfPersonDTO toCompare = new CountOfPersonDTO(10L, 5L);
        assertEquals(toCompare.getAdultCount(), underTest.getCountOfPersonDTO().getAdultCount());
    }

    @Test
    void setPersonCoveredByFireStationDTO() {
        PersonCoveredByFireStationDTO toCompare = new PersonCoveredByFireStationDTO(
                "mus",
                "mus",
                "rue",
                "07",
                new CountOfPersonDTO(
                        10L,
                        5L
                ));
        underTest.setPersonCoveredByFireStationDTO(toCompare);
        assertEquals(toCompare, underTest.getPersonCoveredByFireStationDTO());
    }

    @Test
    void setCountOfPersonDTO() {
        CountOfPersonDTO toCompare = new CountOfPersonDTO(20L, 10L);
        underTest.setCountOfPersonDTO(toCompare);
        assertEquals(toCompare, underTest.getCountOfPersonDTO());

    }
}