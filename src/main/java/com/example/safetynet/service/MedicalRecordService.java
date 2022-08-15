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

    public void updateAMedicalRecord(Long id, MedicalRecord medicalRecord) {
        Optional<MedicalRecord> medicalRecordFromDB = medicalRecordsRepostiory.findById(id);
        medicalRecord.setBirthdate(medicalRecordFromDB.get().getBirthdate());
        medicalRecord.setMedications(medicalRecordFromDB.get().getMedications());
        medicalRecord.setAllergies(medicalRecordFromDB.get().getAllergies());
        medicalRecordsRepostiory.save(medicalRecord);
    }
}
