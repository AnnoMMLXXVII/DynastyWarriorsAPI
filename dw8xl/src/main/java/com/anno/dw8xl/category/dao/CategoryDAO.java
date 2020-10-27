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
import org.springframework.stereotype.Service;

import com.anno.dw8xl.category.model.Category;
import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.category.model.NullCategory;
import com.anno.dw8xl.dao.DataAccessObjectInterface;
import com.anno.dw8xl.dao.PATH;

/**
 * @author Haku Wei
 *
 */
@Service("categoryDAO")
public class CategoryDAO implements CategoryDAOInterface{
	
	private Map<Integer, CategoryI> categories;
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
		CategoryI temp;
		if (criteria instanceof CategoryI) {
			temp = (CategoryI) criteria;
			temp = categories.get(DataAccessObjectInterface.getKey(categories, temp));
			return (temp != null) ? Optional.of(temp) : Optional.of(new NullCategory());
		}
		else if ((temp = categories.get(criteria)) != null) {
			return Optional.of(temp);
		}
		return  Optional.of(new NullCategory());
		
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
		categories.put(categories.size()+1, entity);
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
		categories.remove(DataAccessObjectInterface.getKey(categories, entity), entity);
	}

	private void initializeValues() {
		CategoryI category = null;
		File file = new File(PATH.CATEGORY_PATH.getStringUrl());
		try (Scanner z = new Scanner(new FileReader(file))) {
			String[] categoryLine = null;
			int i = 1; 
			while (z.hasNextLine()) {
				String line = z.nextLine();
				categoryLine = line.split(",");
				category = new Category(categoryLine[0].trim());  
				categories.put(i++, category);
			}
		}
		catch(FileNotFoundException e) {
			log.debug(String.format("Error: %s...", e.getMessage()));
		}
	}

}
