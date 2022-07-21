package com.safetynet.alerts.service.status;

import java.util.List;

import com.safetynet.alerts.model.status.FloodStation;

public interface IFloodStationsService {
    List<FloodStation> getFloodStation(List<Integer> stationNumbers);
}
