package com.anno.warriors.dw8.characters.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anno.warriors.dw8.characters.facade.CharacterFacadeInterface;
import com.anno.warriors.dw8.characters.model.CharacterInterface;

@RestController
@RequestMapping(value = "dw8/")
public class CharacterController {

	@Autowired
	private CharacterFacadeInterface facade;

	@RequestMapping(value = "characters/health-check", method = RequestMethod.GET)
	public ResponseEntity<String> getHealthStatus() {
		return new ResponseEntity<>("Status UP!", HttpStatus.OK);
	}

	@RequestMapping(value = "characters/", method = RequestMethod.GET)
	public ResponseEntity<List<CharacterInterface<com.anno.warriors.dw8.characters.model.Character>>> getAllCharacters() {
		return new ResponseEntity<>(facade.callingGetAllCharacters(), HttpStatus.OK);
	}

	@RequestMapping(value = "characters/officers", method = RequestMethod.GET)
	public ResponseEntity<List<CharacterInterface<com.anno.warriors.dw8.characters.model.Character>>> getAllOfficers() {
		return new ResponseEntity<>(facade.callingGetAllOfficers(), HttpStatus.OK);
	}

	@RequestMapping(value = "characters/subOfficers", method = RequestMethod.GET)
	public ResponseEntity<List<CharacterInterface<com.anno.warriors.dw8.characters.model.Character>>> getAllSubOfficers() {
		return new ResponseEntity<>(facade.callingGetAllSubOfficers(), HttpStatus.OK);
	}
}
