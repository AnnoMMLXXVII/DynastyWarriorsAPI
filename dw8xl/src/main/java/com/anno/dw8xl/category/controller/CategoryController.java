/**
 * 
 */
package com.anno.dw8xl.category.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anno.dw8xl.category.facade.CategoryFacadeInterface;
import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.category.model.NullCategory;

/**
 * @author venividivicihofneondeion010101
 *
 */
@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired 
	private CategoryFacadeInterface facade;
	
	@GetMapping(value = "/ping", produces = MediaType.APPLICATION_JSON) 
	public ResponseEntity<String> ping() {
		return new ResponseEntity<>("Category PING TEST!".toUpperCase(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON) 
	public ResponseEntity<Collection<CategoryI>> getCategories() {
		return new ResponseEntity<>(facade.getAllCategories(), HttpStatus.OK);
	}
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON) 
	public ResponseEntity<CategoryI> getByCriteria(
			@RequestParam(value = "name", required=false, defaultValue = "") String name,
			@RequestBody(required = false) CategoryI category
			) {
		if(category == null && name.equals("")) {
			return new ResponseEntity<>(new NullCategory(), HttpStatus.BAD_REQUEST);
		}
		CategoryI res = (name.equals("")) ? facade.getCategoryBy(category) : facade.getCategoryBy(name);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON) 
	public ResponseEntity<CategoryI> addCategory(
			@RequestBody(required = true) CategoryI category) {
		facade.addCategory(category);
		return new ResponseEntity<>(facade.getCategoryBy(category.getName()), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Collection<CategoryI>> removeCategory(
			@RequestBody(required = true) CategoryI category) {
		Collection<CategoryI> list = facade.getAllCategories();
		int size = list.size();
		facade.removeCategory(category);
		
		return (size < list.size()) ? new ResponseEntity<>(list, HttpStatus.OK)
				: new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
			}

}
