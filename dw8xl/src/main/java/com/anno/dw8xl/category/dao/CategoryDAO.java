/**
 * 
 */
package com.anno.dw8xl.category.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anno.dw8xl.category.model.Category;
import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.category.model.NullCategory;
import com.anno.dw8xl.dao.DataAccessObjectInterface;
import com.anno.dw8xl.dao.PATH;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Haku Wei
 *
 */
@Repository
public class CategoryDAO implements CategoryDAOInterface{
	
	private Map<String, CategoryI> categories, temp;
	private static CategoryDAOInterface instance = null;
	private static final Logger log = LoggerFactory.getLogger(CategoryDAO.class);
	
	public static CategoryDAOInterface getInstance() {
		if(instance == null) {
			synchronized (DataAccessObjectInterface.class) {
				if(instance == null) {
					log.info("CategoryDAO singleton instantiation...");
					return new CategoryDAO();
				}
			}
		}
		return instance;
	}
	
	private CategoryDAO() {
		categories = new HashMap<>();
		initializeValues();
	}
	
	@Override
	public Collection<CategoryI> getAll() {
		log.info("Returning Categories collection...");
		return new ArrayList<>(categories.values());
	}

	@Override
	public Optional<CategoryI> getBy(Object criteria) {
		CategoryI temp = categories.get(criteria);
		if(temp == null) {
			log.info("Returning empty value for category...");
			return Optional.empty();
		}
		log.info("Returning nullable value for category...");
		return Optional.ofNullable(temp);
	}
	
	@Override
	public CategoryI executeCreateCategory(String json) {
		ObjectMapper mapper = new ObjectMapper();
		CategoryI category = null;
		try {
			category = mapper.readValue(json, CategoryI.class);
		} catch (JsonProcessingException e) {
			log.debug(String.format("%s", e.getMessage()));
		}
		if(category != null) {
			add(category);
			return category;
		}
		return new NullCategory();
	}

	@Override
	public void add(CategoryI entity) {
		if(!CategoryDAOInterface.isValidToAdd(entity)) {
			return;
		}
		if(categories.containsValue(entity)) {
			log.debug("Cannot add Category to due duplicate...");
			return;
		}
		log.info("Adding Category...");
		categories.put(entity.getName(), entity);
	}
	
	@Override
	public Collection<CategoryI> executeRemoveCategory(String json) {
		CategoryI[] result = deserializeList(json);
		return mapArrayToRemove(result);
	}

	@Override
	public void remove(CategoryI entity) {
		if(!CategoryDAOInterface.isValidToRemove(entity)) {
			return;
		}
		if(!categories.containsValue(entity)) {
			log.debug("Cannot find Category to remove...");
			return;
		}
		log.info("Removing Category...");
		categories.remove(entity.getName(), entity);
	}
	
	@Override
	public Collection<CategoryI> executeUpdateCategories(String json, String...params) {
		CategoryI[] paramCategories = deserializeList(json);
		int i = 0;
		for(CategoryI c : paramCategories) {
			updateCategory(categories.get(params[i]), c);
		}
		if(temp.isEmpty()) {
			return new ArrayList<>();
		}
		return new ArrayList<>(temp.values());
	}
	
	private boolean updateCategory(CategoryI old, CategoryI category) {
		temp = categories;
		temp.replace(old.getName(), category);
		return temp.containsKey(category.getName());
	}

	private CategoryI[] deserializeList(String json) {
		ObjectMapper mapper = new ObjectMapper();
		CategoryI[] categoriesArray = null;
		try {
			log.debug("Deserializing json...");
			categoriesArray = mapper.readValue(json, CategoryI[].class);
		} catch (JsonProcessingException e) {
			log.debug("Could not Parse!");
		}
		return categoriesArray;
	}

	private Collection<CategoryI> mapArrayToRemove(CategoryI[] categoryArr) {
		for (CategoryI a : categoryArr) {
			remove(a);
		}
		return new ArrayList<>(categories.values());
	}

	private void initializeValues() {
		CategoryI category = null;
		File file = new File(PATH.CATEGORY_PATH.getStringUrl());
		try (Scanner z = new Scanner(new FileReader(file))) {
			String[] categoryLine = null;
			while (z.hasNextLine()) {
				String line = z.nextLine();
				categoryLine = line.split(",");
				category = new Category(categoryLine[0].trim());  
				categories.put(category.getName(), category);
			}
		}
		catch(FileNotFoundException e) {
			log.debug(String.format("Error: %s...", e.getMessage()));
		}
	}

}
