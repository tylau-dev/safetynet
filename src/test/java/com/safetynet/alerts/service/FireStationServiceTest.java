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

import com.safetynet.alerts.model.FireStation;

@SpringBootTest
public class FireStationServiceTest {
    @Autowired
    private FireStationService fireStationService;
    private static FireStation fireStationToAdd = new FireStation();

    @BeforeAll
    public static void setup() {
	fireStationToAdd.setAddress("Test Address");
	fireStationToAdd.setStation("2");
    }

    @AfterEach
    public void deleteAddedPerson() {
	fireStationService.deleteFireStation(fireStationToAdd);
    }

    @Test
    public void shouldRetrieveNonEmptyFireStationList() {
	assertNotNull(fireStationService.getFireStations());
    }

    @Test
    public void shouldAddSuccessfullyFireStation() {
	fireStationService.postFireStation(fireStationToAdd);

	List<FireStation> listFireStation = fireStationService.getFireStations();
	assertEquals(listFireStation.get(listFireStation.size() - 1).getAddress(), fireStationToAdd.getAddress());
    }

    @Test
    public void shouldEditSuccessfullyFireStation() {
	FireStation fireStationToEdit = new FireStation();
	fireStationToEdit.setAddress("Test Address");
	fireStationToEdit.setStation("4");

	fireStationService.postFireStation(fireStationToAdd);
	fireStationService.putFireStation(fireStationToEdit);

	List<FireStation> listFireStation = fireStationService.getFireStations();
	assertEquals(listFireStation.get(listFireStation.size() - 1).getStation(), fireStationToEdit.getStation());
    }

    @Test
    public void shouldDeleteSuccessfullyPerson() {
	fireStationService.postFireStation(fireStationToAdd);
	fireStationService.deleteFireStation(fireStationToAdd);

	List<FireStation> listFireStation = fireStationService.getFireStations();
	assertFalse(listFireStation.get(listFireStation.size() - 1).getAddress().equals(fireStationToAdd.getAddress()));
    }

}
