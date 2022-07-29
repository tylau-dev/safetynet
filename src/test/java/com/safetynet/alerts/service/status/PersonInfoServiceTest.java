package com.safetynet.alerts.service.status;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.model.status.PersonInfo;

@SpringBootTest
public class PersonInfoServiceTest {
    @Autowired
    private IPersonInfoService personInfoService;

    @Test
    public void shouldRetrieveCorrectPersonInfo() {
	List<PersonInfo> personInfoResult = personInfoService.getPersonInfo("John", "Boyd");

	assertEquals(personInfoResult.get(0).getFirstName(), "John");
	assertEquals(personInfoResult.get(0).getLastName(), "Boyd");
	assertEquals(personInfoResult.get(0).getAge(), 38);
	assertEquals(personInfoResult.get(0).getAddress(), "1509 Culver St");
    }

}
