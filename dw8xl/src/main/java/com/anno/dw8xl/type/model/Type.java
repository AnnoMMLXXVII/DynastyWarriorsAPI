/**
 * 
 */
package com.anno.dw8xl.type.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.category.model.NullCategory;
import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Component
@JsonView({CharacterView.Type.class})
public class Type implements TypeI {
	@JsonView({CharacterView.Weapon.Type.class})
	private String name;
	private CategoryI category;

	/**
	 * @param name
	 */
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
	@JsonProperty("category")
	public String getCategory() {
		return category.getName();
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
