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
		return new ResponseEntity<>(
				String.format("%s %s %s %s %s %s", "Attributes", "Controller", "Ping", "Works", "As", "Expected"),
				HttpStatus.OK);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Collection<AttributeI>> getAttributes(
			@RequestParam(value = "state", required = false, defaultValue = "all") String state) {
		if (state.equalsIgnoreCase("normal")) {
			return new ResponseEntity<>(facade.getNormalAttributes(), HttpStatus.OK);
		} else if (state.equalsIgnoreCase("special")) {
			return new ResponseEntity<>(facade.getSpecialAttributes(), HttpStatus.OK);
		} else if (state.equalsIgnoreCase("all")) {
			return new ResponseEntity<>(facade.getAllAttributes(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<AttributeI> createAttribute(@RequestBody(required = true) AttributeI attribute) {
		return new ResponseEntity<>(facade.createAttribute(attribute), HttpStatus.OK);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<Collection<AttributeI>> updateAttribute(
			@RequestBody(required = true) List<AttributeI> attribute,
			@RequestParam(value = "name", required = true) String... name) {
		Collection<AttributeI> result = facade.updateAttributes(attribute, name);
		Collection<AttributeI> inValid = facade.getInValid();
		return (!inValid.isEmpty()) ? new ResponseEntity<>(inValid, HttpStatus.BAD_REQUEST)
				: new ResponseEntity<>(result, HttpStatus.OK);
	}

	@DeleteMapping(produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Collection<AttributeI>> deleteAttribute(
			@RequestBody(required = true) List<AttributeI> attribute) {
		return new ResponseEntity<>(facade.removeAttribute(attribute), HttpStatus.OK);
	}

}
