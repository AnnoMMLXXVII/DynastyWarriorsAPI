package com.anno.dw8xl.category.facade;

import java.util.Collection;

import com.anno.dw8xl.category.model.CategoryI;

public interface CategoryFacade_I {

	public Collection<CategoryI> getAllCategories();
	public <E> CategoryI getCategoryBy(E name);
	
	public void addCategory(CategoryI category);
	public void removeCategory(CategoryI category);
}
