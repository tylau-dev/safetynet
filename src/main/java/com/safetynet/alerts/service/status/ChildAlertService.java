package com.safetynet.alerts.service.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.status.ChildAlert;
import com.safetynet.alerts.repository.IDTOjson;
import com.safetynet.alerts.utils.AgeHandler;

@Service
public class ChildAlertService implements IChildAlertService {
    @Autowired
    private IDTOjson DTOjson;
    private static final Logger logger = LogManager.getLogger("ChildAlertServiceService");

    @Override
    public List<ChildAlert> getChildAlert(String address) {
	List<ChildAlert> resultChildAlert = new ArrayList<ChildAlert>();

	List<Person> persons = DTOjson.getJsonData().getPersons();
	List<MedicalRecord> medicalRecords = DTOjson.getJsonData().getMedicalRecords();

	List<Person> residents = new ArrayList<Person>();
	List<Person> children = new ArrayList<Person>();
	Map<String, List<Person>> family = new HashMap<String, List<Person>>();

	// Retrieve the persons living in the address
	for (Person person : persons) {
	    if (person.getAddress().equals(address)) {
		residents.add(person);

		// Map family members into HashMap for easier retrieval
		if (family.containsKey(person.getLastName())) {
		    List<Person> existingFamily = family.get(person.getLastName());
		    existingFamily.add(person);
		    family.put(person.getLastName(), existingFamily);
		} else {
		    List<Person> newFamily = new ArrayList<Person>();
		    newFamily.add(person);
		    family.put(person.getLastName(), newFamily);
		}

	    }
	}

	// Looping through the resident and the MedicalRecord to retrieve BirthDate and
	// check whether resident is a child, then append result List
	for (Person resident : residents) {
	    for (MedicalRecord medicalRecord : medicalRecords) {
		if (resident.getFirstName().equals(medicalRecord.getFirstName())
			&& resident.getLastName().equals(medicalRecord.getLastName())
			&& AgeHandler.computeAge(medicalRecord.getBirthDate(), new Date()) < 18) {
		    resultChildAlert.add(new ChildAlert(resident.getFirstName(), resident.getLastName(),
			    family.get(resident.getLastName())));
		}
	    }
	}

	return resultChildAlert;
    }
}
