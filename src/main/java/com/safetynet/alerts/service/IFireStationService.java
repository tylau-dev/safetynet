package com.safetynet.alerts.service;

import java.util.List;

import com.safetynet.alerts.model.FireStation;

public interface IFireStationService {
    public List<FireStation> getFirestations();

    public void postFireStation(FireStation fireStationToAdd);

    public void putFireStation(FireStation fireStationToUpdate);

    public void deleteFireStation(FireStation fireStationToDelete);
}
