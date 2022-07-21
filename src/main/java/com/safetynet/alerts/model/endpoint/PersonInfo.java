package com.safetynet.alerts.model.endpoint;

import java.util.List;

// personInfo
public class PersonInfo {
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String zip;
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

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getZip() {
	return zip;
    }

    public void setZip(String zip) {
	this.zip = zip;
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

    public PersonInfo(String firstName, String lastName, String address, String city, String zip,
	    List<String> medications, List<String> allergies) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.city = city;
	this.zip = zip;
	this.medications = medications;
	this.allergies = allergies;
    }

}
