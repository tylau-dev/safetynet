package com.safetynet.alerts.model.endpoint;

import java.util.List;

//firestation?stationNumber
public class FireStationCoverage {
    public List<FireStationCoveragePerson> fireStationCoveragePerson;
    public Integer adultNumber;
    public Integer childNumber;

    public List<FireStationCoveragePerson> getFireStationCoveragePerson() {
	return fireStationCoveragePerson;
    }

    public void setFireStationCoveragePerson(List<FireStationCoveragePerson> fireStationCoveragePerson) {
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

    public FireStationCoverage(List<FireStationCoveragePerson> fireStationCoveragePerson, Integer adultNumber,
	    Integer childNumber) {
	super();
	this.fireStationCoveragePerson = fireStationCoveragePerson;
	this.adultNumber = adultNumber;
	this.childNumber = childNumber;
    }

}
