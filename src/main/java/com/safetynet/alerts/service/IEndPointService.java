package com.safetynet.alerts.service;

import java.util.List;

import com.safetynet.alerts.model.endpoint.FireStationCoverage;

public interface IEndPointService {
    public List<FireStationCoverage> getFireStationCoverage(String stationNumber);
}
