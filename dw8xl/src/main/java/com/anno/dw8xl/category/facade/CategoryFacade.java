/**
 * 
 */
package com.anno.dw8xl.category.facade;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.category.model.NullCategory;
import com.anno.dw8xl.dao.DAO;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Service("categoryFacade")
public class CategoryFacade implements CategoryFacade_I {

	
	@Autowired
	private DAO<CategoryI, Object> dao;

	@Override
	public Collection<CategoryI> getAllCategories() {
		return dao.getAll();
	}

	@Override
	public <E> CategoryI getCategoryBy(E criteria) {
		Optional<CategoryI> result = dao.getBy(criteria);
		return result.isPresent() ? result.get() : result.orElse(new NullCategory());
	}

	@Override
	public void addCategory(CategoryI category) {
		if(category == null) {
		throw new NullPointerException("Cannot create Category of Null Value");
	}
		dao.add(category);

	}

	@Override
	public void removeCategory(CategoryI category) {
		dao.remove(category);

	}

}
