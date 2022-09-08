package com.example.safetynet.service;

import com.example.safetynet.model.FireStation;
import com.example.safetynet.model.PhoneAlertDTO;
import com.example.safetynet.repository.FireStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional <FireStation> fireStationFromDB = fireStationRepository.findById(fireStationToUpdate.getId());
        if (fireStationFromDB.isPresent()) {
            FireStation fireStation = fireStationFromDB.get();
            fireStation.setStation(fireStationToUpdate.getStation());
            fireStationRepository.save(fireStation);
        }
    }

    public List<PhoneAlertDTO> getPhoneNumberOfPeopleForSpecificFirestation(String firestation) {
        return fireStationRepository.getPhoneNumberOfPeopleForSpecificFireStation(firestation);
    }

}
