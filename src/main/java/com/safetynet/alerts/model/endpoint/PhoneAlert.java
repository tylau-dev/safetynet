package com.safetynet.alerts.model.endpoint;

//phoneAlert
public class PhoneAlert {
    public String phone;

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public PhoneAlert(String phone) {
	super();
	this.phone = phone;
    }

}
