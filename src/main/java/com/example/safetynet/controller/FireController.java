package com.example.safetynet.controller;

import com.example.safetynet.DTO.InhabitantsByAddressDTO;
import com.example.safetynet.service.FireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FireController {

    private final FireService fireService;

    @Autowired
    public FireController(FireService fireService) {
        this.fireService = fireService;
    }

    @GetMapping("/fire")
    public List <InhabitantsByAddressDTO> getStationAndInhabitantsInformationByAddress(
            @RequestParam String address
    ) {
        return fireService.getStationAndInhabitantsInformationByAddress(address);
    }

}
