package com.anno.warriors.dw8.attributes.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anno.warriors.dw8.attributes.facade.AttributesFacadeInterface;
import com.anno.warriors.dw8.attributes.model.AttributeInterface;

@RestController
@RequestMapping(value = "dw8/attributes")
public class AttributesController {
	private Logger logger = LogManager.getLogger();
	@Autowired
	private AttributesFacadeInterface facade;

	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<AttributeInterface>> getAllAttributes() {
		return new ResponseEntity<>(facade.callingGetAllAttributes(), HttpStatus.OK);
	}

	@RequestMapping(value = "/attribute/{name}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<AttributeInterface> getAllAttributes(@PathVariable(required = true) String name) {
		return new ResponseEntity<>(facade.callingGetAllAttribute(name), HttpStatus.OK);
	}

	@RequestMapping(value = "/type/{type:normal|special}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<AttributeInterface>> getAttributeByType(@PathVariable(required = true) String type) {
		return new ResponseEntity<>(facade.callingGetAllAttributes(type), HttpStatus.OK);
	}

	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<List<AttributeInterface>> getAttributeByType(@RequestBody(required = true) String... names) {
		return new ResponseEntity<>(facade.callingGetAllAttributes(names), HttpStatus.OK);
	}

	@RequestMapping(value = "/attribute/{name}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<AttributeInterface> updateAttribute(@PathVariable(required = true) String name,
			@RequestBody(required = true) AttributeInterface attribute) {
		return new ResponseEntity<>(facade.callingUpdateAttribute(name, attribute), HttpStatus.OK);
	}

}
