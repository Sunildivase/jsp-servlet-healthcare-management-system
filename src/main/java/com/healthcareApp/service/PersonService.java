package com.healthcareApp.service;

import com.healthcareApp.model.Person;
import com.healthcareApp.repository.PersonRepository;

import java.sql.SQLException;
import java.util.List;


public class PersonService {

    private static final PersonRepository personRepository = new PersonRepository();

    public boolean insertPerson(Person person) throws SQLException {
        return personRepository.createPerson(person);
    }

    public boolean updateCustomer(int personId, String firstName) throws SQLException {
        return personRepository.updatePerson(personId, firstName);
    }

    public boolean deletePerson(int PersonId) throws SQLException {
        return personRepository.deletePerson(PersonId);
    }


    public List<Person> displayPerson() throws SQLException {
        return personRepository.displayPerson();
    }
}
