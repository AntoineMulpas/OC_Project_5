package com.example.safetynet.repository;

import com.example.safetynet.model.Medications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationsRepository extends JpaRepository<Medications, Long> {
}
