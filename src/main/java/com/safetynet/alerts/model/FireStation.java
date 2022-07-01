package com.safetynet.alerts.model;

public class FireStation {
    public String address;
    public String station;

    public FireStation() {
	super();
    }

    public FireStation(String address, String station) {
	super();
	this.address = address;
	this.station = station;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getStation() {
	return station;
    }

    public void setStation(String station) {
	this.station = station;
    }

}
