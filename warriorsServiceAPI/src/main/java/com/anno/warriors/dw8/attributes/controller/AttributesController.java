package com.anno.warriors.dw8.attributes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anno.warriors.dw8.attributes.facade.AttributesFacadeInterface;
import com.anno.warriors.dw8.attributes.model.AttributeInterface;

@RestController
@RequestMapping(value = "dw8/attributes")
public class AttributesController {

	@Autowired
	private AttributesFacadeInterface facade;

	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<AttributeInterface>> getAllAttributes() {
		return new ResponseEntity<>(facade.callingGetAllAttributes(), HttpStatus.OK);
	}

	@RequestMapping(value = "/normal", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<AttributeInterface>> getNormalAttributes() {
		return new ResponseEntity<>(facade.callingGetNormalAttributes(), HttpStatus.OK);
	}

	@RequestMapping(value = "/special", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<AttributeInterface>> getSpecialAttributes() {
		return new ResponseEntity<>(facade.callingGetSpecialAttributes(), HttpStatus.OK);
	}

	@RequestMapping(value = "/normal", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<List<AttributeInterface>> getNormalAttributesByName(
			@RequestBody(required = true) String[] names) {
		return new ResponseEntity<>(facade.callingGetNormalAttributesByNames(names), HttpStatus.OK);
	}

	@RequestMapping(value = "/special", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<List<AttributeInterface>> getSpecialAttributesByName(
			@RequestBody(required = true) String[] names) {
		return new ResponseEntity<>(facade.callingGetSpecialAttributesByNames(names), HttpStatus.OK);
	}
}
