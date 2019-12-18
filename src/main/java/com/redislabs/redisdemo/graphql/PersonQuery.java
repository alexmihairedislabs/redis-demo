package com.redislabs.redisdemo.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.redislabs.redisdemo.dao.Person;
import com.redislabs.redisdemo.dao.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PersonQuery implements GraphQLQueryResolver {

    private final PersonRepository personRepository;

    public Iterable<Person> getPersons() {
        return this.personRepository.findAll();
    }

    public Optional<Person> getPerson(String id) {
        return this.personRepository.findById(id);
    }
}
