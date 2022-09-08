package com.example.safetynet.service;

import com.example.safetynet.model.MedicalRecord;
import com.example.safetynet.repository.MedicalRecordsRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicalRecordService {

    private final MedicalRecordsRepostiory medicalRecordsRepostiory;

    @Autowired
    public MedicalRecordService(MedicalRecordsRepostiory medicalRecordsRepostiory) {
        this.medicalRecordsRepostiory = medicalRecordsRepostiory;
    }


    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordsRepostiory.save(medicalRecord);
    }

    public void deleteAMedicalRecord(String lastName, String firstName) {
            MedicalRecord medicalRecord = medicalRecordsRepostiory.findByLastNameEqualsAndFirstNameEquals(
                    lastName,
                    firstName);
            medicalRecordsRepostiory.delete(medicalRecord);
    }

    public void updateAMedicalRecord(MedicalRecord medicalRecord) {
        Optional<MedicalRecord> medicalRecordFromDB = medicalRecordsRepostiory.findById(medicalRecord.getId());
        if(medicalRecordFromDB.isPresent()) {
            MedicalRecord medicalRecordToSave = medicalRecordFromDB.get();
            medicalRecordToSave.setBirthdate(medicalRecordFromDB.get().getBirthdate());
            medicalRecordToSave.setMedications(medicalRecordFromDB.get().getMedications());
            medicalRecordToSave.setAllergies(medicalRecordFromDB.get().getAllergies());
            medicalRecordsRepostiory.save(medicalRecord);
        }
    }
}
