package com.example.safetynet.service;

import com.example.safetynet.model.Person;
import com.example.safetynet.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;

    public void addAPerson(Person person) {
        personRepository.save(person);
    }

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public void deleteAPerson(String firstName, String lastName) {
        personRepository.deleteByFirstNameEqualsAndLastNameEquals(firstName, lastName);
    }

    public void updateAPerson(Long id, Person personToUpdate) throws Exception { // Return saved object
        Person person = personRepository.findById(id).orElseThrow(() -> new Exception("Cannot find this person."));
        person.setAddress(personToUpdate.getAddress());
        person.setCity(personToUpdate.getCity());
        person.setEmail(personToUpdate.getEmail());
        person.setPhone(personToUpdate.getPhone());
        person.setZip(personToUpdate.getZip());
        personRepository.save(person);
    }
}
