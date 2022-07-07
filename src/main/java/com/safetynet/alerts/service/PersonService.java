package com.safetynet.alerts.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.IDTOjson;

@Service
public class PersonService implements IPersonService {
    // private static final Logger logger =
    // LogManager.getLogger("AlertsApplication");
    @Autowired
    private IDTOjson DTOjson;
    private static final Logger logger = LogManager.getLogger("PersonService");

    // @todos trycatch

    @Override
    public List<Person> getPersons() {
	return DTOjson.getJsonData().getPersons();
    }

//    @Override
//    public Person getPerson(String firstName, String lastName) {
//	final List<Person> persons = getPersons();
//
//	var result = new Person();
//
//	for (Person person : persons) {
//	    String personFirstName = person.getFirstName();
//	    String personLastName = person.getLastName();
//
//	    logger.info(firstName, lastName);
//	    if (personFirstName == firstName) {
//		logger.info("ok");
//	    }
//
//	    if (personLastName == lastName) {
//		logger.info("ok");
//	    }
//
//	    if (person.getFirstName() == firstName && person.getLastName() == lastName) {
//		result.setFirstName(person.getFirstName());
//		result.setLastName(person.getLastName());
//		result.setAddress(person.getAddress());
//		result.setCity(person.getCity());
//		result.setZip(person.getZip());
//		result.setPhone(person.getPhone());
//		result.setEmail(person.getEmail());
//	    }
//	}
//
//	return result;
//    }

    @Override
    public void postPerson(Person personToAdd) {
	List<Person> persons = getPersons();
	persons.add(personToAdd);
	DTOjson.getJsonData().setPersons(persons);
    }

    @Override
    public void putPerson(Person personToUpdate) {
	List<Person> persons = getPersons();

	for (Person person : persons) {
	    if (person.getFirstName() == personToUpdate.getFirstName()
		    && person.getLastName() == personToUpdate.getLastName()) {
		if (personToUpdate.getAddress() != null)
		    person.setAddress(personToUpdate.getAddress());
		if (personToUpdate.getCity() != null)
		    person.setCity(personToUpdate.getCity());
		if (personToUpdate.getZip() != null)
		    person.setZip(personToUpdate.getZip());
		if (personToUpdate.getEmail() != null)
		    person.setEmail(personToUpdate.getEmail());
		if (personToUpdate.getPhone() != null)
		    person.setPhone(personToUpdate.getPhone());
	    }
	}
    }

    @Override
    public void deletePerson(Person personToDelete) {
	List<Person> persons = getPersons();
	// @todos try catch for the case where the user is not found
	for (int i = 0; i < persons.size(); i++) {
	    if (persons.get(i).getFirstName().equals(personToDelete.getFirstName())
		    && persons.get(i).getLastName().equals(personToDelete.getLastName())) {
		logger.info(i);
		persons.remove(i);
	    }
	}
    }

}
