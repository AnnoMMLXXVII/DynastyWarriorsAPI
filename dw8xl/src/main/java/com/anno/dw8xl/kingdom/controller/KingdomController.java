/**
 * 
 */
package com.anno.dw8xl.kingdom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anno.dw8xl.kingdom.dao.KingdomDaoI;
import com.anno.dw8xl.kingdom.model.KingdomI;

/**
 * @author Haku Wei
 *
 */
@RestController
@RequestMapping(value = "(/kingdoms")
public class KingdomController {

	@Autowired
	private KingdomDaoI dao;
	
	@GetMapping(value = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String>getPing() {
		return new ResponseEntity<>("PING TEST", HttpStatus.OK);
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KingdomI>>getAllKingdoms() {
		return new ResponseEntity<>(dao.getAllKingdoms(), HttpStatus.OK);
	}
	
	@GetMapping(value = "kingdoms", produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<KingdomI> getKingdomByName(@RequestParam(required = false) String kingdom) {
		dao.getAllKingdoms();
		KingdomI temp = dao.getKingdomByName(kingdom);
		return (temp == null) ? new ResponseEntity<>(temp, HttpStatus.BAD_REQUEST)
				: new ResponseEntity<>(temp , HttpStatus.OK);
	}
}
