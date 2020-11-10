/**
 * 
 */
package com.anno.dw8xl.category.facade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.dw8xl.category.dao.CategoryDAOInterface;
import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.category.model.NullCategory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Service("categoryFacade")
public class CategoryFacade implements CategoryFacadeInterface {

	@Autowired
	private CategoryDAOInterface dao;
	private static final Logger log = LoggerFactory.getLogger(CategoryFacade.class);
	private Collection<CategoryI> inValid;

	@Override
	public Collection<CategoryI> getAllCategories() {
		return dao.getAll();
	}

	@Override
	public Collection<CategoryI> getCategoryBy(String... params) {
		List<String> names = removeDuplicates(params);
		Collection<CategoryI> categories = new ArrayList<>(params.length);
		for (String s : names) {
			Optional<CategoryI> temp = dao.getBy(s);
			if (temp.isPresent()) {
				categories.add(temp.get());
			}
		}
		return categories;
	}

	@Override
	public CategoryI addCategory(CategoryI category) {
		if (category == null) {
			throw new NullPointerException("Cannot create Category of Null Value");
		}
		if (dao.getBy(category.getName()).isPresent()) {
			return new NullCategory();
		}
		String json = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(category);
		} catch (JsonProcessingException e) {
			logException(e);
		}
		return dao.executeCreateCategory(json);

	}

	@Override
	public Collection<CategoryI> removeCategory(CategoryI... categories) {
		Collection<CategoryI> isNotRemovable = isValidToRemove(categories);
		List<CategoryI> temp = removeDuplicates(categories);
		if (!isNotRemovable.isEmpty()) {
			return isNotRemovable;
		}
		String json = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(temp);
		} catch (JsonProcessingException e) {
			logException(e);
		}
		return dao.executeRemoveCategory(json);
	}

	@Override
	public Collection<CategoryI> updateCategories(List<CategoryI> categories, String... params) {
		if ((categories.isEmpty() || categories.size() != params.length) || params.length == 0) {
			log.debug("Request Body List is Empty...");
			return new ArrayList<>();
		}
		categories = isValidToUpdate(categories);
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(categories);
		} catch (JsonProcessingException e) {
			logException(e);
		}
		return dao.executeUpdateCategories(json, params);
	}

	/*
	 * Check to see if RequestBody exists in the database
	 */
	private Collection<CategoryI> isValidToRemove(CategoryI... categories) {
		Collection<CategoryI> inValidToRemove = new ArrayList<>();
		for (CategoryI c : categories) {
			Optional<CategoryI> temp = dao.getBy(c.getName());
			if (!temp.isPresent()) {
				inValid.add(c);
			}
		}
		return inValidToRemove;
	}

	/*
	 * Validating the list of categories' names are not empty
	 */
	private List<CategoryI> isValidToUpdate(List<CategoryI> categories) {
		List<CategoryI> valid = new ArrayList<>();
		inValid = new ArrayList<>();
		for (CategoryI c : categories) {
			if (c.getName().equalsIgnoreCase("")) {
				inValid.add(c);
				log.debug("Missing Category Name...");
			} else {
				valid.add(c);
				log.debug("Valid Category...");
			}
		}
		setInValid(inValid);
		return valid;
	}

	/**
	 * @return the inValid
	 */
	public Collection<CategoryI> getInValid() {
		return inValid;
	}

	/**
	 * @param inValid the inValid to set
	 */
	private void setInValid(Collection<CategoryI> inValid) {
		this.inValid = inValid;
	}

	private List<String> removeDuplicates(String... names) {
		log.debug("Removing all possible duplicates from the Request Parameter");
		return Arrays.asList(names).stream().distinct().collect(Collectors.toList());
	}

	private List<CategoryI> removeDuplicates(CategoryI... categories) {
		log.debug("Removing all possible duplicates from the Request Parameter");
		return Arrays.asList(categories).stream().distinct().collect(Collectors.toList());
	}

	private void logException(Exception e) {
		log.debug(String.format("%s", e.getMessage()));
	}

}
