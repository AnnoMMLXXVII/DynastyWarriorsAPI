/**
 * 
 */
package com.anno.dw8xl.weapon.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@PostMapping(value = "/test/single", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<WeaponI> singlePost(
			@RequestBody(required = true) String weapon) {
		return new ResponseEntity<>(facade.parseWeaponObject(weapon), HttpStatus.OK);
	}
	
	@PostMapping(value = "/test/multi", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<WeaponI>> multiPost(
			@RequestBody(required = true) List<WeaponI> weapons) {
		return new ResponseEntity<>(facade.parseWeaponsList(weapons), HttpStatus.OK);
	}
	
	

}
