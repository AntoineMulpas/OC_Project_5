package com.example.safetynet.repository;

import com.example.safetynet.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordsRepostiory extends JpaRepository<MedicalRecord, Long> {

    MedicalRecord findByLastNameEqualsAndFirstNameEquals(String lastName, String firstName);

}
