package com.safetynet.alerts.model;

public class MedicalRecord {
    public String firstName;
    public String lastName;
    public String birthDate;
    public String[] medications;
    public String[] allergies;

    public MedicalRecord() {
    }

    public MedicalRecord(String firstName, String lastName, String birthDate, String[] medications,
	    String[] allergies) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.birthDate = birthDate;
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
	return birthDate;
    }

    public void setBirthDate(String birthDate) {
	this.birthDate = birthDate;
    }

    public String[] getMedications() {
	return medications;
    }

    public void setMedications(String[] medications) {
	this.medications = medications;
    }

    public String[] getAllergies() {
	return allergies;
    }

    public void setAllergies(String[] allergies) {
	this.allergies = allergies;
    }

}
