package com.safetynet.alerts.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.endpoint.FireStationCoverage;
import com.safetynet.alerts.repository.IDTOjson;

@Service
public class EndPointService implements IEndPointService {
    @Autowired
    private IDTOjson DTOjson;
    private static final Logger logger = LogManager.getLogger("EndPointService");

    @Override
    public List<FireStationCoverage> getFireStationCoverage(String stationNumber) {
	List<FireStationCoverage> resultFireStationCoverage = new ArrayList<FireStationCoverage>();
	List<FireStation> fireStations = DTOjson.getJsonData().getFirestations();
	List<Person> persons = DTOjson.getJsonData().getPersons();

	List<String> filteredFireStationAddresses = new ArrayList<String>();
	// Loop through the list of FireStations to get all the address covered
	for (FireStation fireStation : fireStations) {
	    if (fireStation.getStation() == stationNumber) {
		filteredFireStationAddresses.add(fireStation.getAddress());
	    }
	}

	//

	return resultFireStationCoverage;
    }

}
