package com.safetynet.alerts.service.status;

import java.util.List;

import com.safetynet.alerts.model.status.PhoneAlert;

public interface IPhoneAlertService {
    List<PhoneAlert> getPhoneAlert(int stationNumber);
}
