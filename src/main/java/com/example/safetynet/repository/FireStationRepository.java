package com.example.safetynet.repository;

import com.example.safetynet.model.FireStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FireStationRepository extends JpaRepository<FireStation, Long> {
}
