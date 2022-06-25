package com.safetynet.alerts.model;

import java.util.List;

public class JsonData {
    List<Person> persons;
    List<FireStation> firestations;
    List<MedicalRecord> medicalRecords;

    public JsonData() {
	super();
    }

    public JsonData(List<Person> persons, List<FireStation> firestations, List<MedicalRecord> medicalRecords) {
	super();
	this.persons = persons;
	this.firestations = firestations;
	this.medicalRecords = medicalRecords;
    }

    public List<Person> getPersons() {
	return persons;
    }

    public void setPersons(List<Person> persons) {
	this.persons = persons;
    }

    public List<FireStation> getFirestations() {
	return firestations;
    }

    public void setFirestations(List<FireStation> firestations) {
	this.firestations = firestations;
    }

    public List<MedicalRecord> getMedicalRecords() {
	return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
	this.medicalRecords = medicalRecords;
    }
}
