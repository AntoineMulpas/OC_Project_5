package com.example.safetynet.repository;

import com.example.safetynet.DTO.PhoneAlertDTO;
import com.example.safetynet.model.FireStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FireStationRepository extends JpaRepository<FireStation, Long> {

    FireStation findByAddressEqualsAndStationEquals(String address, String stationNumber);

    @Query(value = "select a.phone from person as a inner join fire_station as b on a.address = b.address where b.station = ?1", nativeQuery = true)
    List<PhoneAlertDTO> getPhoneNumberOfPeopleForSpecificFireStation(String fireStation);

    @Query("select a from FireStation a where a.station = ?1")
    List<FireStation> getAddressForSpecificStation(String station);

    FireStation findByAddressEquals(String address);

    List<FireStation> findByStationEquals(String station);
}
