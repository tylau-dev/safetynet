package com.safetynet.alerts.service.status;

import java.util.List;

import com.safetynet.alerts.model.status.PersonInfo;

public interface IPersonInfoService {
    List<PersonInfo> getPersonInfo(String firstName, String lastName);
}
