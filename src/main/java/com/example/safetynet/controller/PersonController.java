package com.example.safetynet.controller;

import com.example.safetynet.model.Person;
import com.example.safetynet.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@Transactional
public class PersonController {

    private final PersonService personService;
    private static final Logger logger = LogManager.getLogger(PersonController.class);

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping
    public ResponseEntity<String> addAPerson(
            @RequestBody Person person
    ) {
        logger.debug("Requesting adding new person: " + person.getFirstName() + " " + person.getLastName());
        try {
            logger.info("Person " + person.getFirstName() + " " + person.getLastName() + " added succesfully");
            personService.addAPerson(person);
            return ResponseEntity.ok().body("Person has been successfully saved.");
        } catch (RuntimeException e) {
            logger.error(e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("An error occured : " + e);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAPerson(
            @RequestParam String firstName,
            @RequestParam String lastName
    ) {
        logger.debug("Requesting deleting new person: " + firstName + " " + lastName);
        try {
            logger.info("Person " + firstName + " " + lastName + " deleted succesfully");
            personService.deleteAPerson(firstName, lastName);
            return ResponseEntity.status(HttpStatus.OK).body("Person has been successfully deleted.");
        } catch (RuntimeException e) {
            logger.error(e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Failed to delete this person: " + e);
        }
    }


    @PutMapping()
    public ResponseEntity<String> updateAPerson(
            @RequestBody Person person
    ) {
        logger.debug("Requesting updating new person: " + person.getFirstName() + " " + person.getLastName());
        try {
            logger.info("Person " + person.getFirstName() + " " + person.getLastName() + " updated succesfully");
            personService.updateAPerson(person);
            return ResponseEntity.status(HttpStatus.OK).body("This person has been successfully updated");
        } catch (RuntimeException e) {
            logger.error(e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Cannot update this person.");
        }
    }

}
