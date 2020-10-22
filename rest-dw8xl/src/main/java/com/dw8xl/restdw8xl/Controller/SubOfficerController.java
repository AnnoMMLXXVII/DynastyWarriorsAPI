package com.dw8xl.restdw8xl.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dw8xl.restdw8xl.dao.SubOfficerDaoI;
import com.dw8xl.restdw8xl.model.character.CharacterI;
import com.dw8xl.restdw8xl.model.character.SubOfficer;

@RestController("/")
public class SubOfficerController {

	@Autowired
	private SubOfficerDaoI dao;
	
	private List<CharacterI> subs;
	
	@GetMapping(value = "sub-officers/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CharacterI>> getAllSubOfficers() {
		subs = dao.getAllSubOfficers();
		subs.stream().forEach(s -> System.out.println(s.toString()));
		return new ResponseEntity<List<CharacterI>>(subs, HttpStatus.OK);
	}
	
	@GetMapping(value = "sub-officers", produces = MediaType.APPLICATION_JSON_VALUE)
	public SubOfficer getSubOfficerByName(@RequestParam String name) {
		return new SubOfficer();
	}

}
