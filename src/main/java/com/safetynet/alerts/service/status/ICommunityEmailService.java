package com.safetynet.alerts.service.status;

import java.util.List;

import com.safetynet.alerts.model.status.CommunityEmail;

public interface ICommunityEmailService {
    List<CommunityEmail> getCommunityEmail(String city);

}
