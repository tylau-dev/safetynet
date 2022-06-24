package com.safetynet.alerts.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.jsoniter.any.Any;

public interface IDTOService {

    Map<String, Any> readJson(String property) throws FileNotFoundException, IOException;

    void writeJson(String[] values, String property);

}
