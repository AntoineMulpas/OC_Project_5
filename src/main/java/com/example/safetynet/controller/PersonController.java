package com.example.safetynet.controller;

import com.example.safetynet.model.Person;
import com.example.safetynet.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@Transactional
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping
    public ResponseEntity<String> addAPerson(
            @RequestBody Person person
    ) {
        try {
            personService.addAPerson(person);
            return ResponseEntity.ok().body("Person has been successfully saved.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("An error occured : " + e);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAPerson(
            @RequestParam String firstName,
            @RequestParam String lastName
    ) {
        try {
            personService.deleteAPerson(firstName, lastName);
            return ResponseEntity.status(HttpStatus.OK).body("Person has been successfully deleted.");
        } catch (Exception e) { //Defined exception
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Failed to delete this person: " + e);
        }
    }


    @PutMapping()
    public ResponseEntity<String> updateAPerson(
            @RequestBody Person person
    ) {
        try {
            personService.updateAPerson(person);
            return ResponseEntity.status(HttpStatus.OK).body("This person has been successfully updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Cannot update this person.");
        }
    }


    @GetMapping("/all")
    public List<Person> getAllPerson() {
            return personService.getAllPerson();
        }


}
