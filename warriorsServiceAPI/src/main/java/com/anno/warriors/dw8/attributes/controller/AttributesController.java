package com.anno.warriors.dw8.attributes.controller;

import static com.anno.warriors.shared.ApplicationConstants.CROSS_ORIGIN_LOCAL_HOST;
import static com.anno.warriors.shared.ApplicationConstants.LEGENDARY_WARRIORS_NETLIFY;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anno.warriors.dw8.attributes.facade.AttributesFacadeInterface;
import com.anno.warriors.dw8.attributes.model.AttributeInterface;

@RestController
@CrossOrigin(origins = { CROSS_ORIGIN_LOCAL_HOST, LEGENDARY_WARRIORS_NETLIFY })
@RequestMapping(value = "dw8/attributes")
public class AttributesController {
	private Logger logger = LogManager.getLogger();

	@Autowired
	private AttributesFacadeInterface facade;

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttributeInterface>> getAllAttributes() {
		logger.info("Request All Attribtues");
		return new ResponseEntity<>(facade.callingGetAllAttributes(), HttpStatus.OK);
	}

	@GetMapping(value = "/attribute/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttributeInterface> getAllAttributes(@PathVariable(required = true) String name) {
		logger.info("Request Attribute by name: {}", name);
		return new ResponseEntity<>(facade.callingGetAllAttribute(name), HttpStatus.OK);
	}

	@GetMapping(value = "/type/{type:normal|special}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttributeInterface>> getAttributeByType(@PathVariable(required = true) String type) {
		logger.info("Request Attribute by type: {}", type);
		return new ResponseEntity<>(facade.callingGetAllAttributes(type), HttpStatus.OK);
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttributeInterface>> getAttributeByType(@RequestBody(required = true) String... names) {
		logger.info("Request Attribute by names");
		return new ResponseEntity<>(facade.callingGetAllAttributes(names), HttpStatus.OK);
	}

	@PostMapping(value = "/attribute/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttributeInterface> createAttribute(
			@RequestBody(required = true) AttributeInterface attribute) {
		logger.info("Creating New Attribute: {}", attribute.getName());
		return new ResponseEntity<>(facade.callingCreateAttribute(attribute), HttpStatus.OK);
	}

	@PostMapping(value = "/attribute/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttributeInterface> updateAttribute(@PathVariable(required = true) String name,
			@RequestBody(required = true) AttributeInterface attribute) {
		logger.info("Updating Attribute: {}", name);
		return new ResponseEntity<>(facade.callingUpdateAttribute(name, attribute), HttpStatus.OK);
	}

	@DeleteMapping(value = "/attribute/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttributeInterface> removeAttribute(@PathVariable(required = true) String name) {
		logger.info("Removing Attribute: {}", name);
		return new ResponseEntity<>(facade.callingRemoveAttribute(name), HttpStatus.OK);
	}
}
