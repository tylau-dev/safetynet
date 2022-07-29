package com.safetynet.alerts.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.safetynet.alerts.utils.AgeHandler;

public class AgeHandlerTest {
    @Test
    public void calculateAge() {
	String testInputDate = "01/01/2012";
	Date testToDate = new Date(1658418108782L);

	assertEquals(AgeHandler.computeAge(testInputDate, testToDate), 10);
    }
}
