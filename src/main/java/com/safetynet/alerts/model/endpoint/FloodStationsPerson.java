package com.safetynet.alerts.model.endpoint;

import java.util.List;

public class FloodStationsPerson {
    public String firstName;
    public String lastName;
    public Integer age;
    public List<String> medications;
    public List<String> allergies;

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

    public Integer getAge() {
	return age;
    }

    public void setAge(Integer age) {
	this.age = age;
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

    public FloodStationsPerson(String firstName, String lastName, Integer age, List<String> medications,
	    List<String> allergies) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.medications = medications;
	this.allergies = allergies;
    }

}
