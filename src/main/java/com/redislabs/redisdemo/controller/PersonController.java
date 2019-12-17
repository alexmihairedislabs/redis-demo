package com.redislabs.redisdemo.controller;

import com.redislabs.redisdemo.aop.Timed;
import com.redislabs.redisdemo.dao.Person;
import com.redislabs.redisdemo.dao.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    @Timed
    public Iterable<Person> getAll() {
        return this.personRepository.findAll();
    }

    @GetMapping("/{id}")
    @Timed
    public Person getPerson(@PathVariable String id) {
        return this.personRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found")
        );
    }

    @PostMapping
    @Timed
    public void savePerson(@RequestBody Person person) {
        this.personRepository.save(person);
    }

    @PutMapping
    @Timed
    public void updatePerson(@RequestBody Person person) {
        this.personRepository.save(person);
    }

    @DeleteMapping("/{id}")
    @Timed
    public void deletePerson(@PathVariable String id) {
        this.personRepository.deleteById(id);
    }
}
