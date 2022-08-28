package com.example.safetynet.controller;

import com.example.safetynet.DTO.PersonCoveredByFireStationDTO;
import com.example.safetynet.model.FireStation;
import com.example.safetynet.service.FireStationService;
import com.example.safetynet.service.PersonCoveredByFireStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/firestation")
public class FireStationController {

    private final FireStationService fireStationService;
    private final PersonCoveredByFireStationService personCoveredByFireStationService;

    @Autowired
    public FireStationController(FireStationService fireStationService, PersonCoveredByFireStationService personCoveredByFireStationService) {
        this.fireStationService = fireStationService;
        this.personCoveredByFireStationService = personCoveredByFireStationService;
    }


    @PostMapping
    public ResponseEntity<String> addAFireStation(
            @RequestBody FireStation fireStation
    ) {
        try {
            fireStationService.addAFireStation(fireStation);
            return ResponseEntity.ok().body("Fire station has been successfully saved.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("An error occured : " + e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAFireStation(
            @PathVariable Long id
    ) {
        try {
            fireStationService.deleteAFireStation(id);
            return ResponseEntity.status(HttpStatus.OK).body("Fire station has been successfully deleted.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Failed to delete this fire station: " + e);
        }
    }


    @PutMapping
    public ResponseEntity<String> updateAFireStation(
            @RequestBody FireStation fireStation
    ) {
        try {
            fireStationService.updateAFireStations(fireStation);
            return ResponseEntity.status(HttpStatus.OK).body("This fire station has been successfully updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Cannot update this fire station.");
        }
    }


    @GetMapping
    public List <PersonCoveredByFireStationDTO> getListOfPersonByFireStation(
            @RequestParam String stationNumber
    ) {
        return personCoveredByFireStationService.getPersonCoveredByFireStation(stationNumber);
    }

}
