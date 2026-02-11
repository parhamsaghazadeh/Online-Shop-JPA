package com.parham.online_shop.controller;

import com.parham.online_shop.entity.Person;
import com.parham.online_shop.model.Converter;
import com.parham.online_shop.model.OrderByPersonModel;
import com.parham.online_shop.model.PersonModel;
import com.parham.online_shop.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
@Slf4j
public class PersonController {
    @Autowired
    private PersonService personService;

    @Autowired
    private Converter converter;

    @GetMapping
    public ResponseEntity<List<PersonModel>> getPersons() {
        try {
            List<Person> person = personService.getAllPersons();
            List<PersonModel> personModels = person.stream()
                    .map(converter::toModelPerson)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(personModels);
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/id")
    public ResponseEntity<PersonModel> getPersonById(@RequestParam long id) {
        try {
            Person person = personService.getPersonById(id);
            PersonModel personModel = converter.toModelPerson(person);
            return ResponseEntity.ok(personModel);
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/orderPerson")
    public ResponseEntity<List<OrderByPersonModel>> getPersonByOrder() {
        try {
            List<OrderByPersonModel> personOrderList = personService.orderPerson();
            return ResponseEntity.ok(personOrderList);
        }catch (Exception e){
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<PersonModel> updatePerson(@RequestBody Person person) {
        try {
            Person personSave = personService.updatePerson(person);
            return ResponseEntity.ok(converter.toModelPerson(personSave));
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<PersonModel> addPerson(@RequestBody Person person) {
        try {
            Person personAdded = personService.addPerson(person);
            return ResponseEntity.ok(converter.toModelPerson(personAdded));
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping
    public ResponseEntity<String> deletePersonById(@RequestParam Long id) {
        try {
            personService.deletePerson(id);
            return ResponseEntity.ok("Person deleted successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
