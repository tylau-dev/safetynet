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
	return PersonService.getPersons();
    }

//    @GetMapping(value = "/person/{firstName}/{lastName}")
//    public Person filterPerson(@RequestParam String firstName, @RequestParam String lastName) {
//	return PersonService.getPerson(firstName, lastName);
//    }

    @PostMapping(value = "/person")
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
	logger.info("POST request to /person");
	PersonService.postPerson(person);
	return new ResponseEntity<String>("POST request to /person successful", HttpStatus.CREATED);
    }

    @PutMapping(value = "/person")
    public ResponseEntity<String> updatePerson(@RequestBody Person person) {
	logger.info("PUT request to /person");
	PersonService.putPerson(person);
	return new ResponseEntity<String>("PUT request to /person successful", HttpStatus.OK);
    }

    @DeleteMapping(value = "/person")
    public ResponseEntity<String> removePerson(@RequestBody Person person) {
	logger.info("DELETE request to /person");
	PersonService.deletePerson(person);
	return new ResponseEntity<String>("DELETE request to /person successful", HttpStatus.OK);
    }

}
