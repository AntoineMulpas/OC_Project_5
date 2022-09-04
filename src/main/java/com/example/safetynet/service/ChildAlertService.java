package com.example.safetynet.service;

import com.example.safetynet.model.ChildAlertDTO;
import com.example.safetynet.model.MedicalRecord;
import com.example.safetynet.model.Person;
import com.example.safetynet.repository.MedicalRecordsRepostiory;
import com.example.safetynet.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.safetynet.utils.LocalDateParser.dateParser;

@Service
public class ChildAlertService {

    private final PersonRepository personRepository;
    private final MedicalRecordsRepostiory medicalRecordsRepostiory;

    @Autowired
    public ChildAlertService(PersonRepository personRepository, MedicalRecordsRepostiory medicalRecordsRepostiory) {
        this.personRepository = personRepository;
        this.medicalRecordsRepostiory = medicalRecordsRepostiory;
    }


    public List<ChildAlertDTO> getListOfChildLivingAtSpecificAddress(String address) {
        List<ChildAlertDTO> childAlertDTOList = new ArrayList<>();
        List<Person> personLivingAtSpecificAddress = personRepository.getListOfPersonLivingAtSpecificAddress(address);
        List<MedicalRecord> getListOfMedicalRecords = new ArrayList <>();
        personLivingAtSpecificAddress.forEach(person -> getListOfMedicalRecords.add(medicalRecordsRepostiory.findByLastNameEqualsAndFirstNameEquals(person.getLastName(), person.getFirstName())));



        getListOfMedicalRecords.stream()
                .filter(medicalRecord -> (LocalDate.now().getYear() - dateParser(medicalRecord.getBirthdate()).getYear()) < 18)
                .forEach(medicalRecord -> {
                    List<Person> familyMembers = personLivingAtSpecificAddress.stream().filter(person -> !person.getFirstName().equals(medicalRecord.getFirstName())).collect(Collectors.toList());
                    ChildAlertDTO childAlertDTO = new ChildAlertDTO();
                    childAlertDTO.setFirstName(medicalRecord.getFirstName());
                    childAlertDTO.setLastName(medicalRecord.getLastName());
                    childAlertDTO.setAge((LocalDate.now().getYear()) - dateParser(medicalRecord.getBirthdate()).getYear());
                    childAlertDTO.setFamilyMembers(familyMembers);
                    childAlertDTOList.add(childAlertDTO);
                });


        childAlertDTOList.forEach(System.out::println);

        return childAlertDTOList;
    }

}
