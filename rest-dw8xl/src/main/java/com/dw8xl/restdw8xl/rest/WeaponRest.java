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
public class WeaponRest {

	/**
	 * @return
	 */
	@GetMapping("/weapons")
	public ResponseEntity<List<SampleModel>> getAllWeapons() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/weapons/6-stars")
	public ResponseEntity<List<SampleModel>> getAllSixStarWeapons() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/weapons/5-stars")
	public ResponseEntity<List<SampleModel>> getAllFiveStarWeapons() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/weapons/4-stars")
	public ResponseEntity<List<SampleModel>> getAllFourStarWeapons() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/weapons/3-stars")
	public ResponseEntity<List<SampleModel>> getAllThreeStarWeapons() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/weapons/2-stars")
	public ResponseEntity<List<SampleModel>> getAllTwoStarWeapons() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/weapons/1-stars")
	public ResponseEntity<List<SampleModel>> getAllOneStarWeapons() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/weapons/weapon-type")
	public ResponseEntity<List<SampleModel>> getAllWeaponTypes() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/weapons/weapon-type/wind-master") 
	public ResponseEntity<List<SampleModel>> getAllWindMaster() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/weapons/weapon-type/diver") 
	public ResponseEntity<List<SampleModel>> getAllDiver() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/weapons/weapon-type/dasher") 
	public ResponseEntity<List<SampleModel>> getAllDasher() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/weapons/weapon-type/shadow-sprinter") 
	public ResponseEntity<List<SampleModel>> getAllShadowSprinter() {
		return null;
	}
	
	/**
	 * @param weapon_name
	 * @return
	 */
	@GetMapping("/weapons/{weapon_name}") 
	public ResponseEntity<List<SampleModel>> getAllWindMaster(@PathVariable String weapon_name) {
		return null;
	}
}
