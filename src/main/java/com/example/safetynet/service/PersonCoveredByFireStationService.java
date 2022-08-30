package com.example.safetynet.service;

import com.example.safetynet.DTO.CountOfPersonDTO;
import com.example.safetynet.DTO.PersonCoveredByFireStationDTO;
import com.example.safetynet.model.FireStation;
import com.example.safetynet.model.MedicalRecord;
import com.example.safetynet.model.Person;
import com.example.safetynet.repository.FireStationRepository;
import com.example.safetynet.repository.MedicalRecordsRepostiory;
import com.example.safetynet.repository.PersonRepository;
import com.example.safetynet.utils.LocalDateParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonCoveredByFireStationService {
    
    private final PersonRepository personRepository;
    private final FireStationRepository fireStationRepository;
    private final MedicalRecordsRepostiory medicalRecordsRepostiory;

    @Autowired
    public PersonCoveredByFireStationService(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordsRepostiory medicalRecordsRepostiory) {
        this.personRepository = personRepository;
        this.fireStationRepository = fireStationRepository;
        this.medicalRecordsRepostiory = medicalRecordsRepostiory;
    }


    public List<PersonCoveredByFireStationDTO> getPersonCoveredByFireStation(String station) {
        List<PersonCoveredByFireStationDTO> getListOfPersonCoveredByFireStation = new ArrayList <>();
        List <Person> getListOfPersonLivingAtSpecificAddress = gettingListOfPersonLivingAtSpecificAddress(station);
        List<MedicalRecord> getMedicalRecordOfPerson = new ArrayList<>();
        List <Integer> listOfAgeOfPerson = gettingAgeOfPersons(getListOfPersonLivingAtSpecificAddress, getMedicalRecordOfPerson);

        return listOfPersonCoveredByFireStation(getListOfPersonCoveredByFireStation, getListOfPersonLivingAtSpecificAddress, listOfAgeOfPerson);
    }


    private List <Integer> gettingAgeOfPersons(List <Person> getListOfPersonLivingAtSpecificAddress, List <MedicalRecord> getMedicalRecordOfPerson) {
        getListOfPersonLivingAtSpecificAddress.forEach(person -> {
            MedicalRecord recordOfSpecificPerson = medicalRecordsRepostiory.findByLastNameEqualsAndFirstNameEquals(person.getLastName(), person.getFirstName());
            getMedicalRecordOfPerson.add(recordOfSpecificPerson);
        });


        List<Integer> listOfAgeOfPerson = new ArrayList<>();
        getMedicalRecordOfPerson.forEach(medicalRecord -> {
            LocalDate birthdate = LocalDateParser.dateParser(medicalRecord.getBirthdate());
            int age = Period.between(birthdate, LocalDate.now()).getYears();
            listOfAgeOfPerson.add(age);
        });
        return listOfAgeOfPerson;
    }

    private List <Person> gettingListOfPersonLivingAtSpecificAddress(String station) {
        List<FireStation> getAddressCoveredByFireStation = fireStationRepository.getAddressForSpecificStation(station);
        List<Person> getListOfPersonLivingAtSpecificAddress = new ArrayList<>();
        getAddressCoveredByFireStation.forEach(fireStation -> {
            List<Person> listOfPerson = personRepository.getListOfPersonLivingAtSpecificAddress(fireStation.getAddress());
            getListOfPersonLivingAtSpecificAddress.addAll(listOfPerson);
        });
        return getListOfPersonLivingAtSpecificAddress;
    }

    private List <PersonCoveredByFireStationDTO> listOfPersonCoveredByFireStation(List <PersonCoveredByFireStationDTO> getListOfPersonCoveredByFireStation, List <Person> getListOfPersonLivingAtSpecificAddress, List <Integer> listOfAgeOfPerson) {
        long adultCount = listOfAgeOfPerson.stream().filter(integer -> integer > 18).count();
        long childCount = listOfAgeOfPerson.stream().filter(integer -> integer <= 18).count();


        getListOfPersonLivingAtSpecificAddress.forEach(person -> {
            PersonCoveredByFireStationDTO personDTO = new PersonCoveredByFireStationDTO();
            personDTO.setFirstName(person.getFirstName());
            personDTO.setLastName(person.getLastName());
            personDTO.setAddress(person.getAddress());
            personDTO.setPhone(person.getPhone());
            personDTO.setCountOfPersonDTO(new CountOfPersonDTO(adultCount, childCount));
            getListOfPersonCoveredByFireStation.add(personDTO);
        });

        return getListOfPersonCoveredByFireStation;
    }

}
