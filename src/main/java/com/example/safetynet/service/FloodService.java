package com.example.safetynet.service;

import com.example.safetynet.model.FloodDTO;
import com.example.safetynet.model.FloodMedicalRecordDTO;
import com.example.safetynet.model.FloodPersonInfoDTO;
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
        List<FloodDTO> floodDTO = new ArrayList<>();
        List <FloodPersonInfoDTO> floodPersonInfoDTOS = new ArrayList <>();
            List <String> listOfAddress = new ArrayList <>();
            List <List <Person>> personListLivingAtSpecificAddress = new ArrayList <>();
            List <MedicalRecord> medicalRecordList = new ArrayList <>();

            gettingAddressesOfStationByStationNumber(stations, listOfAddress);
            gettingPersonsLivingAtSpecificAddress(listOfAddress, personListLivingAtSpecificAddress);
            gettingMedicalRecordOfPerson(personListLivingAtSpecificAddress, medicalRecordList);


            personListLivingAtSpecificAddress.forEach(people -> people.forEach(person -> {
                final int[] age = {0};
                FloodMedicalRecordDTO medicalRecord = new FloodMedicalRecordDTO();
                medicalRecordList
                        .stream()
                        .filter(medicalRecord1 -> medicalRecord1 != null)
                        .filter(medicalRecord1 -> medicalRecord1.getLastName().equals(person.getLastName()) && medicalRecord1.getFirstName().equals(person.getFirstName()))
                        .forEach(medicalRecord1 -> setMedicalRecord(age, medicalRecord, medicalRecord1));

                FloodPersonInfoDTO personInfoDTO = getFloodPersonInfoDTO(person, age, medicalRecord);
                floodPersonInfoDTOS.add(personInfoDTO);

                FloodDTO dtoToReturn = getFloodDTO(person, personInfoDTO);
                floodDTO.add(dtoToReturn);
            }));
        return  floodDTO;
    }

    private FloodDTO getFloodDTO(Person person, FloodPersonInfoDTO personInfoDTO) {
        FloodDTO dtoToReturn = new FloodDTO();
        dtoToReturn.setAddress(person.getAddress());
        dtoToReturn.setFloodPersonInfoDTO(personInfoDTO);
        return dtoToReturn;
    }

    private void setMedicalRecord(int[] age, FloodMedicalRecordDTO medicalRecord, MedicalRecord medicalRecord1) {
        medicalRecord.setMedications(medicalRecord1.getMedications());
        medicalRecord.setAllergies(medicalRecord1.getAllergies());
        age[0] = (LocalDate.now().getYear() - LocalDateParser.dateParser(medicalRecord1.getBirthdate()).getYear());
    }

    private FloodPersonInfoDTO getFloodPersonInfoDTO(Person person, int[] age, FloodMedicalRecordDTO medicalRecord) {
        FloodPersonInfoDTO personInfoDTO = new FloodPersonInfoDTO();
        personInfoDTO.setLastName(person.getLastName());
        personInfoDTO.setPhone(person.getPhone());
        personInfoDTO.setFloodMedicalRecordDTO(medicalRecord);
        personInfoDTO.setAge(age[0]);
        return personInfoDTO;
    }

    private void gettingMedicalRecordOfPerson(List <List <Person>> personListLivingAtSpecificAddress, List <MedicalRecord> medicalRecordList) {
        try {
        personListLivingAtSpecificAddress.forEach(people -> people.forEach(person -> medicalRecordList.add(medicalRecordsRepostiory.findByLastNameEqualsAndFirstNameEquals(person.getLastName(), person.getFirstName()))));
        } catch (RuntimeException e) {
            personListLivingAtSpecificAddress.forEach(people -> people.forEach(person -> medicalRecordList.add(null)));
        }
    }

    private void gettingPersonsLivingAtSpecificAddress(List <String> listOfAddress, List <List <Person>> personListLivingAtSpecificAddress) {
        listOfAddress.forEach(s -> personListLivingAtSpecificAddress.add(personRepository.getListOfPersonLivingAtSpecificAddress(s)));
    }

    private void gettingAddressesOfStationByStationNumber(List <String> stations, List <String> listOfAddress) {
        List<List <FireStation>> listOfStationFilteredByStationNumber = new ArrayList <>();
        stations.forEach(s -> listOfStationFilteredByStationNumber.add(fireStationRepository.findByStationEquals(s)));
        listOfStationFilteredByStationNumber.forEach(fireStations -> fireStations.forEach(fireStation -> listOfAddress.add(fireStation.getAddress())));
    }
}
