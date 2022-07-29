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

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.service.IMedicalRecordService;

@RestController
public class MedicalRecordController {
    @Autowired
    private IMedicalRecordService MedicalRecordService;
    private static final Logger logger = LogManager.getLogger("MedicalRecordController");

    @GetMapping("/medicalRecord")
    public List<MedicalRecord> listMedicalRecords() {
	logger.info("GET request to /medicalRecord");
	return MedicalRecordService.getMedicalRecords();
    }

    @PostMapping(value = "/medicalRecord")
    public ResponseEntity<String> addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
	logger.info("POST request to /medicalRecord");
	try {
	    if (medicalRecord.getFirstName().equals(null) || medicalRecord.getLastName().equals(null)) {
		throw new Exception();
	    }
	    MedicalRecordService.postMedicalRecord(medicalRecord);
	    logger.info("MedicalRecordService.postMedicalRecord success");
	    return new ResponseEntity<String>("POST request to /medicalRecord successful", HttpStatus.CREATED);
	} catch (Exception e) {
	    logger.error("MedicalRecordService.postMedicalRecord failed: Missing Values");
	    return new ResponseEntity<String>("POST request to /medicalRecord failed: Missing Values",
		    HttpStatus.BAD_REQUEST);
	}
    }

    @PutMapping(value = "/medicalRecord")
    public ResponseEntity<String> updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
	logger.info("PUT request to /medicalRecord");
	try {
	    if (medicalRecord.getFirstName().equals(null) || medicalRecord.getLastName().equals(null)) {
		throw new Exception();
	    }
	    MedicalRecordService.putMedicalRecord(medicalRecord);
	    logger.info("MedicalRecordService.putMedicalRecord success");
	    return new ResponseEntity<String>("PUT request to /medicalRecord successful", HttpStatus.OK);
	} catch (Exception e) {
	    logger.error("MedicalRecordService.putMedicalRecord failed: Missing Values");
	    return new ResponseEntity<String>("PUT request to /medicalRecord failed: Missing Values",
		    HttpStatus.BAD_REQUEST);
	}
    }

    @DeleteMapping(value = "/medicalRecord")
    public ResponseEntity<String> removeMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
	logger.info("DELETE request to /firestation");
	try {
	    if (medicalRecord.getFirstName().equals(null) || medicalRecord.getLastName().equals(null)) {
		throw new Exception();
	    }
	    MedicalRecordService.deleteMedicalRecord(medicalRecord);
	    logger.info("MedicalRecordService.deleteMedicalRecord success");
	    return new ResponseEntity<String>("DELETE request to /medicalRecord successful", HttpStatus.OK);
	} catch (Exception e) {
	    logger.error("MedicalRecordService.deleteMedicalRecord failed: Missing Values");
	    return new ResponseEntity<String>("DELETE request to /medicalRecord failed: Missing Values",
		    HttpStatus.BAD_REQUEST);
	}
    }

}
