package com.example.safetynet.controller;

import com.example.safetynet.model.MedicalRecord;
import com.example.safetynet.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicalRecord")
@Transactional
public class MedicalRecordController {

    private MedicalRecordService medicalRecordService;

    @Autowired
    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @PostMapping
    public ResponseEntity<String> addAMedicalRecord(
            @RequestBody MedicalRecord medicalRecord
            ) {
        try {
            medicalRecordService.addMedicalRecord(medicalRecord);
            return ResponseEntity.status(HttpStatus.OK).body("Medical record has been added successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("An error occurred : " + e);
        }
    }

    @DeleteMapping("/{lastName}/{firstName}")
    public ResponseEntity<String> deleteAMedicalRecord(
            @PathVariable String lastName,
            @PathVariable String firstName
            ) {
        try {
            medicalRecordService.deleteAMedicalRecord(lastName, firstName);
            return ResponseEntity.status(HttpStatus.OK).body("Medical record has been deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("An error occurred : " + e);
        }
    }

    @PutMapping
    public ResponseEntity<String> updateAMedicalRecord(
            @RequestBody MedicalRecord medicalRecord
    ) {
        try {
            medicalRecordService.updateAMedicalRecord(medicalRecord);
            return ResponseEntity.status(HttpStatus.OK).body("Medical record has been updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("An error occurred : " + e);
        }
    }

}
