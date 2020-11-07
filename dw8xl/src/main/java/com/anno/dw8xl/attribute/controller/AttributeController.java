/**
 * 
 */
package com.anno.dw8xl.attribute.controller;

import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anno.dw8xl.attribute.facade.AttributeFacadeInterface;
import com.anno.dw8xl.attribute.model.AttributeI;
import com.anno.dw8xl.attribute.model.NullAttribute;

/**
 * @author venividivicihofneondeion010101
 *
 */
@RestController
@RequestMapping(value = "/attributes")
public class AttributeController {
	
	@Autowired
	private AttributeFacadeInterface facade;
	
	@GetMapping(value = "/ping", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> ping() {
		return  new ResponseEntity<>(String.format("%s %s %s %s %s %s","Attributes", "Controller", "Ping", "Works", "As", "Expected"), HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Collection<AttributeI>> getAttributes(
			@RequestParam(value = "type", required = false, defaultValue = "") String type) {
		if(type.equalsIgnoreCase("normal")) {
			return new ResponseEntity<>(facade.getNormalAttributes(), HttpStatus.OK);
		}
		else if (type.equalsIgnoreCase("special")) {
			return new ResponseEntity<>(facade.getSpecialAttributes(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(facade.getAllAttributes(), HttpStatus.OK);			
		}
	}
	
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<AttributeI> createAttribute(
			@RequestBody(required = true) AttributeI attribute) {
		AttributeI result = facade.createAttribute(attribute);
		return (result == null) ?
			new ResponseEntity<>(new NullAttribute(), HttpStatus.BAD_REQUEST)
		: new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
	@PutMapping(produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<Collection<AttributeI>> updateAttribute(
			@RequestBody(required = true) List<AttributeI> attribute,
			@RequestParam(value = "name", required = true) String...name) {
		Collection<AttributeI> result = facade.updateAttributes(attribute, name);
		
		return (result.isEmpty()) ?
			new ResponseEntity<>(new ArrayList<>() , HttpStatus.BAD_REQUEST)
			: new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@DeleteMapping(produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> deleteAttribute(
			@RequestBody(required = true) List<AttributeI> attribute) {
		List<AttributeI> before = facade.getAllAttributes();
		int size = before.size();
		int result = (size - attribute.size());
		facade.removeAttribute(attribute);
		List<AttributeI> after = facade.getAllAttributes();
		int postSize = after.size();
		return (postSize != result) ? new ResponseEntity<>("Could not Delete One or More!", HttpStatus.BAD_REQUEST)
		: new ResponseEntity<>(after.toString(), HttpStatus.OK);
	}
	
	
}
