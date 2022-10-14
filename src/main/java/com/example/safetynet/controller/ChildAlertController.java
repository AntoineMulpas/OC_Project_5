package com.example.safetynet.controller;

import com.example.safetynet.model.ChildAlertDTO;
import com.example.safetynet.service.ChildAlertService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChildAlertController {

    private final ChildAlertService childAlertService;
    private static final Logger logger = LogManager.getLogger(ChildAlertController.class);

    @Autowired
    public ChildAlertController(ChildAlertService childAlertService) {
        this.childAlertService = childAlertService;
    }

    @GetMapping("/childAlert")
    public List <ChildAlertDTO> getListOfChildLivingAtSpecificAddress(
            @RequestParam String address
    ) {
        logger.debug("List of child living at specific address requested : " + address);
        try {
            logger.info("List of child living at address " + address + " successfully fetched.");
            return childAlertService.getListOfChildLivingAtSpecificAddress(address);
        } catch (RuntimeException e) {
            logger.error(e);
            return null;
        }
    }

}
