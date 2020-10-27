/**
 * 
 */
package com.anno.dw8xl.weapon.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anno.dw8xl.weapon.facade.WeaponFacadeInterface;
import com.anno.dw8xl.weapon.model.WeaponI;

/**
 * @author venividivicihofneondeion010101
 *
 */
@RestController
@RequestMapping("/weapons")
public class WeaponController {

	@Autowired
	private WeaponFacadeInterface facade;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<WeaponI>> getAllWeapons() {
		return new ResponseEntity<>(facade.getAllWeapons(), HttpStatus.OK);
	}
	

}
