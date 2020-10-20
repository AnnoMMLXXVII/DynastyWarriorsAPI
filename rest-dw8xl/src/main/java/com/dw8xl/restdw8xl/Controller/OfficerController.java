/**
 * 
 */
package com.dw8xl.restdw8xl.Controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dw8xl.restdw8xl.dao.OfficerDaoI;
import com.dw8xl.restdw8xl.model.character.CharacterI;

/**
 * @author Haku Wei
 *
 */
@RestController("/officer")
public class OfficerController {

	@Autowired
	private OfficerDaoI dao;
	
	@GetMapping("/")
	public ResponseEntity<List<CharacterI>> getAllOfficers() throws FileNotFoundException {
		return new ResponseEntity<List<CharacterI>>(dao.getAllOfficers(), HttpStatus.OK);
	}

}
