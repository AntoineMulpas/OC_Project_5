package com.example.safetynet.repository;

import com.example.safetynet.model.InhabitantsByAddressDTO;
import com.example.safetynet.model.PersonByFireStationDTO;
import com.example.safetynet.model.PersonDTO;
import com.example.safetynet.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    void deleteByFirstNameEqualsAndLastNameEquals(String firstName, String Lastname);

    @Query("select p.email from Person p where p.city = ?1")
    List <String> getEmailForAllPeopleLivingInSpecificCity(String city);


    @Query(value = "select a.last_name, a.address, b.medications, b.allergies, datediff( YY, b.birthdate, current_date )  from person as a " +
            "join medical_record as b on a.last_name = b.last_name " +
            "where a.first_name = ?1 and a.last_name = ?2 ", nativeQuery = true)
    List<PersonDTO> getLastNameAndAddressAndAgeAndEmailAndMedicalRecordsForAPerson(String firstName, String lastName);


    @Query(value = "select a.first_name, a.last_name, a.address, a.phone from person as a " +
            "join fire_station as b on a.address = b.address where b.station = ?1",nativeQuery = true)
    List<PersonByFireStationDTO> getFirstNameAndLastNameAndAddressAndPhoneNumberOfPersonsCoveredBySpecificFireStation(String stationNumber);

    @Query(value = "select a.station, b.last_name, b.phone, c.birthdate, c.medications, c.allergies from fire_station as a " +
            "join person as b on a.address = b.address " +
            "join medical_record as c on b.first_name = c.first_name and b.last_name = c.last_name",nativeQuery = true)
    List<InhabitantsByAddressDTO> getStationAndInhabitantsInformationByAddress(String address);

    @Query("select a from Person a where a.firstName = ?1 and a.lastName = ?2")
    List<Person> getAllPersonsBySpecificFirstNameAndLastName(String firstName, String lastName);

    @Query("select a from Person a where a.address = ?1")
    List<Person> getListOfPersonLivingAtSpecificAddress(String address);


}
