package com.safetynet.alerts.model.status;

import java.util.List;

import com.safetynet.alerts.model.Person;

//childAlert
public class ChildAlert {
    public String firstName;
    public String lastName;
    public List<Person> familyMembers;

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

    public List<Person> getFamilyMembers() {
	return familyMembers;
    }

    public void setFamilyMembers(List<Person> familyMembers) {
	this.familyMembers = familyMembers;
    }

    public ChildAlert(String firstName, String lastName, List<Person> familyMembers) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.familyMembers = familyMembers;
    }

}
