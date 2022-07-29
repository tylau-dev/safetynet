package com.safetynet.alerts.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.IDTOjson;

/*
 * Service for CRUD operations on Persons
 */
@Service
public class PersonService implements IPersonService {
    @Autowired
    private IDTOjson DTOjson;
    private static final Logger logger = LogManager.getLogger("PersonService");

    /*
     * Retrieve Persons from DTO
     */
    @Override
    public List<Person> getPersons() {
	return DTOjson.getJsonData().getPersons();
    }

    /*
     * Add Person from JSON data
     * 
     * @Param Person personToAdd
     */
    @Override
    public void postPerson(Person personToAdd) {
	List<Person> persons = getPersons();
	persons.add(personToAdd);
	DTOjson.getJsonData().setPersons(persons);
    }

    /*
     * Edit Person from JSON data
     * 
     * @Param Person personToUpdate
     */
    @Override
    public void putPerson(Person personToUpdate) {
	List<Person> persons = getPersons();

	for (Person person : persons) {
	    if (person.getFirstName().equals(personToUpdate.getFirstName())
		    && person.getLastName().equals(personToUpdate.getLastName())) {
		if (!personToUpdate.getAddress().equals(null))
		    person.setAddress(personToUpdate.getAddress());
		if (!personToUpdate.getCity().equals(null))
		    person.setCity(personToUpdate.getCity());
		if (!personToUpdate.getZip().equals(null))
		    person.setZip(personToUpdate.getZip());
		if (!personToUpdate.getEmail().equals(null))
		    person.setEmail(personToUpdate.getEmail());
		if (!personToUpdate.getPhone().equals(null))
		    person.setPhone(personToUpdate.getPhone());
	    }
	}
    }

    /*
     * Delete Person from JSON data
     * 
     * @Param Person personToDelete
     */
    @Override
    public void deletePerson(Person personToDelete) {
	List<Person> persons = getPersons();
	Boolean personExist = false;
	for (int i = 0; i < persons.size(); i++) {
	    if (persons.get(i).getFirstName().equals(personToDelete.getFirstName())
		    && persons.get(i).getLastName().equals(personToDelete.getLastName())) {
		persons.remove(i);
		personExist = true;
	    }
	}
    }

}
