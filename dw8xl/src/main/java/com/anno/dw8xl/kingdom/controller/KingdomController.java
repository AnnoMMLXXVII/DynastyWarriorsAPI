/**
 * 
 */
package com.anno.dw8xl.kingdom.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

import com.anno.dw8xl.kingdom.facade.KingdomFacade_I;
import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.kingdom.model.NullKingdom;

/**
 * @author Haku Wei
 *
 */
@RestController
@RequestMapping(value = "/kingdoms")
public class KingdomController {

	@Autowired
	private KingdomFacade_I facade;
	
	@GetMapping(value = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String>getPing() {
		return new ResponseEntity<>("PING TEST", HttpStatus.OK);
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<KingdomI>>getAllKingdoms() {
		return new ResponseEntity<>(facade.getAllKingdoms(), HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<KingdomI> getKingdomByName(
			@RequestParam(value = "name", required = false) String name) {
		KingdomI temp = facade.getKingdomsByName(name);
		return (temp == null) ? new ResponseEntity<>(temp, HttpStatus.BAD_REQUEST)
				: new ResponseEntity<>(temp , HttpStatus.OK);
	}
	
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> removeKingdom(
			@RequestBody(required = true) KingdomI kingdom) {
		facade.removeKingdom(kingdom);
		Collection<KingdomI> res = facade.getAllKingdoms().stream().filter(e -> e.getKingdom().equalsIgnoreCase(kingdom.getKingdom())).collect(Collectors.toList());
		return (!res.isEmpty()) ? new ResponseEntity<>("Could Not Delete!", HttpStatus.BAD_REQUEST)
				: new ResponseEntity<>(kingdom.toString(), HttpStatus.OK);
	}
	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KingdomI> createKingdom(
			@RequestBody(required = true) KingdomI kingdom
			) {
		facade.addKingdom(kingdom);
		KingdomI temp = facade.getKingdomsByName(kingdom.getKingdom());
		return (temp == null) ? new ResponseEntity<>(temp, HttpStatus.BAD_REQUEST)
				: new ResponseEntity<>(temp , HttpStatus.OK);
	}
	
	
}