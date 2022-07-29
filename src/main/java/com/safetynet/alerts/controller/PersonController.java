package com.safetynet.alerts.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.service.IPersonService;

@RestController
public class PersonController {

    @Autowired
    private IPersonService PersonService;
    private static final Logger logger = LogManager.getLogger("PersonController");

    @GetMapping("/person")
    public List<Person> listPersons() {
	logger.info("GET request to /person");
	List<Person> personList = PersonService.getPersons();
	logger.info("PersonService.getPerson success");
	return personList;
    }

//    @GetMapping(value = "/person/{firstName}/{lastName}")
//    public Person filterPerson(@RequestParam String firstName, @RequestParam String lastName) {
//	return PersonService.getPerson(firstName, lastName);
//    }

    @PostMapping(value = "/person")
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
	logger.info("POST request to /person");
	try {
	    if (person.getFirstName().equals(null) || person.getLastName().equals(null)) {
		throw new Exception();
	    }
	    PersonService.postPerson(person);
	    logger.info("PersonService.postPerson success");
	    return new ResponseEntity<String>("POST request to /person successful", HttpStatus.CREATED);
	} catch (Exception e) {
	    logger.error("PersonService.postPerson failed: Missing Values");
	    return new ResponseEntity<String>("POST request to /person failed: Missing Values", HttpStatus.BAD_REQUEST);
	}
    }

    @PutMapping(value = "/person")
    public ResponseEntity<String> updatePerson(@RequestBody Person person) {
	logger.info("PUT request to /person");
	try {
	    if (person.getFirstName().equals(null) || person.getLastName().equals(null)) {
		throw new Exception();
	    }
	    PersonService.putPerson(person);
	    logger.info("PersonService.putPerson success");
	    return new ResponseEntity<String>("PUT request to /person successful", HttpStatus.OK);
	} catch (Exception e) {
	    logger.error("PersonService.putPerson failed: Missing Values");
	    return new ResponseEntity<String>("PUT request to /person failed: Missing Values", HttpStatus.BAD_REQUEST);
	}
    }

    @DeleteMapping(value = "/person")
    public ResponseEntity<String> removePerson(@RequestBody Person person) {
	logger.info("DELETE request to /person");
	try {
	    if (person.getFirstName().equals(null) || person.getLastName().equals(null)) {
		throw new Exception();
	    }
	    PersonService.deletePerson(person);
	    logger.info("PersonService.deletePerson success");
	    return new ResponseEntity<String>("DELETE request to /person successful", HttpStatus.OK);
	} catch (Exception e) {
	    logger.error("PersonService.deletePerson failed: Missing Values");
	    return new ResponseEntity<String>("DELETE request to /person failed: Missing Values",
		    HttpStatus.BAD_REQUEST);
	}
    }

}
