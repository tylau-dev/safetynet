package com.safetynet.alerts.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.service.IFireStationService;

@RestController
public class FireStationController {
    @Autowired
    private IFireStationService FireStaionService;
    private static final Logger logger = LogManager.getLogger("FireStationController");

    @GetMapping("/firestation")
    public List<FireStation> listPersons() {
	logger.info("GET request to /firestation");
	return FireStaionService.getFirestations();
    }

    @PostMapping(value = "/firestation")
    public ResponseEntity<String> addPerson(@RequestBody FireStation fireStation) {
	logger.info("POST request to /firestation");
	FireStaionService.postFireStation(fireStation);
	return new ResponseEntity<String>("POST request to /firestation successful", HttpStatus.CREATED);
    }

    @PutMapping(value = "/firestation")
    public ResponseEntity<String> updatePerson(@RequestBody FireStation fireStation) {
	logger.info("PUT request to /firestation");
	FireStaionService.postFireStation(fireStation);
	return new ResponseEntity<String>("PUT request to /person successful", HttpStatus.OK);
    }

    @DeleteMapping(value = "/firestation")
    public ResponseEntity<String> removePerson(@RequestBody FireStation fireStation) {
	logger.info("DELETE request to /firestation");
	FireStaionService.deleteFireStation(fireStation);
	return new ResponseEntity<String>("DELETE request to /firestation successful", HttpStatus.OK);
    }

}
