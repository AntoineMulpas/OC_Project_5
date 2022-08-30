package com.example.safetynet.service;

import com.example.safetynet.DTO.InhabitantsByAddressDTO;
import com.example.safetynet.model.FireStation;
import com.example.safetynet.model.MedicalRecord;
import com.example.safetynet.model.Person;
import com.example.safetynet.repository.FireStationRepository;
import com.example.safetynet.repository.MedicalRecordsRepostiory;
import com.example.safetynet.repository.PersonRepository;
import com.example.safetynet.utils.LocalDateParser;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FireService {

    private final PersonRepository personRepository;
    private final MedicalRecordsRepostiory medicalRecordsRepostiory;
    private final FireStationRepository fireStationRepository;

    public FireService(PersonRepository personRepository, MedicalRecordsRepostiory medicalRecordsRepostiory, FireStationRepository fireStationRepository) {
        this.personRepository = personRepository;
        this.medicalRecordsRepostiory = medicalRecordsRepostiory;
        this.fireStationRepository = fireStationRepository;
    }

    public List<InhabitantsByAddressDTO> getStationAndInhabitantsInformationByAddress(String address) {
        List <Person> personListLivingAtSpecificAddress = personRepository.getListOfPersonLivingAtSpecificAddress(address);
        FireStation fireStation = fireStationRepository.findByAddressEquals(address);

        List<InhabitantsByAddressDTO> listOfInhabitantAndStationNumber = new ArrayList<>();
        personListLivingAtSpecificAddress.forEach(person -> {
            MedicalRecord medicalRecord = medicalRecordsRepostiory.findByLastNameEqualsAndFirstNameEquals(person.getLastName(), person.getFirstName());
            InhabitantsByAddressDTO inhabitants = new InhabitantsByAddressDTO();
            inhabitants.setLastName(person.getLastName());
            inhabitants.setPhone(person.getPhone());
            inhabitants.setMedicalRecord(medicalRecord);
            inhabitants.setStation(fireStation.getStation());
            inhabitants.setAge((LocalDate.now().getYear()) - LocalDateParser.dateParser(medicalRecord.getBirthdate()).getYear());
            listOfInhabitantAndStationNumber.add(inhabitants);
        });

        return listOfInhabitantAndStationNumber;
    }
}
