package com.example.safetynet.controller;

import com.example.safetynet.model.PersonCoveredByFireStationDTO;
import com.example.safetynet.model.FireStation;
import com.example.safetynet.service.FireStationService;
import com.example.safetynet.service.PersonCoveredByFireStationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger(FireStationController.class);


    @Autowired
    public FireStationController(FireStationService fireStationService, PersonCoveredByFireStationService personCoveredByFireStationService) {
        this.fireStationService = fireStationService;
        this.personCoveredByFireStationService = personCoveredByFireStationService;
    }


    @PostMapping
    public ResponseEntity<String> addAFireStation(
            @RequestBody FireStation fireStation
    ) {
        logger.debug("Adding a new fire station is requested: " + fireStation.getStation() + " " + fireStation.getAddress());
        try {
            logger.info("Fire station " + fireStation.getStation() + " successfully added.");
            fireStationService.addAFireStation(fireStation);
            return ResponseEntity.ok().body("Fire station has been successfully saved.");
        } catch (RuntimeException e) {
            logger.error(e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("An error occured : " + e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAFireStation(
            @PathVariable Long id
    ) {
        logger.debug("Deleting fire-station " + id + " is requested.");
        try {
            logger.info("Fire station id: " + id + " successfully deleted.");
            fireStationService.deleteAFireStation(id);
            return ResponseEntity.status(HttpStatus.OK).body("Fire station has been successfully deleted.");
        } catch (RuntimeException e) {
            logger.error(e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Failed to delete this fire station: " + e);
        }
    }


    @PutMapping
    public ResponseEntity<String> updateAFireStation(
            @RequestBody FireStation fireStation
    ) {
        logger.debug("Updated fire-station " + fireStation.getStation() + " is requested.");
        try {
            logger.info("Fire station " + fireStation.getStation() + " successfully updated.");
            fireStationService.updateAFireStations(fireStation);
            return ResponseEntity.status(HttpStatus.OK).body("This fire station has been successfully updated");
        } catch (RuntimeException e) {
            logger.error(e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Cannot update this fire station.");
        }
    }

    @GetMapping
    public List <PersonCoveredByFireStationDTO> getListOfPersonByFireStation(
            @RequestParam String stationNumber
    ) {
        logger.debug("Requesting list of person served by fire-station: "  + stationNumber);
        try {
            logger.info("List of person covered by fire station " + stationNumber + " successfully fetched.");
            return personCoveredByFireStationService.getPersonCoveredByFireStation(stationNumber);
        } catch (RuntimeException e) {
            logger.error(e);
            return null;
        }
    }


}
