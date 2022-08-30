package com.example.safetynet.service;

import com.example.safetynet.DTO.FloodDTO;
import com.example.safetynet.DTO.FloodPersonInfoDTO;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class FloodService {

    private final PersonRepository personRepository;
    private final FireStationRepository fireStationRepository;
    private final MedicalRecordsRepostiory medicalRecordsRepostiory;

    @Autowired
    public FloodService(PersonRepository personRepository, FireStationRepository fireStationRepository, MedicalRecordsRepostiory medicalRecordsRepostiory) {
        this.personRepository = personRepository;
        this.fireStationRepository = fireStationRepository;
        this.medicalRecordsRepostiory = medicalRecordsRepostiory;
    }

    public List<FloodDTO> getPersonsInformationByStationInCaseOfFlood(List<String> stations) {
        List<FloodDTO> getListToReturn = new ArrayList <>();

        List<String> listOfAddress = new ArrayList<>();
        List<List <FireStation>> listOfStationFilteredByStationNumber = new ArrayList <>();
        stations.forEach(s -> listOfStationFilteredByStationNumber.add(fireStationRepository.findByStationEquals(s)));
        listOfStationFilteredByStationNumber.forEach(fireStations -> fireStations.forEach(fireStation -> listOfAddress.add(fireStation.getAddress())));

        List <List <Person>> personListLivingAtSpecificAddress = new ArrayList <>();
        listOfAddress.forEach(s -> {
            personListLivingAtSpecificAddress.add(personRepository.getListOfPersonLivingAtSpecificAddress(s));
        });


        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        personListLivingAtSpecificAddress.forEach(people -> people.forEach(person -> medicalRecordList.add(medicalRecordsRepostiory.findByLastNameEqualsAndFirstNameEquals(person.getLastName(), person.getFirstName()))));

        List<FloodPersonInfoDTO> floodPersonInfoDTOS = new ArrayList<>();
        personListLivingAtSpecificAddress.forEach(people -> people.forEach(person -> {
            MedicalRecord medicalRecord = new MedicalRecord();
            medicalRecordList
                    .stream()
                    .filter(medicalRecord1 ->
                            medicalRecord1.getLastName().equals(person.getLastName())
                                    && medicalRecord1.getFirstName().equals(person.getFirstName()))
                    .forEach(medicalRecord1 -> {
                        medicalRecord.setLastName(medicalRecord1.getLastName());
                        medicalRecord.setFirstName(medicalRecord1.getFirstName());
                        medicalRecord.setBirthdate(medicalRecord1.getBirthdate());
                        medicalRecord.setMedications(medicalRecord1.getMedications());
                        medicalRecord.setAllergies(medicalRecord1.getAllergies());
                    });

            int age = LocalDate.now().getYear() - LocalDateParser.dateParser(medicalRecord.getBirthdate()).getYear();
            FloodPersonInfoDTO personInfoDTO = new FloodPersonInfoDTO();
            personInfoDTO.setLastName(person.getLastName());
            personInfoDTO.setPhone(person.getPhone());
            personInfoDTO.setMedicalRecord(medicalRecord);
            personInfoDTO.setAge(age);
            floodPersonInfoDTOS.add(personInfoDTO);
        }));



        floodPersonInfoDTOS.forEach(System.out::println);

        return  getListToReturn;
    }
}
