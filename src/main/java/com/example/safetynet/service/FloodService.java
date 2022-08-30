package com.example.safetynet.service;

import com.example.safetynet.DTO.FloodDTO;
import com.example.safetynet.model.FireStation;
import com.example.safetynet.model.Person;
import com.example.safetynet.repository.FireStationRepository;
import com.example.safetynet.repository.MedicalRecordsRepostiory;
import com.example.safetynet.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        List<List <FireStation>> getAddressesFromStationNumber = new ArrayList <>();
        stations.forEach(s -> getAddressesFromStationNumber.add(fireStationRepository.findByStationEquals(s)));

        List<String> listOfAddress = new ArrayList<>();
        getAddressesFromStationNumber.forEach(fireStations -> fireStations.forEach(fireStation -> listOfAddress.add(fireStation.getAddress())));

        List<Person> personListLivingAtSpecificAddress = new ArrayList<>();



        return  getListToReturn;
    }
}
