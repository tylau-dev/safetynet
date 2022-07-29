package com.safetynet.alerts.service.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.status.CommunityEmail;
import com.safetynet.alerts.repository.IDTOjson;

/*
 * Format data from DTO into CommunityEmail
 */
@Service
public class CommunityEmailService implements ICommunityEmailService {
    @Autowired
    private IDTOjson DTOjson;
    private static final Logger logger = LogManager.getLogger("CommunityEmailService");

    /*
     * @Param String city
     */
    @Override
    public List<CommunityEmail> getCommunityEmail(String city) {
	List<CommunityEmail> resultCommunityEmail = new ArrayList<CommunityEmail>();
	List<Person> persons = DTOjson.getJsonData().getPersons();

	// Looping through persons to filter out the person living in the city and
	// adding the mail to the list of CommunityEmail
	for (Person person : persons) {
	    if (person.getCity().equals(city)) {
		resultCommunityEmail.add(new CommunityEmail(person.getEmail()));
	    }
	}

	return resultCommunityEmail;
    }

}
