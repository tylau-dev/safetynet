package com.safetynet.alerts.service.status;

import com.safetynet.alerts.model.status.FireAddressAlert;

public interface IFireAddressAlertService {
    FireAddressAlert getFireAddressAlert(String address);
}
