/**
 * 
 */
package com.anno.dw8xl.character.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anno.dw8xl.character.dao.CharacterDaoI;
import com.anno.dw8xl.character.model.CharacterI;

/**
 * @author Haku Wei
 *
 */
@RestController
@RequestMapping("/characters")
public class CharacterController {

	@Autowired
	private CharacterDaoI dao;
	
	@GetMapping(value = "/sub-officers/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterI>> getAllSubOfficers() {
		return new ResponseEntity<List<CharacterI>>(dao.queryAllSubOfficers(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/sub-officers/{kingdom}")
	public ResponseEntity<List<CharacterI>> getSubOfficersByKingdom(@PathVariable(value = "kingdom") String kingdom) {
		if(kingdom.equalsIgnoreCase("shu")) {
			return new ResponseEntity<List<CharacterI>>(dao.queryShuSubOfficers(), HttpStatus.OK);
		}
		return new ResponseEntity<List<CharacterI>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}


}
