package com.example.safetynet.service;

import com.example.safetynet.model.PhoneAlertDTO;
import com.example.safetynet.model.FireStation;
import com.example.safetynet.repository.FireStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireStationService {

    private final FireStationRepository fireStationRepository;

    @Autowired
    public FireStationService(FireStationRepository fireStationRepository) {
        this.fireStationRepository = fireStationRepository;
    }


    public void addAFireStation(FireStation fireStation) {
        fireStationRepository.save(fireStation);
    }

    public void deleteAFireStation(Long id) {
        fireStationRepository.deleteById(id);
    }

    public void updateAFireStations(FireStation fireStationToUpdate) {
        FireStation fireStation = fireStationRepository.findByAddressEqualsAndStationEquals(fireStationToUpdate.getAddress(), fireStationToUpdate.getStation());
        fireStation.setStation(fireStationToUpdate.getStation());
        fireStationRepository.save(fireStation);
    }

    public List<PhoneAlertDTO> getPhoneNumberOfPeopleForSpecificFirestation(String firestation) {
        return fireStationRepository.getPhoneNumberOfPeopleForSpecificFireStation(firestation);
    }

}
