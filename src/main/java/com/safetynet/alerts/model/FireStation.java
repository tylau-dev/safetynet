package com.safetynet.alerts.model;

public class FireStation {
    public Integer id;
    public Address address;
    public Integer station;

    public FireStation() {
	super();
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Address getAddress() {
	return address;
    }

    public void setAddress(Address address) {
	this.address = address;
    }

    public Integer getStation() {
	return station;
    }

    public void setStation(Integer station) {
	this.station = station;
    }

}
