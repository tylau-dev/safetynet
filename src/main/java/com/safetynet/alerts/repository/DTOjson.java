package com.safetynet.alerts.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.safetynet.alerts.model.JsonData;

@Repository
public class DTOjson implements IDTOjson {
    private String jsonPath = "src/main/resources/data.json";
    private static final Logger logger = LogManager.getLogger("AlertsApplication");

    private JsonData jsonData;

    public DTOjson() throws FileNotFoundException, IOException {
	this.readJson(this.jsonPath);
    }

    @Override
    public JsonData getJsonData() {
	return jsonData;
    }

    @Override
    public void setJsonData(JsonData jsonData) {
	this.jsonData = jsonData;
    }

    @Override
    public String getJsonPath() {
	return this.jsonPath;
    }

    @Override
    public void setJsonPath(String jsonLocation) {
	this.jsonPath = jsonPath;
    }

    @Override
    public void readJson(String property) throws FileNotFoundException, IOException {

	try (FileReader file = new FileReader(this.getJsonPath())) {
	    BufferedReader reader = new BufferedReader(file);
	    String jsonString = "";
	    String line = reader.readLine();

	    while (line != null) {
		jsonString += line;
		line = reader.readLine();
	    }
	    Map<String, Any> deserializedMap = JsonIterator.deserialize(jsonString).asMap();

	    this.setJsonData(JsonIterator.deserialize(jsonString, JsonData.class));
	}
    };

    // @Todo Reserialize whole object
    public void writeJson(Map<String, String> values, String property) {
	String jsonPath = this.getJsonPath();

	String stringToWrite = String.format("%s: {}", property);

	try (FileWriter fileWriter = new FileWriter(jsonPath)) {
	    fileWriter.write(stringToWrite);
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
