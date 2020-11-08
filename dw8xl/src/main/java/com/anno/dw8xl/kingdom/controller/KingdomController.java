/**
 * 
 */
package com.anno.dw8xl.kingdom.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anno.dw8xl.kingdom.facade.KingdomFacadeInterface;
import com.anno.dw8xl.kingdom.model.KingdomI;

/**
 * @author Haku Wei
 *
 */
@RestController
@RequestMapping(value = "/kingdoms")
public class KingdomController {

	@Autowired
	private KingdomFacadeInterface facade;

	@GetMapping(value = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getPing() {
		return new ResponseEntity<>("PING TEST", HttpStatus.OK);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<KingdomI>> getAllKingdoms() {
		return new ResponseEntity<>(facade.getAllKingdoms(), HttpStatus.OK);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<KingdomI>> getKingdomByName(
			@RequestParam(value = "name", required = false) String... names) {
		return new ResponseEntity<>(facade.getKingdomsBy(names), HttpStatus.OK);
	}

	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<KingdomI>> removeKingdom(@RequestBody(required = true) KingdomI... kingdom) {
		Collection<KingdomI> inValid = facade.removeKingdom(kingdom);
		return (!inValid.isEmpty()) ? new ResponseEntity<>(inValid, HttpStatus.BAD_REQUEST)
				: new ResponseEntity<>(facade.getAllKingdoms(), HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<KingdomI>> createKingdom(@RequestBody(required = true) KingdomI kingdom) {
		facade.addKingdom(kingdom);
		Collection<KingdomI> temp = facade.getAllKingdoms();
		return (temp.contains(kingdom)) ? new ResponseEntity<>(temp, HttpStatus.OK)
				: new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

}
