package com.example.safetynet.repository;

import com.example.safetynet.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    void deleteByFirstNameEqualsAndLastNameEquals(String firstName, String Lastname);

}
