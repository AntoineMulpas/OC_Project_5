package com.example.safetynet.service;

import com.example.safetynet.model.PersonDTO;
import com.example.safetynet.model.Person;
import com.example.safetynet.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;

    public void addAPerson(Person person) {
        personRepository.save(person);
    }

    public List <Person> getAllPerson() {
        return personRepository.findAll();
    }

    public void deleteAPerson(String firstName, String lastName) {
        personRepository.deleteByFirstNameEqualsAndLastNameEquals(firstName, lastName);
    }

    public void updateAPerson(Person personToUpdate) {
        Optional<Person> optionalPerson = personRepository.findById(personToUpdate.getId());
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setAddress(personToUpdate.getAddress());
            person.setCity(personToUpdate.getCity());
            person.setEmail(personToUpdate.getEmail());
            person.setPhone(personToUpdate.getPhone());
            person.setZip(personToUpdate.getZip());
            personRepository.save(person);
        }
    }

    public List <String> getEmailForAllPeopleLivingInSpecificCity(String city) {
        return personRepository.getEmailForAllPeopleLivingInSpecificCity(city);
    }

    public List <PersonDTO> getLastNameAndAddressAndAgeAndEmailAndMedicalRecordsForAPerson(String firstName, String lastName) {
        return personRepository.getLastNameAndAddressAndAgeAndEmailAndMedicalRecordsForAPerson(firstName, lastName);
    }
}
