package com.anno.warriors.dw8.characters.controller;

import static com.anno.warriors.shared.ApplicationConstants.CROSS_ORIGIN_LOCAL_HOST;
import static com.anno.warriors.shared.ApplicationConstants.LEGENDARY_WARRIORS_NETLIFY;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anno.warriors.dw8.characters.facade.CharacterFacadeInterface;
import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.requests.pojos.CharacterPojo;

@RestController
@CrossOrigin(origins = { CROSS_ORIGIN_LOCAL_HOST, LEGENDARY_WARRIORS_NETLIFY })
@RequestMapping(value = "dw8/characters")
public class CharacterController {

	@Autowired
	private CharacterFacadeInterface facade;

	@GetMapping(value = "/health-check")
	public ResponseEntity<String> getHealthStatus() {
		return new ResponseEntity<>("Status UP!", HttpStatus.OK);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterInterface<Character>>> getAllCharacters() {
		return new ResponseEntity<>(facade.callingGetAllCharacters(), HttpStatus.OK);
	}

	@GetMapping(value = "/officers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterInterface<Character>>> getAllOfficers() {
		return new ResponseEntity<>(facade.callingGetAllOfficers(), HttpStatus.OK);
	}

	@PostMapping(value = "/officers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CharacterInterface<Character>> createOfficer(@RequestBody CharacterPojo character) {
		return new ResponseEntity<>(facade.callingCreateOfficer(character), HttpStatus.OK);
	}

	@GetMapping(value = "/subOfficers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterInterface<Character>>> getAllSubOfficers() {
		return new ResponseEntity<>(facade.callingGetAllSubOfficers(), HttpStatus.OK);
	}

	@PostMapping(value = "/search/name", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterInterface<Character>>> getCharacter(
			@RequestBody(required = true) String... name) {
		return new ResponseEntity<>(facade.callingGetCharactersByNames(name), HttpStatus.OK);
	}

	@PostMapping(value = "/officers/search/name", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterInterface<Character>>> getOfficersByName(
			@RequestBody(required = true) String... name) {
		return new ResponseEntity<>(facade.callingGetOfficersByNames(name), HttpStatus.OK);
	}

	@PostMapping(value = "/subOfficers/search/name", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterInterface<Character>>> getSubOfficersByName(
			@RequestBody(required = true) String... name) {
		return new ResponseEntity<>(facade.callingGetSubOfficersByNames(name), HttpStatus.OK);
	}

	@PostMapping(value = "/officers/search/type", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterInterface<Character>>> getOfficersByWeaponType(
			@RequestBody(required = true) String... type) {
		return new ResponseEntity<>(facade.callingGetOfficerByWeaponType(type), HttpStatus.OK);
	}

	@PostMapping(value = "/officers/search/kingdom", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterInterface<Character>>> getAllOfficersByKingdom(
			@RequestBody(required = true) String... kingdom) {
		return new ResponseEntity<>(facade.callingGetAllOfficerByKingdom(kingdom), HttpStatus.OK);
	}

	/*
	 * Below will require the enhanced Filter/Search (DYN-130)
	 * 
	 */

	@PostMapping(value = "/officers/search/weapon/name", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterInterface<Character>>> getAllOfficersByWeaponName(
			@RequestBody(required = true) String... officers) {
		return new ResponseEntity<>(facade.callingGetAllOfficerByWeaponName(officers), HttpStatus.OK);
//		return null;
	}

	@PostMapping(value = "/officers/search/weapon/power", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterInterface<Character>>> getAllOfficersByWeaponPower(
			@RequestBody(required = true) int... weaponPower) {
		return new ResponseEntity<>(facade.callingGetAllOfficerByWeaponPower(weaponPower), HttpStatus.OK);
	}

}
