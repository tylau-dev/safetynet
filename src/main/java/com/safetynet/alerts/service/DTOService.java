package com.safetynet.alerts.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;

public class DTOService {
    private String jsonPath;

    public DTOService(String jsonPath) {
	this.setJsonPath(jsonPath);
    }

    public String getJsonPath() {
	return this.jsonPath;
    }

    public void setJsonPath(String jsonLocation) {
	this.jsonPath = jsonPath;
    }

    public Map<String, Any> readJson(String property) throws FileNotFoundException, IOException {
	String jsonPath = this.getJsonPath();

	try (FileReader file = new FileReader(jsonPath)) {
	    BufferedReader reader = new BufferedReader(file);
	    String jsonString = "";
	    String line = reader.readLine();

	    while (line != null) {
		jsonString += line;
		line = reader.readLine();
	    }
	    Map<String, Any> deserializedMap = JsonIterator.deserialize(jsonString).asMap();

	    return deserializedMap;
	}
    };

    // For now, writing only on one property?
    public void writeJson(Map<String, String> values, String property) {
	String jsonPath = this.getJsonPath();

	String stringToWrite = String.format("%s: {}", property);

	try (FileWriter fileWriter = new FileWriter(jsonPath)) {
	    fileWriter.write(stringToWrite);
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    public void deleteJson(String[] values, String property) {

    };
}
