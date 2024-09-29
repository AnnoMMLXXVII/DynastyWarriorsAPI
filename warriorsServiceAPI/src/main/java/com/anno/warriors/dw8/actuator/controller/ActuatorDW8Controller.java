package com.anno.warriors.dw8.actuator.controller;

import static com.anno.warriors.shared.ApplicationConstants.CROSS_ORIGIN_LOCAL_HOST;
import static com.anno.warriors.shared.ApplicationConstants.LEGENDARY_WARRIORS_NETLIFY;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.actuate.health.Health;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { CROSS_ORIGIN_LOCAL_HOST, LEGENDARY_WARRIORS_NETLIFY })
@RequestMapping(value = "dw8/actuator")
public class ActuatorDW8Controller {

	private Logger logger = LogManager.getLogger();

	@GetMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Health> requestHealthStatus() {
		logger.info("Health Status Requested");
		ResponseEntity<Health> health = null;
		try {
			health = new ResponseEntity<>(Health.up().build(), HttpStatus.OK);
		} catch (Exception ex) {
			health = new ResponseEntity<>(Health.down().build(), HttpStatus.SERVICE_UNAVAILABLE);
		}
		return health;
	}

}
