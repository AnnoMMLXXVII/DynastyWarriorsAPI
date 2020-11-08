package com.anno.dw8xl.category.facade;

import java.util.Collection;

import com.anno.dw8xl.category.model.CategoryI;

public interface CategoryFacadeInterface {

	public Collection<CategoryI> getAllCategories();

	public Collection<CategoryI> getCategoryBy(String...name);

	public CategoryI addCategory(CategoryI category);

	public Collection<CategoryI> removeCategory(CategoryI...category);
	
}
