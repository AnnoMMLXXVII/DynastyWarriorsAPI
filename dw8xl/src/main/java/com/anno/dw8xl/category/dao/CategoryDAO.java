/**
 * 
 */
package com.anno.dw8xl.category.dao;

import java.util.ArrayList;
import java.util.List;

import com.anno.dw8xl.category.model.Category;
import com.anno.dw8xl.category.model.CategoryI;

/**
 * @author Haku Wei
 *
 */
public class CategoryDAO implements CategoryDAO_I{
	
	private List<CategoryI> categories;
	private static CategoryDAO_I instance = null;
	
	public static CategoryDAO_I getInstance() {
		if(instance == null) {
			synchronized (CategoryDAO_I.class) {
				if(instance == null) {
					return new CategoryDAO();
				}
			}
		}
		return instance;
	}
	
	private CategoryDAO() {
		categories = new ArrayList<>();
		initializeValues();
	}

	@Override
	public List<CategoryI> getAllCategory() {
		return categories;
	}

	@Override
	public CategoryI getCategoryByName(String name) {
		int idx = findIndex(name);
		if(idx < 0) {
			return null;
		}
		return categories.get(idx);
	}

	@Override
	public boolean isExist(CategoryI category) {
		boolean flag = false;
		return (findIndex(category) > -1) ? !flag: flag;
	}

	@Override
	public void createCategory(CategoryI category) {
		if(category == null) {
			throw new NullPointerException("Cannot create Category of Null Value");
		}
		if(!validateCategoryName(category.getName())) {
			return;
		}
		categories.add(category);
	}

	@Override
	public void removeCategory(CategoryI category) {
		categories.removeIf(c -> c.equals(category));
	}

	@Override
	public void removeCategory(String name) {
		categories.removeIf(c -> c.getName().equals(name));
	}

	@Override
	public void updateCategory(CategoryI old, CategoryI category) {
		int idx = findIndex(old);
		if(idx < 0) {
			return;
		}
		removeCategory(old);
		categories.add(idx, category);
	}

	@Override
	public void updateCategory(CategoryI old, String name) {
		int idx = findIndex(old);
		if(idx < 0) {
			return;
		}
		CategoryI temp = new Category(name);
		removeCategory(old);
		categories.add(idx, temp);
	}

	@Override
	public void updateCategory(String existing, String name) {
		int idx = findIndex(existing);
		if(idx < 0) {
			return;
		}
		CategoryI temp = new Category(name);
		removeCategory(existing);
		categories.add(idx, temp);
	}

	@Override
	public void updateCategory(String existing, CategoryI category) {
		int idx = findIndex(existing);
		if(idx < 0) {
			return;
		}
		removeCategory(existing);
		categories.add(idx, category);
	}
	
	private int findIndex(CategoryI category) {
		int idx = 0;
		for(CategoryI c : categories) {
			if(c.equals(category)) {
				return idx;
			}
			idx++;
		}
		return -1;
	}
	
	private int findIndex(String name) {
		int idx = 0;
		for(CategoryI c : categories) {
			if(c.getName().equals(name)) {
				return idx;
			}
			idx++;
		}
		return -1;
	}
	
	private boolean validateCategoryName(String name) {
		boolean flag = false;
		if(name.equals("") || name.length() > 24) {
			throw new IllegalArgumentException("Illegal Category name: empty or length(0-24)");
		}
		return !flag; 
	}
	
	private void initializeValues() {
		categories.add(new Category("Whirlwind Master"));
		categories.add(new Category("Dasher"));
		categories.add(new Category("Diver"));
		categories.add(new Category("Shadow Sprinter"));
	}

}
