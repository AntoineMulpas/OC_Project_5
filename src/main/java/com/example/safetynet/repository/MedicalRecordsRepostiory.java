package com.example.safetynet.repository;

import com.example.safetynet.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordsRepostiory extends JpaRepository<MedicalRecord, Long> {

    MedicalRecord findByLastNameEqualsAndFirstNameEquals(String lastName, String firstName);

    @Query("select a from MedicalRecord a where a.firstName = ?1 and a.lastName = ?2")
    List<MedicalRecord> getMedicalRecordsForSpecificFirstNameAndLastName(String firstName, String lastName);
}
