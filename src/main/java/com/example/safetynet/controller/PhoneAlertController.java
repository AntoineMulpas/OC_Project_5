package com.example.safetynet.controller;

import com.example.safetynet.model.PhoneAlertDTO;
import com.example.safetynet.service.FireStationService;
import com.example.safetynet.utils.SaveJsonInputToDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneAlertController {

    private final FireStationService fireStationService;
    private static final Logger logger = LogManager.getLogger(PhoneAlertController.class);


    @Autowired
    public PhoneAlertController(FireStationService fireStationService) {
        this.fireStationService = fireStationService;
    }

    @GetMapping("/phoneAlert")
    public List <PhoneAlertDTO> getPhoneNumberOfPeopleForSpecificFirestation(
            @RequestParam String firestation
    ) {
        try {
            logger.info("Requested firestation: " + firestation + " fetched with success.");
            return fireStationService.getPhoneNumberOfPeopleForSpecificFirestation(firestation);
        } catch (RuntimeException e) {
            logger.error(e);
            return null;
        }
    }

}
