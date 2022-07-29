package com.safetynet.alerts.service.status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.model.status.FireAddressAlert;

@SpringBootTest
public class FireAddressAlertServiceTest {
    @Autowired
    private IFireAddressAlertService fireAddressAlertService;

    @Test
    public void shouldRetrieveCorrectAddressAlert() {
	FireAddressAlert fireAddressAlert = fireAddressAlertService.getFireAddressAlert("1509 Culver St");

	assertEquals(fireAddressAlert.getStationNumber(), 3);
	assertNotNull(fireAddressAlert.getResidents());
    }

}
