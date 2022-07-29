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
import com.safetynet.alerts.model.status.FloodStation;
import com.safetynet.alerts.model.status.FloodStationsPerson;
import com.safetynet.alerts.repository.IDTOjson;
import com.safetynet.alerts.utils.AgeHandler;

/*
 * Format data from DTO into FloodStation
 */
@Service
public class FloodStationsService implements IFloodStationsService {
    @Autowired
    private IDTOjson DTOjson;
    private static final Logger logger = LogManager.getLogger("FloodStationsService");

    /*
     * @Param List<Integer> stationNumbers
     */
    @Override
    public List<FloodStation> getFloodStation(List<Integer> stationNumbers) {
	List<FloodStation> resultFloodStations = new ArrayList<FloodStation>();

	List<Person> persons = DTOjson.getJsonData().getPersons();
	List<MedicalRecord> medicalRecords = DTOjson.getJsonData().getMedicalRecords();
	List<FireStation> fireStations = DTOjson.getJsonData().getFirestations();

	// Loop through each stationNumber and make all the required manipulations
	for (Integer stationNumber : stationNumbers) {

	    // Retrieve fireStation coverage addresses
	    List<String> filteredFireStationAddresses = new ArrayList<String>();
	    for (FireStation fireStation : fireStations) {
		if (fireStation.getStation().equals(String.valueOf(stationNumber))) {
		    filteredFireStationAddresses.add(fireStation.getAddress());
		}
	    }

	    // Loop through each address to retrieve the related Persons and add the values
	    // to resultFloodStations
	    for (String address : filteredFireStationAddresses) {
		FloodStation floodStationToAdd = new FloodStation();
		floodStationToAdd.setAddress(address);

		// Loop through the list of Persons to retrieve the ones living in the address
		List<Person> filteredPersons = new ArrayList<Person>();
		for (Person person : persons) {
		    if (person.getAddress().equals(address)) {
			filteredPersons.add(person);
		    }
		}

		// Looping through the filteredPersons list to retrieve their MedicalRecords
		// and adding them to intermediary variable floodStationsPersonsToAdd
		List<FloodStationsPerson> floodStationsPersonsToAdd = new ArrayList<FloodStationsPerson>();
		for (Person filteredPerson : filteredPersons) {
		    for (MedicalRecord medicalRecord : medicalRecords) {

			if (filteredPerson.getFirstName().equals(medicalRecord.getFirstName())
				&& filteredPerson.getLastName().equals(medicalRecord.getLastName())) {
			    floodStationsPersonsToAdd.add(new FloodStationsPerson(filteredPerson.getFirstName(),
				    filteredPerson.getLastName(), filteredPerson.getPhone(),
				    AgeHandler.computeAge(medicalRecord.getBirthDate(), new Date()),
				    medicalRecord.getMedications(), medicalRecord.getAllergies()));
			}
		    }
		}

		floodStationToAdd.setFloodStationsPersons(floodStationsPersonsToAdd);
		resultFloodStations.add(floodStationToAdd);

	    }

	}
	return resultFloodStations;

    }
}
