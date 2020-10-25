/**
 * 
 */
package com.anno.dw8xl.type.model;

import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.category.model.NullCategory;

/**
 * @author venividivicihofneondeion010101
 *
 */
public class Type implements TypeI {

	
	private String name;
	private CategoryI category;
	
	/**
	 * 
	 */
	public Type() {	}

	public Type(String name) {
		this.name = name;
		this.category = new NullCategory();
	}
	
	/**
	 * @param type
	 * @param category
	 */
	public Type(String name, CategoryI category) {
		super();
		this.name = name;
		this.category = category;
	}
	
	@Override
	public void setCategory(CategoryI category) {
		this.category = category;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public CategoryI getCategory() {
		return category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Type other = (Type) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name + ", " + category.toString();
	}
	
	
	
	

}
