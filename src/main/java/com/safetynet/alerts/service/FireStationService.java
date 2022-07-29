package com.safetynet.alerts.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.repository.IDTOjson;

@Service
public class FireStationService implements IFireStationService {
    @Autowired
    private IDTOjson DTOjson;
    private static final Logger logger = LogManager.getLogger("FireStationService");

    @Override
    public List<FireStation> getFireStations() {
	return DTOjson.getJsonData().getFirestations();
    }

    @Override
    public void postFireStation(FireStation fireStationToAdd) {
	List<FireStation> fireStations = getFireStations();
	fireStations.add(fireStationToAdd);
	DTOjson.getJsonData().setFirestations(fireStations);
    }

    @Override
    public void putFireStation(FireStation fireStationToUpdate) {
	List<FireStation> fireStations = getFireStations();

	for (FireStation fireStation : fireStations) {
	    if (fireStation.getAddress().equals(fireStationToUpdate.getAddress())) {
		fireStation.setStation(fireStationToUpdate.getStation());
	    }
	}
    }

    @Override
    public void deleteFireStation(FireStation fireStationToDelete) {
	List<FireStation> fireStations = getFireStations();

	for (int i = 0; i < fireStations.size(); i++) {
	    if (fireStations.get(i).getAddress().equals(fireStationToDelete.getAddress())
		    && fireStations.get(i).getStation().equals(fireStationToDelete.getStation())) {
		fireStations.remove(i);
	    }
	}
    }

}
