package com.anno.dw8xl.character.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@GetMapping(value = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> ping() {
		return new ResponseEntity<>("Character Ping Test!".toUpperCase(), HttpStatus.OK);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<CharacterI>> getAllCharacters() {
		return new ResponseEntity<>(facade.getAllCharacters(), HttpStatus.OK);
	}

	@GetMapping(value = "/officers/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<CharacterI>> getAllOfficers() {
		return new ResponseEntity<>(facade.getAllOfficers(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/officers", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<CharacterI> getOfficerByName(
			@RequestParam(value=" ", required = true) String name) {
		return new ResponseEntity<>(facade.getOfficerByName(name), HttpStatus.OK);
	}

	@GetMapping(value = "/officers/kingdom", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<CharacterI>> getOfficersByKingdom(@RequestParam(value = " ") String kingdom) {
		return new ResponseEntity<>(facade.getOfficerByKingdom(kingdom), HttpStatus.OK);
	}

	@GetMapping(value = "/officers/weapon", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<CharacterI>> getOfficersByWeaponName(
			@RequestParam(value = "name") String name) {
		return new ResponseEntity<>(facade.getOfficerByWeaponCategory(name), HttpStatus.OK);
	}

	@GetMapping(value = "/officers/weapon/type", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<CharacterI>> getOfficersByWeaponType(@RequestParam(value = " ") String type) {
		return new ResponseEntity<>(facade.getOfficerByWeaponType(type), HttpStatus.OK);
	}

	@GetMapping(value = "/officers/weapon/category", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<CharacterI>> getOfficersByWeaponCategory(
			@RequestParam(value = " ") String category) {
		return new ResponseEntity<>(facade.getOfficerByWeaponCategory(category), HttpStatus.OK);
	}

	@GetMapping(value = "/sub-officers/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<CharacterI>> getAllSubOfficers() {
		return new ResponseEntity<>(facade.getAllSubOfficers(), HttpStatus.OK);
	}
	@GetMapping(value = "/sub-officers", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<CharacterI>> getSubOfficersByWeaponType(
			@RequestParam(value = " ") String name) {
		return new ResponseEntity<>(facade.getSubOfficerByName(name), HttpStatus.OK);
	}
	
	@GetMapping(value = "/sub-officers/kingdom", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<CharacterI>> getSubOfficersByKingdom(@RequestParam(name = " ") String name) {
		return new ResponseEntity<>(facade.getSubOfficerByKingdom(name.trim()), HttpStatus.BAD_REQUEST);
	}


}
