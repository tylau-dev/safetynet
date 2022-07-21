package com.safetynet.alerts.service.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.status.PhoneAlert;
import com.safetynet.alerts.repository.IDTOjson;

@Service
public class PhoneAlertService implements IPhoneAlertService {
    @Autowired
    private IDTOjson DTOjson;
    private static final Logger logger = LogManager.getLogger("PhoneAlertService");

    @Override
    public List<PhoneAlert> getPhoneAlert(int stationNumber) {
	List<PhoneAlert> resultPhoneAlert = new ArrayList<PhoneAlert>();

	List<FireStation> fireStations = DTOjson.getJsonData().getFirestations();
	List<Person> persons = DTOjson.getJsonData().getPersons();

	// Retrieve Addresses covered by station number
	// Loop through the list of FireStations to get all the address covered
	List<String> filteredFireStationAddresses = new ArrayList<String>();
	for (FireStation fireStation : fireStations) {
	    if (fireStation.getStation().equals(String.valueOf(stationNumber))) {
		filteredFireStationAddresses.add(fireStation.getAddress());
	    }
	}

	for (Person person : persons) {
	    if (filteredFireStationAddresses.contains(person.getAddress())) {
		resultPhoneAlert.add(new PhoneAlert(person.getPhone()));
	    }
	}

	return resultPhoneAlert;
    }
}
