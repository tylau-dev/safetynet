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
	MedicalRecordService.postMedicalRecord(medicalRecord);
	return new ResponseEntity<String>("POST request to /medicalRecord successful", HttpStatus.CREATED);
    }

    @PutMapping(value = "/medicalRecord")
    public ResponseEntity<String> updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
	logger.info("PUT request to /medicalRecord");
	MedicalRecordService.putMedicalRecord(medicalRecord);
	return new ResponseEntity<String>("PUT request to /medicalRecord successful", HttpStatus.OK);
    }

    @DeleteMapping(value = "/medicalRecord")
    public ResponseEntity<String> removeMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
	logger.info("DELETE request to /firestation");
	MedicalRecordService.deleteMedicalRecord(medicalRecord);
	return new ResponseEntity<String>("DELETE request to /medicalRecord successful", HttpStatus.OK);
    }

}
