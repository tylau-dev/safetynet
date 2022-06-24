package com.safetynet.alerts.model;

public class MedicalRecord {
    public String firstName;
    public String lastName;
    public Medication[] medications;
    public Allergy[] allergies;

    public MedicalRecord() {
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
