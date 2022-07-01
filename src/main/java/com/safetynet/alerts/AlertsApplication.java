package com.safetynet.alerts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlertsApplication {

    private static final Logger logger = LogManager.getLogger("AlertsApplication");

    public static void main(String[] args) throws IOException {
	SpringApplication.run(AlertsApplication.class, args);
    }
}
