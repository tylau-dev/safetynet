package com.safetynet.alerts.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alerts.model.status.ChildAlert;
import com.safetynet.alerts.model.status.CommunityEmail;
import com.safetynet.alerts.model.status.FireAddressAlert;
import com.safetynet.alerts.model.status.FireStationCoverage;
import com.safetynet.alerts.model.status.FloodStation;
import com.safetynet.alerts.model.status.PersonInfo;
import com.safetynet.alerts.model.status.PhoneAlert;
import com.safetynet.alerts.service.status.IChildAlertService;
import com.safetynet.alerts.service.status.ICommunityEmailService;
import com.safetynet.alerts.service.status.IFireAddressAlertService;
import com.safetynet.alerts.service.status.IFireStationCoverageService;
import com.safetynet.alerts.service.status.IFloodStationsService;
import com.safetynet.alerts.service.status.IPersonInfoService;
import com.safetynet.alerts.service.status.IPhoneAlertService;

@RestController

public class StatusController {

    private IFireStationCoverageService FireStationCoverageService;
    private IChildAlertService ChildAlertService;
    private IPhoneAlertService PhoneAlertService;
    private IFireAddressAlertService FireAddressAlertService;
    private IFloodStationsService FloodStationsService;
    private IPersonInfoService PersonInfoService;
    private ICommunityEmailService CommunityEmailService;

    public StatusController(IFireStationCoverageService fireStationCoverageService,
	    IChildAlertService childAlertService, IPhoneAlertService phoneAlertService,
	    IFireAddressAlertService fireAddressAlertService, IFloodStationsService floodStationsService,
	    IPersonInfoService personInfoService, ICommunityEmailService communityEmailService) {
	super();
	FireStationCoverageService = fireStationCoverageService;
	ChildAlertService = childAlertService;
	PhoneAlertService = phoneAlertService;
	FireAddressAlertService = fireAddressAlertService;
	FloodStationsService = floodStationsService;
	PersonInfoService = personInfoService;
	CommunityEmailService = communityEmailService;
    }

    // Mettre les Autowired dans constructor

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

    @RequestMapping(value = "/phoneAlert", method = RequestMethod.GET, params = { "firestation" })
    public List<PhoneAlert> listPhoneAlert(@RequestParam(value = "firestation") int stationNumber) {
	logger.info(String.format("GET request to /phoneAlert?firestation=%s", stationNumber));
	return PhoneAlertService.getPhoneAlert(stationNumber);
    }

    @RequestMapping(value = "/fire", method = RequestMethod.GET, params = { "address" })
    public FireAddressAlert listFireAddressAlert(@RequestParam(value = "address") String address) {
	logger.info(String.format("GET request to /fire?address=%s", address));
	return FireAddressAlertService.getFireAddressAlert(address);
    }

    @RequestMapping(value = "/flood/stations", method = RequestMethod.GET, params = { "stations" })
    public List<FloodStation> listFloodStations(@RequestParam(value = "stations") List<Integer> stations) {
	logger.info(String.format("GET request to /flood/stations?stations=%s", stations));
	return FloodStationsService.getFloodStation(stations);
    }

    @RequestMapping(value = "/personInfo", method = RequestMethod.GET, params = { "firstName", "lastName" })
    public List<PersonInfo> listPersonInfo(@RequestParam(value = "firstName") String firstName,
	    @RequestParam(value = "lastName") String lastName) {
	logger.info(String.format("GET request to /personInfo?firstName=%s&lastName=%s", firstName, lastName));
	return PersonInfoService.getPersonInfo(firstName, lastName);
    }

    @RequestMapping(value = "/communityEmail", method = RequestMethod.GET, params = { "city" })
    public List<CommunityEmail> listCommunityEmail(@RequestParam(value = "city") String city) {
	logger.info(String.format("GET request to /communityEmail?city=%s", city));
	return CommunityEmailService.getCommunityEmail(city);
    }

}
