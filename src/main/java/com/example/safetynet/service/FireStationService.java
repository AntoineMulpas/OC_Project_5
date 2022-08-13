package com.example.safetynet.service;

import com.example.safetynet.model.FireStation;
import com.example.safetynet.repository.FireStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireStationService {

    private FireStationRepository fireStationRepository;

    @Autowired
    public FireStationService(FireStationRepository fireStationRepository) {
        this.fireStationRepository = fireStationRepository;
    }


    public List<FireStation> getAllFireStations() {
        return fireStationRepository.findAll();
    }

    public void addAFireStation(FireStation fireStation) {
        fireStationRepository.save(fireStation);
    }

    public void deleteAFireStation(Long id) {
        fireStationRepository.deleteById(id);
    }

    public void updateAFireStations(Long id, FireStation fireStationToUpdate) throws Exception {
        FireStation fireStation = fireStationRepository.findById(id).orElseThrow(() -> new Exception());
        fireStation.setStation(fireStationToUpdate.getStation());
    }
}
