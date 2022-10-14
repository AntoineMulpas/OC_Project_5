package com.example.safetynet.controller;

import com.example.safetynet.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommunityEmailController {

    private final PersonService personService;
    private static final Logger logger = LogManager.getLogger(CommunityEmailController.class);

    @Autowired
    public CommunityEmailController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/communityEmail")
    public List <String> getEmailForAllPeopleLivingInSpecificCity(
            @RequestParam String city
    ) {
        logger.debug("List of email of people living in specific city: " + city + " requested.");
        try {
            logger.info("List of email for people living in " + city + " successfully fetched.");
            return personService.getEmailForAllPeopleLivingInSpecificCity(city);
        } catch (RuntimeException e) {
            logger.error(e);
            return null;
        }
    }

}
