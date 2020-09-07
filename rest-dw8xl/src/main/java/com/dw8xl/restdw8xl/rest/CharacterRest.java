/**
 * 
 */
package com.dw8xl.restdw8xl.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dw8xl.restdw8xl.model.SampleModel;

/**
 * @author Haku Wei
 *
 */
public class CharacterRest {

	/**
	 * @return
	 */
	@GetMapping("/characters")
	public ResponseEntity<List<SampleModel>> getAllCharacters() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/characters/officers")
	public ResponseEntity<List<SampleModel>> getAllOfficers() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/characters/officers/{officer-name}")
	public ResponseEntity<List<SampleModel>> getOfficerByName(@PathVariable String officerName) {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/characters/sub-officers")
	public ResponseEntity<List<SampleModel>> getAllSubOfficers() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/characters/sub-officers/{sub-Officer-name}")
	public ResponseEntity<List<SampleModel>> getAllSubOfficersByName() {
		return null;
	}
}
