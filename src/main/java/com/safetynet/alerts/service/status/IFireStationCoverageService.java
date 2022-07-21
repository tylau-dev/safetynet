package com.safetynet.alerts.service.status;

import com.safetynet.alerts.model.status.FireStationCoverage;

public interface IFireStationCoverageService {
    public FireStationCoverage getFireStationCoverage(int stationNumber);
}
