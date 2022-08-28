package com.example.safetynet.controller;

import com.example.safetynet.DTO.PhoneAlertDTO;
import com.example.safetynet.service.FireStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneAlertController {

    private final FireStationService fireStationService;

    @Autowired
    public PhoneAlertController(FireStationService fireStationService) {
        this.fireStationService = fireStationService;
    }

    @GetMapping("/phoneAlert")
    public List <PhoneAlertDTO> getPhoneNumberOfPeopleForSpecificFirestation(
            @RequestParam String firestation
    ) {
        return fireStationService.getPhoneNumberOfPeopleForSpecificFirestation(firestation);
    }

}
