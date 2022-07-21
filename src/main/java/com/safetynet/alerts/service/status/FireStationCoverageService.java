package com.safetynet.alerts.service.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safety.alerts.utils.AgeHandler;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.status.FireStationCoverage;
import com.safetynet.alerts.repository.IDTOjson;

@Service
public class FireStationCoverageService implements IFireStationCoverageService {
    @Autowired
    private IDTOjson DTOjson;
    private static final Logger logger = LogManager.getLogger("FireStationCoverageService");

    @Override
    public FireStationCoverage getFireStationCoverage(int stationNumber) {
	// Initialize result elements
	Integer adultNumber = 0;
	Integer childNumber = 0;

	// Retrieve Data from DTO
	List<FireStation> fireStations = DTOjson.getJsonData().getFirestations();
	List<Person> persons = DTOjson.getJsonData().getPersons();
	List<MedicalRecord> medicalRecords = DTOjson.getJsonData().getMedicalRecords();

	// Loop through the list of FireStations to get all the address covered
	List<String> filteredFireStationAddresses = new ArrayList<String>();
	for (FireStation fireStation : fireStations) {
	    if (fireStation.getStation().equals(String.valueOf(stationNumber))) {
		filteredFireStationAddresses.add(fireStation.getAddress());
	    }
	}
	// Loop through the list of Persons to retrieve the ones living in the address
	List<Person> filteredPersons = new ArrayList<Person>();
	for (Person person : persons) {
	    if (filteredFireStationAddresses.contains(person.getAddress())) {
		filteredPersons.add(person);
	    }
	}

	// Loop through MedicalRecords to retrieve the age and append the child & adult
	// counts.
	for (Person filteredPerson : filteredPersons) {
	    for (MedicalRecord medicalRecord : medicalRecords) {
		if (filteredPerson.getFirstName().equals(medicalRecord.getFirstName())
			&& filteredPerson.getLastName().equals(medicalRecord.getLastName())) {
		    if (AgeHandler.computeAge(medicalRecord.getBirthDate(), new Date()) >= 18) {
			adultNumber += 1;
		    } else {
			childNumber += 1;
		    }
		}
	    }
	}

	return new FireStationCoverage(filteredPersons, adultNumber, childNumber);
    }

}
