package com.safetynet.alerts.service.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.status.FireAddressAlert;
import com.safetynet.alerts.model.status.Resident;
import com.safetynet.alerts.repository.IDTOjson;
import com.safetynet.alerts.utils.AgeHandler;

@Service
public class FireAddressAlertService implements IFireAddressAlertService {
    @Autowired
    private IDTOjson DTOjson;
    private static final Logger logger = LogManager.getLogger("FireAddressAlertService");

    @Override
    public FireAddressAlert getFireAddressAlert(String address) {
	FireAddressAlert resultFireAddressAlert = new FireAddressAlert();
	List<Resident> resultResidents = new ArrayList<Resident>();

	List<Person> persons = DTOjson.getJsonData().getPersons();
	List<MedicalRecord> medicalRecords = DTOjson.getJsonData().getMedicalRecords();
	List<FireStation> fireStations = DTOjson.getJsonData().getFirestations();

	// Retrieve stationNumber from fireStation
	for (FireStation firestation : fireStations) {
	    if (firestation.getAddress().equals(address)) {
		resultFireAddressAlert.setStationNumber(Integer.parseInt(firestation.getStation()));
		break;
	    }
	}

	// Retrieve persons living in address
	List<Person> filteredPersonsInAddress = new ArrayList<Person>();
	for (Person person : persons) {
	    if (person.getAddress().equals(address)) {
		filteredPersonsInAddress.add(person);
	    }
	}

	// Retrieve age, medications and allergies from medicalRecords
	for (Person filteredPerson : filteredPersonsInAddress) {
	    for (MedicalRecord medicalRecord : medicalRecords) {
		if (filteredPerson.getFirstName().equals(medicalRecord.getFirstName())
			&& filteredPerson.getLastName().equals(medicalRecord.getLastName())) {
		    Resident residentToAdd = new Resident(filteredPerson.getFirstName(), filteredPerson.getLastName(),
			    filteredPerson.getPhone(), AgeHandler.computeAge(medicalRecord.getBirthDate(), new Date()),
			    medicalRecord.getMedications(), medicalRecord.getAllergies());
		    resultResidents.add(residentToAdd);
		}
	    }
	}
	resultFireAddressAlert.setResidents(resultResidents);

	return resultFireAddressAlert;
    }

}
