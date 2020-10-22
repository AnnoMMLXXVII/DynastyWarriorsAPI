/**
 * 
 */
package com.anno.dw8xl.category.dao;

import java.util.List;

import com.anno.dw8xl.category.model.CategoryI;

/**
 * @author Haku Wei
 *
 */
public interface CategoryDAO_I {

	public List<CategoryI> getAllCategory();
	public CategoryI getCategoryByName(String name);
	public boolean isExist(CategoryI category);
	public void createCategory(CategoryI category);
	
	public void removeCategory(CategoryI category);
	public void removeCategory(String name);
	
	public void updateCategory(CategoryI old, CategoryI category);
	public void updateCategory(CategoryI old, String name);
	public void updateCategory(String existing, String name);
	public void updateCategory(String existing, CategoryI category);
	
}
