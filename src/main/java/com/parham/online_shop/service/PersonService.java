package com.parham.online_shop.service;

import com.parham.online_shop.entity.Person;
import com.parham.online_shop.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(long id) {
        personRepository.deleteById(id);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(long id) {
        return personRepository.findById(id).orElse(null);
    }
}
