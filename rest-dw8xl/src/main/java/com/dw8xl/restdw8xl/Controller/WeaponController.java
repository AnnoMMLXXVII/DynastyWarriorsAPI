/**
 * 
 */
package com.dw8xl.restdw8xl.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dw8xl.restdw8xl.dao.WeaponDaoI;
import com.dw8xl.restdw8xl.model.weapon.WeaponI;

/**
 * @author Haku Wei
 *
 */
//@RestController("/weapon")
public class WeaponController {

//	@Autowired
	private WeaponDaoI dao;
	
//	@GetMapping(value = "/")
	public ResponseEntity<List<WeaponI>> getAllWeapons() {
		return new ResponseEntity<List<WeaponI>>(dao.getAllWeapons(), HttpStatus.OK);
	}
}
