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

import org.springframework.stereotype.Service;

import com.anno.dw8xl.category.model.Category;
import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.category.model.NullCategory;
import com.anno.dw8xl.dao.DAO;

/**
 * @author Haku Wei
 *
 */
@Service("categoryDAO")
public class CategoryDAO implements DAO<CategoryI, Object>{
	
	private Map<Integer, CategoryI> categories;
	private static DAO<CategoryI, Object> instance = null;
	
	public static DAO<CategoryI, Object> getInstance() {
		if(instance == null) {
			synchronized (DAO.class) {
				if(instance == null) {
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
		return new ArrayList<>(categories.values());
	}

	@Override
	public Optional<CategoryI> getBy(Object criteria) {
		CategoryI temp = new NullCategory();
		if (criteria instanceof CategoryI) {
			temp = (CategoryI) criteria;
		}
		else if (criteria instanceof String) {
			temp = new Category(DAO.formatName((String)criteria));
		}
		return categories.containsValue(temp) ? Optional.of(temp) : Optional.ofNullable(new NullCategory());
		
	}

	@Override
	public void add(CategoryI entity) {
		if(categories.containsValue(entity)) {
			return;
		}
		if(entity.getName().length() > 24) {
			throw new IllegalArgumentException("Illegal Category name: empty or length(0-24)");
		}
		if(!entity.getName().equals("")) {
			categories.put(categories.size()+1, entity);
		}
	}

	@Override
	public void remove(CategoryI entity) {
		if(!categories.containsValue(entity)) {
			throw new IllegalArgumentException("Category does not exist!");
		}
		categories.remove(DAO.getKey(categories, entity), entity);
		
	}

	private void initializeValues() {
		String path = "Text-Files/category/category.txt";
		CategoryI category = null;
		File file = new File(URL_ROOT+path);
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
			e.printStackTrace();
		}
	}

}
