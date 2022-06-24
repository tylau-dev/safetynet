package com.safetynet.alerts.model;

public class Medication {
    public String name;

    public String quantity;

    public Medication() {
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getQuantity() {
	return quantity;
    }

    public void setQuantity(String quantity) {
	this.quantity = quantity;
    }

}
