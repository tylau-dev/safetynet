package com.safetynet.alerts.service.status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.alerts.model.status.FireStationCoverage;

@SpringBootTest
public class FireStationCoverageServiceTest {
    @Autowired
    private IFireStationCoverageService fireStationCoverageService;

    @Test
    public void shouldRetrieveCorrectFireStationCoverage() {
	FireStationCoverage fireStationTestResult = fireStationCoverageService.getFireStationCoverage(2);

	assertEquals(fireStationTestResult.getAdultNumber(), 4);
	assertEquals(fireStationTestResult.getChildNumber(), 1);
	assertNotNull(fireStationTestResult.getFireStationCoveragePerson());

    }
}
