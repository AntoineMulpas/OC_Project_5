package com.example.safetynet.controller;

import com.example.safetynet.model.InhabitantsByAddressDTO;
import com.example.safetynet.service.FireService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FireController {

    private final FireService fireService;
    private static final Logger logger = LogManager.getLogger(FireController.class);

    @Autowired
    public FireController(FireService fireService) {
        this.fireService = fireService;
    }

    @GetMapping("/fire")
    public List <InhabitantsByAddressDTO> getStationAndInhabitantsInformationByAddress(
            @RequestParam String address
    ) {
        logger.debug("List of person living at specific address and station number requested for address : " + address);
        try {
            logger.info("Inhabitants by address " + address + " succesfully fetched.");
            return fireService.getStationAndInhabitantsInformationByAddress(address);
        } catch (RuntimeException e) {
            logger.error(e);
            return null;
        }
    }

}
