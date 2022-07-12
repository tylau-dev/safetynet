package com.safetynet.alerts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.model.Person;

@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;
    private static Person personToAdd = new Person();;

    @BeforeAll
    public static void setup() {
	personToAdd.setFirstName("John");
	personToAdd.setLastName("Doe");
	personToAdd.setPhone("0123456789");
	personToAdd.setEmail("john@doe.net");
	personToAdd.setAddress("11 Test Road");
	personToAdd.setZip("12345");
	personToAdd.setCity("City");
    }

    @AfterEach
    public void deleteAddedPerson() {
	personService.deletePerson(personToAdd);
    }

    @Test
    public void shouldRetrieveNonEmptyPersonList() {
	assertNotNull(personService.getPersons());
    }

    @Test
    public void shouldAddSuccessfullyPerson() {
	personService.postPerson(personToAdd);

	List<Person> listPerson = personService.getPersons();
	// Person added to the last index of the list
	assertEquals(listPerson.get(listPerson.size() - 1).getFirstName(), personToAdd.getFirstName());
    }

    @Test
    public void shouldEditSuccessfullyPerson() {
	Person personToEdit = new Person();
	personToEdit.setFirstName("John");
	personToEdit.setLastName("Doe");
	personToEdit.setPhone("9999999999");

	personService.postPerson(personToAdd);
	personService.putPerson(personToEdit);

	List<Person> listPerson = personService.getPersons();
	assertEquals(listPerson.get(listPerson.size() - 1).getPhone(), personToEdit.getPhone());
    }

    @Test
    public void shouldDeleteSuccessfullyPerson() {
	personService.postPerson(personToAdd);
	personService.deletePerson(personToAdd);

	List<Person> listPerson = personService.getPersons();
	String lastName = listPerson.get(listPerson.size() - 1).getLastName();
	assertFalse(lastName.equals(personToAdd.getLastName()));
    }

}
