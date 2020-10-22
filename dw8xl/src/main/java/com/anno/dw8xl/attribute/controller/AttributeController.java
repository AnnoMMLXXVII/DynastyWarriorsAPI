/**
 * 
 */
package com.anno.dw8xl.attribute.controller;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anno.dw8xl.attribute.facade.AttributeFacade_I;
import com.anno.dw8xl.attribute.model.AttributeI;

/**
 * @author venividivicihofneondeion010101
 *
 */
@RestController
@SuppressWarnings("unchecked")
public class AttributeController<E> {
	
	@Autowired
	private AttributeFacade_I facade;
	
	@GetMapping(value = "/ping", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<E> ping() {
		return (ResponseEntity<E>) new ResponseEntity<>(Arrays.asList("Attributes", "Controller", "Ping", "Works", "As", "Expected"), HttpStatus.OK);
	}
	
	@GetMapping(value = "/attributes", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<E> getAttributes(
			@RequestParam(value = "type", required = false, defaultValue = "") String type) {
		if(type.equals("normal")) {
			return (ResponseEntity<E>) new ResponseEntity<>(facade.getNormalAttributes(), HttpStatus.OK);
		}
		else if (type.equals("special")) {
			return (ResponseEntity<E>) new ResponseEntity<>(facade.getSpecialAttributes(), HttpStatus.OK);
		}
		else {
			return (ResponseEntity<E>) new ResponseEntity<>(facade.getAllAttributes(), HttpStatus.OK);			
		}
	}
	
	@PostMapping(value = "/attributes", produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<E> createAttribute(
			@RequestBody(required = true) AttributeI attribute) {
		AttributeI result = facade.createAttribute(attribute);
		return (result == null) ?
			(ResponseEntity<E>) new ResponseEntity<>("Cannot Create due to already-existing Attribute!", HttpStatus.BAD_REQUEST)
		: (ResponseEntity<E>) new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/attributes", produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<E> updateAttribute(
			@RequestBody(required = true) List<AttributeI> attribute,
			@RequestParam(value = "name", required = true) String...name) {
		List<AttributeI> result = facade.updateAttributes(attribute, name);
		
		return (result.isEmpty()) ?
			(ResponseEntity<E>) new ResponseEntity<>("Cannot find attribute to update".toUpperCase(), HttpStatus.BAD_REQUEST)
		: (ResponseEntity<E>) new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/attributes", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<E> deleteAttribute(
			@RequestBody(required = true) List<AttributeI> attribute) {
		return (ResponseEntity<E>) new ResponseEntity<>(facade.removeAttribute(attribute), HttpStatus.OK);
	}
	
	
}
