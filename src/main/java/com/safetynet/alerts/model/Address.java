package com.safetynet.alerts.model;

public class Address {
    public Integer addressNumber;

    public String addressName;

    public String city;

    public String zip;

    public Address() {

    }

    public Integer getAddressNumber() {
	return addressNumber;
    }

    public void setAddressNumber(Integer addressNumber) {
	this.addressNumber = addressNumber;
    }

    public String getAddressName() {
	return addressName;
    }

    public void setAddressName(String addressName) {
	this.addressName = addressName;
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

}
