/**
 * 
 */
package com.dw8xl.restdw8xl.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dw8xl.restdw8xl.model.SampleModel;

/**
 * @author Haku Wei
 *
 */
@RestController
public class KingdomRest {

	/**
	 * @return
	 */
	@GetMapping("/kingdoms")
	public ResponseEntity<List<SampleModel>> getAllKingdoms() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/kingdoms/shu")
	public ResponseEntity<List<SampleModel>> getAllShuOfficers() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/kingdoms/wu")
	public ResponseEntity<List<SampleModel>> getAllWuOfficers() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/kingdoms/wei")
	public ResponseEntity<List<SampleModel>> getAllWeiOfficers() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/kingdoms/jin")
	public ResponseEntity<List<SampleModel>> getAllJinOfficers() {
		return null;
	}
	
	/**
	 * @return
	 */
	@GetMapping("/kingdoms/other")
	public ResponseEntity<List<SampleModel>> getAllOtherOfficers() {
		return null;
	}
}
