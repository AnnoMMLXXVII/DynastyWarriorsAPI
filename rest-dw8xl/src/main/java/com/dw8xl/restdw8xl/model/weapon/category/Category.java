/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon.category;

/**
 * @author Haku Wei
 *
 */
public class Category implements CategoryI {

	private String category;

	/**
	 * @param category
	 */
	public Category(String category) {
		super();
		this.category = category;
	}

	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public CategoryI getIntance() {
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
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
		Category other = (Category) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[category=" + category + "]";
	}
	
}
