package com.example.safetynet.controller;

import com.example.safetynet.model.FloodDTO;
import com.example.safetynet.service.FloodService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FloodController {

    private final FloodService floodService;
    private static final Logger logger = LogManager.getLogger(FloodController.class);

    @Autowired
    public FloodController(FloodService floodService) {
        this.floodService = floodService;
    }

    @GetMapping("/flood/station")
    public List<FloodDTO> getPersonsInformationByStationInCaseOfFlood(
            @RequestParam List<String> stations
    ) {
        logger.debug("List of person served by specific stations in case of flood requested.");
        try {
            logger.info("Person's informations for stations : " + stations.toString() + " successfully fetched.");
            return floodService.getPersonsInformationByStationInCaseOfFlood(stations);
        } catch (RuntimeException e) {
            logger.error(e);
            return null;
        }
    }

}
