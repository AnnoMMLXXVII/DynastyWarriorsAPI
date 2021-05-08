package com.anno.warriors.dw8.characters.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anno.warriors.dw8.characters.facade.CharacterFacadeInterface;
import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;

@RestController
@RequestMapping(value = "dw8/characters")
public class CharacterController {

	@Autowired
	private CharacterFacadeInterface facade;

	@RequestMapping(value = "/health-check", method = RequestMethod.GET)
	public ResponseEntity<String> getHealthStatus() {
		return new ResponseEntity<>("Status UP!", HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterInterface<Character>>> getAllCharacters() {
		return new ResponseEntity<>(facade.callingGetAllCharacters(), HttpStatus.OK);
	}

	@RequestMapping(value = "/officers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterInterface<Character>>> getAllOfficers() {
		return new ResponseEntity<>(facade.callingGetAllOfficers(), HttpStatus.OK);
	}

	@RequestMapping(value = "/subOfficers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterInterface<Character>>> getAllSubOfficers() {
		return new ResponseEntity<>(facade.callingGetAllSubOfficers(), HttpStatus.OK);
	}

	@RequestMapping(value = "/search/name", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterInterface<Character>>> getCharacter(
			@RequestBody(required = true) String... name) {
		return new ResponseEntity<>(facade.callingGetCharactersByNames(name), HttpStatus.OK);
	}

	@RequestMapping(value = "/officers/search/name", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterInterface<Character>>> getOfficersByName(
			@RequestBody(required = true) String... name) {
		return new ResponseEntity<>(facade.callingGetOfficersByNames(name), HttpStatus.OK);
	}

	@RequestMapping(value = "/subOfficers/search/name", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterInterface<Character>>> getSubOfficersByName(
			@RequestBody(required = true) String... name) {
		return new ResponseEntity<>(facade.callingGetSubOfficersByNames(name), HttpStatus.OK);
	}

	@RequestMapping(value = "/officers/search/type", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterInterface<Character>>> getOfficersByWeaponType(
			@RequestBody(required = true) String... type) {
		return new ResponseEntity<>(facade.callingGetOfficerByWeaponType(type), HttpStatus.OK);
	}
}
