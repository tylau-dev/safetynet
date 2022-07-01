package com.safetynet.alerts.service;

import java.util.List;

import com.safetynet.alerts.model.Person;

public interface IPersonService {
    List<Person> getPersons();

//    Person getPerson(String firstName, String lastName);

    void postPerson(Person person);

    void putPerson(Person person);

    void deletePerson(Person person);
}
