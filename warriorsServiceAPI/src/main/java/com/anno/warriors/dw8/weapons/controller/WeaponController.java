package com.anno.warriors.dw8.weapons.controller;

import static com.anno.warriors.shared.ApplicationConstants.CROSS_ORIGIN_LOCAL_HOST;
import static com.anno.warriors.shared.ApplicationConstants.LEGENDARY_WARRIORS_NETLIFY;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anno.warriors.dw8.weapons.facade.WeaponFacadeInterface;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;

@RestController
@CrossOrigin(origins = { CROSS_ORIGIN_LOCAL_HOST, LEGENDARY_WARRIORS_NETLIFY })
@RequestMapping(value = "dw8/weapons")
public class WeaponController {

	private Logger logger = LogManager.getLogger();

	@Autowired
	private WeaponFacadeInterface facade;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WeaponInterface<Weapon>>> getAllWeapons() {
		logger.info("Requesting All Weapons");
		return new ResponseEntity<>(facade.callingGetAllWeapons(), HttpStatus.OK);
	}

	@RequestMapping(value = "/names/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> getAllWeaponNames() {
		logger.info("Requesting All Weapons Names");
		return new ResponseEntity<>(facade.callingGetAllWeaponNames(), HttpStatus.OK);
	}

	@RequestMapping(value = "search/names", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WeaponInterface<Weapon>>> getWeaponByName(
			@RequestParam(required = true, value = "value") String... value) {
		logger.info("Requesting Weapons by name(s)");
		return new ResponseEntity<>(facade.callingGetWeaponsByNames(value), HttpStatus.OK);
	}

	@RequestMapping(value = "search/stars", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WeaponInterface<Weapon>>> getWeaponsByStarRank(
			@RequestParam(required = true, value = "stars") int... value) {
		logger.info("Requesting Weapons by star(s)");
		return new ResponseEntity<>(facade.callingGetWeaponsByStarRank(value), HttpStatus.OK);
	}

	@RequestMapping(value = "search/power", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WeaponInterface<Weapon>>> getWeaponsByStarRank(
			@RequestParam(required = true, value = "low") int low,
			@RequestParam(required = false, value = "high") int high) {
		logger.info("Requesting Weapons between star range");
		return new ResponseEntity<>(facade.callingGetWeaponsByAttackPower(low, high), HttpStatus.OK);
	}

	@RequestMapping(value = "search/type", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WeaponInterface<Weapon>>> getWeaponsByWeaponType(
			@RequestParam(required = true, value = "type") String value) {
		logger.info("Requesting Weapons by weapon type(s)");
		return new ResponseEntity<>(facade.calingGetWeaponsByTypes(value), HttpStatus.OK);
	}

	@RequestMapping(value = "search/rarity", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WeaponInterface<Weapon>>> getWeaponsByRarity(
			@RequestParam(required = true, value = "rarity") String rarity) {
		logger.info("Requesting Weapons by raritie(s)");
		return new ResponseEntity<>(facade.calingGetWeaponsByRarity(rarity), HttpStatus.OK);
	}

	@RequestMapping(value = "search/attributes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WeaponInterface<Weapon>>> getWeaponsByAttributes(
			@RequestBody(required = true) String... values) {
		logger.info("Requesting Weapons by attribute(s)");
		return new ResponseEntity<>(facade.calingGetWeaponsWithAttributeN(values), HttpStatus.OK);
	}

	@RequestMapping(value = "search/attributes&level", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WeaponInterface<Weapon>>> getWeaponsByAttributesWithLevel(
			@RequestParam(required = true, value = "level") @RequestBody(required = true) int level, String... values) {
		logger.info("Requesting Weapons by attribute(s) and level");
		return new ResponseEntity<>(facade.calingGetWeaponsWithAttributeNAndLevelX(level, values), HttpStatus.OK);
	}
}
