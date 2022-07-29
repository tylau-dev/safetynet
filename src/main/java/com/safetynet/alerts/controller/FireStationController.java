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
    private IFireStationService FireStationService;
    private static final Logger logger = LogManager.getLogger("FireStationController");

    @GetMapping("/firestation")
    public List<FireStation> listFireStations() {
	logger.info("GET request to /firestation");
	return FireStationService.getFireStations();
    }

    @PostMapping(value = "/firestation")
    public ResponseEntity<String> addFireStation(@RequestBody FireStation fireStation) {
	logger.info("POST request to /firestation");
	try {
	    if (fireStation.getAddress().equals(null)) {
		throw new Exception();
	    }
	    FireStationService.postFireStation(fireStation);
	    logger.info("FireStationService.postFireStation success");
	    return new ResponseEntity<String>("POST request to /firestation successful", HttpStatus.CREATED);
	} catch (Exception e) {
	    logger.error("FireStationService.postFireStation failed: Missing Values");
	    return new ResponseEntity<String>("POST request to /firestation failed: Missing Values",
		    HttpStatus.BAD_REQUEST);
	}
    }

    @PutMapping(value = "/firestation")
    public ResponseEntity<String> updateFireStation(@RequestBody FireStation fireStation) {
	logger.info("PUT request to /firestation");
	try {
	    if (fireStation.getAddress().equals(null)) {
		throw new Exception();
	    }
	    FireStationService.putFireStation(fireStation);
	    logger.info("FireStationService.putFireStation success");
	    return new ResponseEntity<String>("PUT request to /firestation successful", HttpStatus.OK);
	} catch (Exception e) {
	    logger.error("FireStationService.putFireStation failed: Missing Values");
	    return new ResponseEntity<String>("PUT request to /firestation failed: Missing Values",
		    HttpStatus.BAD_REQUEST);
	}
    }

    @DeleteMapping(value = "/firestation")
    public ResponseEntity<String> removeFireStation(@RequestBody FireStation fireStation) {
	logger.info("DELETE request to /firestation");
	try {
	    if (fireStation.getAddress().equals(null)) {
		throw new Exception();
	    }
	    FireStationService.deleteFireStation(fireStation);
	    logger.info("FireStationService.deleteFireStation success");
	    return new ResponseEntity<String>("DELETE request to /firestation successful", HttpStatus.OK);
	} catch (Exception e) {
	    logger.error("FireStationService.postFireStation failed: Missing Values");
	    return new ResponseEntity<String>("DELETE request to /firestation failed: Missing Values",
		    HttpStatus.BAD_REQUEST);
	}
    }

}
