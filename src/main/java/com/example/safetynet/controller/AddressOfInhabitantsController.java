package com.example.safetynet.controller;

import com.example.safetynet.DTO.InhabitantsByAddressDTO;
import com.example.safetynet.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressOfInhabitantsController {

    private final PersonService personService;

    @Autowired
    public AddressOfInhabitantsController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/fire")
    public List <InhabitantsByAddressDTO> getStationAndInhabitantsInformationByAddress(
            @RequestParam String address
    ) {
        return personService.getStationAndInhabitantsInformationByAddress(address);
    }

}
