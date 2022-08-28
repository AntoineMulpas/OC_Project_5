package com.example.safetynet.repository;

import com.example.safetynet.DTO.FloodDTO;
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
    List<PhoneAlertDTO> getPhoneNumberOfPeopleForSpecificFirestation(String firestation);


    @Query(value = "select a.address, a.last_name, a.phone, b.birthdate, b.medications, b.allergies " +
            "from person as a " +
            "join medical_record as b on a.first_name = b.first_name and a.last_name = b.last_name " +
            "join fire_station as c on a.address = c.address where c.station = ?1", nativeQuery = true)
    List<FloodDTO> getPersonsInformationByStationInCaseOfFlood(String station);

    @Query("select a from FireStation a where a.station = ?1")
    List<FireStation> getAddressForSpecificStation(String station);

}
