package com.example.safetynet.controller;

import com.example.safetynet.DTO.PersonDTO;
import com.example.safetynet.DTO.PersonInfoDTO;
import com.example.safetynet.service.PersonInfoService;
import com.example.safetynet.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonInfoController {

    private final PersonInfoService personInfoService;

    @Autowired
    public PersonInfoController(PersonInfoService personInfoService) {
        this.personInfoService = personInfoService;
    }

    @GetMapping("/personInfo")
    public List <PersonInfoDTO> getPersonInfoOfAnInhabitant(
            @RequestParam String firstName,
            @RequestParam String lastName
    ) {
        return personInfoService.getPersonInfoOfAnInhabitant(firstName, lastName);
    }


}
