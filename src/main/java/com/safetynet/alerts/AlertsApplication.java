package com.safetynet.alerts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.safetynet.alerts.model.JsonData;

@SpringBootApplication
public class AlertsApplication {

    private static final Logger logger = LogManager.getLogger("AlertsApplication");

    public static void main(String[] args) throws IOException {
//	FileReader file = new FileReader("src/main/resources/data.json");
//	try (BufferedReader reader = new BufferedReader(file)) {
//	    String key = "";
//	    String line = reader.readLine();
//
//	    while (line != null) {
//		key += line;
//		line = reader.readLine();
//	    }
//	    // key.replaceAll("\\s+", "");
//	    System.out.println(key); // so key works
//
//	    logger.info("Test Info");
//	    Any obj = JsonIterator.deserialize(key);
//	    Any testObj = obj.get("persons");
//	    System.out.println(obj.get("persons"));
//	}

	String jsonPath = "src/main/resources/data.json";

	try (FileReader file = new FileReader(jsonPath)) {
	    BufferedReader reader = new BufferedReader(file);
	    String jsonString = "";
	    String line = reader.readLine();

	    while (line != null) {
		jsonString += line;
		line = reader.readLine();
	    }
	    Map<String, Any> deserializedMap = JsonIterator.deserialize(jsonString).asMap();
	    // System.out.println(deserializedMap);
	    deserializedMap.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));
	    JsonData obj = JsonIterator.deserialize(jsonString, JsonData.class);
	    System.out.println(obj);
	    System.out.println(obj.getPersons());

	    SpringApplication.run(AlertsApplication.class, args);
	}
    }
}
