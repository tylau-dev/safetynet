package com.safetynet.alerts.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.status.ChildAlert;
import com.safetynet.alerts.model.status.FireStationCoverage;
import com.safetynet.alerts.service.status.IChildAlertService;
import com.safetynet.alerts.service.status.IFireStationCoverageService;

@RestController

public class StatusController {
    @Autowired
    private IFireStationCoverageService FireStationCoverageService;

    @Autowired
    private IChildAlertService ChildAlertService;
    private static final Logger logger = LogManager.getLogger("EndPointController");

    @RequestMapping(value = "/firestation", method = RequestMethod.GET, params = { "stationNumber" })
    public FireStationCoverage listFireStationCoverage(@RequestParam(value = "stationNumber") int stationNumber) {
	logger.info(String.format("GET request to /firestation?statioNumber=%s", stationNumber));
	return FireStationCoverageService.getFireStationCoverage(stationNumber);
    }

    @RequestMapping(value = "/childAlert", method = RequestMethod.GET, params = { "address" })
    public List<ChildAlert> listChildAlert(@RequestParam(value = "address") String address) {
	logger.info(String.format("GET request to /childAlert?address=%s", address));
	return ChildAlertService.getChildAlert(address);
    }

}
