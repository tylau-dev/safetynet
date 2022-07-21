package com.safetynet.alerts.service.status;

import java.util.List;

import com.safetynet.alerts.model.status.ChildAlert;

public interface IChildAlertService {
    List<ChildAlert> getChildAlert(String address);
}
