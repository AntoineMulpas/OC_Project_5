package com.example.safetynet.service;

import com.example.safetynet.DTO.PersonInfoDTO;
import com.example.safetynet.model.MedicalRecord;
import com.example.safetynet.model.Person;
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
public class PersonInfoService {

    private final PersonRepository personRepository;
    private final MedicalRecordsRepostiory medicalRecordsRepostiory;

    @Autowired
    public PersonInfoService(PersonRepository personRepository, MedicalRecordsRepostiory medicalRecordsRepostiory) {
        this.personRepository = personRepository;
        this.medicalRecordsRepostiory = medicalRecordsRepostiory;
    }

    public List<PersonInfoDTO> getPersonInfoOfAnInhabitant(String firstName, String lastName) {
        List<Person> getAllPersonsBySpecificFirstNameAndLastName = personRepository.getAllPersonsBySpecificFirstNameAndLastName(firstName, lastName);
        List<MedicalRecord> getMedicalRecordsForSpecificFirstNameAndLastName = medicalRecordsRepostiory.getMedicalRecordsForSpecificFirstNameAndLastName(firstName, lastName);

        List<PersonInfoDTO> getAllPersonInformation = new ArrayList <>();
        getAllPersonsBySpecificFirstNameAndLastName.forEach(person -> getMedicalRecordsForSpecificFirstNameAndLastName.forEach(medicalRecord -> {
            if (person.getFirstName().equals(medicalRecord.getFirstName())
                    && person.getLastName().equals(medicalRecord.getLastName())) {
                LocalDate birthdate = LocalDateParser.dateParser(medicalRecord.getBirthdate());
                Integer age = Period.between(birthdate, LocalDate.now()).getYears();

                PersonInfoDTO personInfoDTO = new PersonInfoDTO();
                personInfoDTO.setLastName(person.getLastName());
                personInfoDTO.setAddress(person.getAddress());
                personInfoDTO.setAge(age);
                personInfoDTO.setEmail(person.getEmail());
                personInfoDTO.setMedications(List.of(medicalRecord.getMedications()));
                personInfoDTO.setAllergies(List.of(medicalRecord.getAllergies()));
                getAllPersonInformation.add(personInfoDTO);
            }
        }));
        return getAllPersonInformation;

    }
}
