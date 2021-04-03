/**
 * 
 */
package com.anno.dw8xl.category.dao;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.category.model.NullCategory;
import com.anno.dw8xl.dao.DataAccessObjectInterface;

/**
 * @author Haku Wei
 *
 */
public interface CategoryDAOInterface extends DataAccessObjectInterface<CategoryI, Object> {

	static final Logger log = LoggerFactory.getLogger(CategoryDAO.class);
	
	public CategoryI executeCreateCategory(String json);
	
	public Collection<CategoryI> executeRemoveCategory(String json);
	
	public Collection<CategoryI> executeUpdateCategories(String json, String...params);

	static boolean isValidToAdd(CategoryI entity) {
		if (entity == null) {
			log.debug("Cannot add Category due to Null Exception...");
			throw new NullPointerException("Category cannot be added due to Null!");
		}
		if (entity.getName().length() > 24) {
			log.debug("Cannot add Category due to Character Length [0-24]...");
			throw new IllegalArgumentException("Illegal Category name: empty or length(0-24)");
		}
		if (entity instanceof NullCategory || entity.getName().equals("")) {
			log.info("Cannot add Category due to Null Or Empty Rarity...");
			return false;
		}
		return true;
	}

	static boolean isValidToRemove(CategoryI entity) {
		if (entity == null) {
			log.debug("Cannot remove Category due to Null Exception...");
			throw new NullPointerException("Category cannot be removed due to Null!");
		}
		if (entity instanceof NullCategory || entity.getName().equals("")) {
			log.debug("Cannot remove Rarity due to Null Or Empty Rarity...");
			return false;
		}
		return true;
	}

}
