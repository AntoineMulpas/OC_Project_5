package com.example.safetynet.controller;

import com.example.safetynet.DTO.FloodDTO;
import com.example.safetynet.service.FloodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FloodController {

    private final FloodService floodService;

    @Autowired
    public FloodController(FloodService floodService) {
        this.floodService = floodService;
    }

    @GetMapping("/flood")
    public List<FloodDTO> getPersonsInformationByStationInCaseOfFlood(
            @RequestParam List<String> stations
    ) {
        return floodService.getPersonsInformationByStationInCaseOfFlood(stations);
    }

}
