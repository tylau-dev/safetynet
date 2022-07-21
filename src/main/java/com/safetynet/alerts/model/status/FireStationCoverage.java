package com.safetynet.alerts.model.status;

import java.util.List;

import com.safetynet.alerts.model.Person;

//firestation?stationNumber
public class FireStationCoverage {
    public List<Person> fireStationCoveragePerson;
    public Integer adultNumber;
    public Integer childNumber;

    public List<Person> getFireStationCoveragePerson() {
	return fireStationCoveragePerson;
    }

    public void setFireStationCoveragePerson(List<Person> fireStationCoveragePerson) {
	this.fireStationCoveragePerson = fireStationCoveragePerson;
    }

    public Integer getChildNumber() {
	return childNumber;
    }

    public void setChildNumber(Integer childNumber) {
	this.childNumber = childNumber;
    }

    public Integer getAdultNumber() {
	return adultNumber;
    }

    public void setAdultNumber(Integer adultNumber) {
	this.adultNumber = adultNumber;
    }

    public FireStationCoverage(List<Person> fireStationCoveragePerson, Integer adultNumber, Integer childNumber) {
	super();
	this.fireStationCoveragePerson = fireStationCoveragePerson;
	this.adultNumber = adultNumber;
	this.childNumber = childNumber;
    }

    public FireStationCoverage() {
	super();
    }

}
