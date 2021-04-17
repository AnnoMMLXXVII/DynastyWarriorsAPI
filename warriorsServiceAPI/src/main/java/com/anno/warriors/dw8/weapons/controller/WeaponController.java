package com.anno.warriors.dw8.weapons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anno.warriors.dw8.weapons.facade.WeaponFacadeInterface;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;

@RestController
@RequestMapping(value = "dw8/weapons")
public class WeaponController {

	@Autowired
	private WeaponFacadeInterface facade;

	@RequestMapping(value = "/health-check", method = RequestMethod.GET)
	public ResponseEntity<String> getHealthStatus() {
		return new ResponseEntity<>("Status UP!", HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WeaponInterface<Weapon>>> getAllWeapons() {
		return new ResponseEntity<>(facade.callingGetAllWeapons(), HttpStatus.OK);
	}

	@RequestMapping(value = "/names/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> getAllWeaponNames() {
		return new ResponseEntity<>(facade.callingGetAllWeaponNames(), HttpStatus.OK);
	}

	@RequestMapping(value = "filter/names", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WeaponInterface<Weapon>>> getWeaponByName(@RequestParam(required = true, value = "value") String...value) {
		return new ResponseEntity<>(facade.callingGetWeaponsByNames(value), HttpStatus.OK);
	}
	
	@RequestMapping(value = "filter/stars", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WeaponInterface<Weapon>>> getWeaponsByStarRank(@RequestParam(required = true, value = "value") int...value) {
		return new ResponseEntity<>(facade.callingGetWeaponsByStarRank(value), HttpStatus.OK);
	}
}
