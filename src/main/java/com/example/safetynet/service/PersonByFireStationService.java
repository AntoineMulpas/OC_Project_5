package com.example.safetynet.service;

import com.example.safetynet.model.PersonByFireStationDTO;
import com.example.safetynet.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonByFireStationService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonByFireStationService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List <PersonByFireStationDTO> getFirstNameAndLastNameAndAddressAndPhoneForPersonsCoveredByFireStation(String stationNumber) {
        return personRepository.getFirstNameAndLastNameAndAddressAndPhoneNumberOfPersonsCoveredBySpecificFireStation(stationNumber);
    }

}
