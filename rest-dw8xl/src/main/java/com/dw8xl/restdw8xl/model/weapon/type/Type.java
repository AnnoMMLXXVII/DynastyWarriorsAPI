/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon.type;

import com.dw8xl.restdw8xl.model.weapon.category.CategoryI;

/**
 * @author Haku Wei
 *
 */
public class Type implements TypeI {

	private String type;
	private CategoryI category;
	
	/**
	 * @param type
	 * @param category
	 */
	public Type(String type, CategoryI category) {
		super();
		this.type = type;
		this.category = category;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the category
	 */
	public CategoryI getCategory() {
		return category;
	}
	/**
	 * @return
	 */
	public Type getInstance() {
		return this;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "[type=" + type + ", category=" + category.toString() + "]";
	}
	
}
