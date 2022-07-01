package com.safetynet.alerts.repository;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.safetynet.alerts.model.JsonData;

public interface IDTOjson {

    JsonData getJsonData();

    void setJsonData(JsonData jsonData);

    String getJsonPath();

    void setJsonPath(String jsonLocation);

    void readJson(String property) throws FileNotFoundException, IOException;

    // void writeJson(String[] values, String property);

}
