package com.anno.dw8xl.character.controller;

import java.util.Collection;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anno.dw8xl.character.facade.CharacterFacadeInterface;
import com.anno.dw8xl.character.model.CharacterI;

/**
 * @author Haku Wei
 *
 */
@RestController
@RequestMapping("/characters")
public class CharacterController {

	@Autowired
	private CharacterFacadeInterface facade;

	@GetMapping(value = "/ping", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> ping() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Collection<CharacterI>> getAllCharacters() {
		return new ResponseEntity<>(facade.getAllCharacters(), HttpStatus.OK);
	}

	@GetMapping(value = "/officers/", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> getAllOfficers() {
		return new ResponseEntity<>(facade.getAllOfficers(), HttpStatus.OK);
	}

	@GetMapping(value = "/officers/{kingdom}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Collection<CharacterI>> getOfficers(@PathVariable(value = "kingdom") String kingdom) {
		return new ResponseEntity<>(facade.getOfficerByKingdom(kingdom), HttpStatus.OK);
	}

	@GetMapping(value = "/sub-officers/", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> getAllSubOfficers() {
		return new ResponseEntity<>(facade.getAllSubOfficers(), HttpStatus.OK);
	}

	@GetMapping(value = "/sub-officers/{kingdom}")
	public ResponseEntity<Collection<CharacterI>> getSubOfficersByKingdom(
			@PathVariable(value = "kingdom") String kingdom) {
		return new ResponseEntity<>(facade.getSubOfficerByKingdom(kingdom.trim()), HttpStatus.BAD_REQUEST);
	}

}
