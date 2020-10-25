/**
 * 
 */
package com.anno.dw8xl.character.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anno.dw8xl.character.facade.CharacterFacade_I;
import com.anno.dw8xl.character.model.CharacterI;

/**
 * @author Haku Wei
 *
 */
@RestController
@RequestMapping("/characters")
public class CharacterController {

	@Autowired
	private CharacterFacade_I facade;
	
	@GetMapping(value = "/ping", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> ping() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Collection<CharacterI>> getAllCharacters() {
		return new ResponseEntity<>(facade.getAllCharacters(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/officers/", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<CharacterI>> getAllSubOfficers() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/sub-officers/", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<CharacterI>> getAllOfficers() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/sub-officers/{kingdom}")
	public ResponseEntity<List<CharacterI>> getSubOfficersByKingdom(@PathVariable(value = "kingdom") String kingdom) {
		if(kingdom.equalsIgnoreCase("shu")) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}


}
