package com.example.safetynet.controller;

import com.example.safetynet.model.MedicalRecord;
import com.example.safetynet.service.MedicalRecordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicalRecord")
@Transactional
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;
    private static final Logger logger = LogManager.getLogger(MedicalRecordController.class);


    @Autowired
    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @PostMapping
    public ResponseEntity<String> addAMedicalRecord(
            @RequestBody MedicalRecord medicalRecord
            ) {
        logger.debug("Requesting adding new medical record: " + medicalRecord.getFirstName() + " " + medicalRecord.getLastName());
        try {
            logger.info("Medical record of " + medicalRecord.getFirstName() + " " + medicalRecord.getLastName() + " succesfully added.");
            medicalRecordService.addMedicalRecord(medicalRecord);
            return ResponseEntity.status(HttpStatus.OK).body("Medical record has been added successfully.");
        } catch (RuntimeException e) {
            logger.error(e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("An error occurred : " + e);
        }
    }

    @DeleteMapping("/{lastName}/{firstName}")
    public ResponseEntity<String> deleteAMedicalRecord(
            @PathVariable String lastName,
            @PathVariable String firstName
            ) {
        logger.debug("Requesting deleting new medical record: " + firstName + " " + lastName);
        try {
            logger.info("Medical record of " + firstName + " " + lastName + " successfully deleted.");
            medicalRecordService.deleteAMedicalRecord(lastName, firstName);
            return ResponseEntity.status(HttpStatus.OK).body("Medical record has been deleted successfully.");
        } catch (RuntimeException e) {
            logger.error(e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("An error occurred : " + e);
        }
    }

    @PutMapping
    public ResponseEntity<String> updateAMedicalRecord(
            @RequestBody MedicalRecord medicalRecord
    ) {
        logger.debug("Requesting updated medical record of " + medicalRecord.getFirstName() + " " + medicalRecord.getLastName());
        try {
            logger.info("Medical record of " + medicalRecord.getFirstName() + " " + medicalRecord.getLastName() + " successfully updated.");
            medicalRecordService.updateAMedicalRecord(medicalRecord);
            return ResponseEntity.status(HttpStatus.OK).body("Medical record has been updated successfully.");
        } catch (RuntimeException e) {
            logger.error(e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("An error occurred : " + e);
        }
    }

}
