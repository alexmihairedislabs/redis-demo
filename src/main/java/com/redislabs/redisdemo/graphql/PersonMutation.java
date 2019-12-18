package com.redislabs.redisdemo.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.redislabs.redisdemo.dao.Person;
import com.redislabs.redisdemo.dao.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonMutation implements GraphQLMutationResolver {

    private final PersonRepository personRepository;

    public Person createPerson(String id, String name) {
        return this.personRepository.save(
                new Person(id, name)
        );
    }
}
