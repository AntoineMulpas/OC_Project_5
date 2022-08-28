package com.example.safetynet.controller;

import com.example.safetynet.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommunityEmailController {

    private final PersonService personService;

    @Autowired
    public CommunityEmailController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/communityEmail")
    public List <String> getEmailForAllPeopleLivingInSpecificCity(
            @RequestParam String city
    ) {
        return personService.getEmailForAllPeopleLivingInSpecificCity(city);
    }

}
