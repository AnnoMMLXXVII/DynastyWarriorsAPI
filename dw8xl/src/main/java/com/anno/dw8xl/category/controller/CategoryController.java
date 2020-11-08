/**
 * 
 */
package com.anno.dw8xl.category.controller;

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

import com.anno.dw8xl.category.facade.CategoryFacadeInterface;
import com.anno.dw8xl.category.model.CategoryI;

/**
 * @author venividivicihofneondeion010101
 *
 */
@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategoryFacadeInterface facade;

	@GetMapping(value = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> ping() {
		return new ResponseEntity<>("Category PING TEST!".toUpperCase(), HttpStatus.OK);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<CategoryI>> getCategories() {
		return new ResponseEntity<>(facade.getAllCategories(), HttpStatus.OK);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<CategoryI>> getByCategoryName(
			@RequestParam(value = "name", required = true, defaultValue = "") String... name) {
		if (name.length == 0) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
		}
		Collection<CategoryI> inValid = facade.getCategoryBy(name);
		return (!inValid.isEmpty()) ? new ResponseEntity<>(inValid, HttpStatus.BAD_REQUEST)
				: new ResponseEntity<>(facade.getAllCategories(), HttpStatus.OK);
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryI> addCategory(@RequestBody(required = true) CategoryI category) {
		CategoryI temp = facade.addCategory(category);
		return (temp.getName().equalsIgnoreCase("-")) ? new ResponseEntity<>(temp, HttpStatus.BAD_REQUEST)
				: new ResponseEntity<>(temp, HttpStatus.OK);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<CategoryI>> removeCategory(@RequestBody(required = true) CategoryI... category) {
		Collection<CategoryI> inValid = facade.removeCategory(category);
		return (inValid.isEmpty()) ? new ResponseEntity<>(facade.getAllCategories(), HttpStatus.OK)
				: new ResponseEntity<>(inValid, HttpStatus.BAD_REQUEST);
	}

}
