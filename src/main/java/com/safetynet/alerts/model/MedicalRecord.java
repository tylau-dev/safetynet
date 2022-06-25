package com.safetynet.alerts.model;

public class MedicalRecord {
    public String firstName;
    public String lastName;
    public String birthDate;
    public Medication[] medications;
    public Allergy[] allergies;

    public MedicalRecord() {
    }

    public MedicalRecord(String firstName, String lastName, String birthDate, Medication[] medications,
	    Allergy[] allergies) {
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

    public Medication[] getMedications() {
	return medications;
    }

    public void setMedications(Medication[] medications) {
	this.medications = medications;
    }

    public Allergy[] getAllergies() {
	return allergies;
    }

    public void setAllergies(Allergy[] allergies) {
	this.allergies = allergies;
    }

}
