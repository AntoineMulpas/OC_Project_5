package com.example.safetynet.controller;

import com.example.safetynet.DTO.FloodDTO;
import com.example.safetynet.service.FireStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FloodController {

    private final FireStationService fireStationService;

    @Autowired
    public FloodController(FireStationService fireStationService) {
        this.fireStationService = fireStationService;
    }

    @GetMapping("/flood")
    List<FloodDTO> getPersonsInformationByStationInCaseOfFlood(
            @RequestParam List<String> stations
    ) {
        return fireStationService.getPersonsInformationByStationInCaseOfFlood(stations);
    }

}
