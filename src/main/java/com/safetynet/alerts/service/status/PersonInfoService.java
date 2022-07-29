package com.safetynet.alerts.service.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.status.PersonInfo;
import com.safetynet.alerts.repository.IDTOjson;
import com.safetynet.alerts.utils.AgeHandler;

@Service
public class PersonInfoService implements IPersonInfoService {
    @Autowired
    private IDTOjson DTOjson;
    private static final Logger logger = LogManager.getLogger("PersonInfoService");

    @Override
    public List<PersonInfo> getPersonInfo(String firstName, String lastName) {
	List<PersonInfo> resultPersonInfo = new ArrayList<PersonInfo>();

	List<Person> persons = DTOjson.getJsonData().getPersons();
	List<MedicalRecord> medicalRecords = DTOjson.getJsonData().getMedicalRecords();

	List<Person> filteredPersons = new ArrayList<Person>();

	// Filtering list of Person to retrieve all occurrences of firstName/lastName
	// combinations
	for (Person person : persons) {
	    if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
		filteredPersons.add(person);
	    }
	}

	// Looping through the filtered list of persons to retrieve the relevant data
	// from medicalRecords
	for (Person filteredPerson : filteredPersons) {
	    PersonInfo personInfoToAdd = new PersonInfo();
	    for (MedicalRecord medicalRecord : medicalRecords) {
		if (medicalRecord.getFirstName().equals(filteredPerson.getFirstName())
			&& medicalRecord.getLastName().equals(filteredPerson.getLastName())) {
		    // adding the results to resultPersonInfo through a new PersonInfo object
		    resultPersonInfo.add(new PersonInfo(filteredPerson.getFirstName(), filteredPerson.getLastName(),
			    AgeHandler.computeAge(medicalRecord.getBirthDate(), new Date()), filteredPerson.address,
			    filteredPerson.city, filteredPerson.zip, medicalRecord.getAllergies(),
			    medicalRecord.getMedications()));
		}

	    }
	}

	return resultPersonInfo;
    }
}
