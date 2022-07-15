package com.safetynet.alerts.model;

import java.util.List;

public class MedicalRecord {
    public String firstName;
    public String lastName;
    public String birthdate;
    public List<String> medications;
    public List<String> allergies;

    public MedicalRecord() {
    }

    public MedicalRecord(String firstName, String lastName, String birthdate, List<String> medications,
	    List<String> allergies) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.birthdate = birthdate;
	this.medications = medications;
	this.allergies = allergies;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getBirthDate() {
	return birthdate;
    }

    public void setBirthDate(String birthdate) {
	this.birthdate = birthdate;
    }

    public List<String> getMedications() {
	return medications;
    }

    public void setMedications(List<String> medications) {
	this.medications = medications;
    }

    public List<String> getAllergies() {
	return allergies;
    }

    public void setAllergies(List<String> allergies) {
	this.allergies = allergies;
    }

}
