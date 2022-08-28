package com.example.safetynet.controller;

import com.example.safetynet.DTO.ChildAlertDTO;
import com.example.safetynet.service.ChildAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChildAlertController {

    private final ChildAlertService childAlertService;

    @Autowired
    public ChildAlertController(ChildAlertService childAlertService) {
        this.childAlertService = childAlertService;
    }

    @GetMapping("/childAlert")
    public List <ChildAlertDTO> getListOfChildLivingAtSpecificAddress(
            @RequestParam String address
    ) {
        return childAlertService.getListOfChildLivingAtSpecificAddress(address);
    }

}
