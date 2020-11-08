/**
 * 
 */
package com.anno.dw8xl.category.model;

import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Haku Wei
 *
 */
@JsonView({CharacterView.Category.class})
@JsonDeserialize(as = Category.class)
public class Category implements CategoryI {
	@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "state")
	private String state = "category";
	
	@JsonView({CharacterView.Type.class, CharacterView.Weapon.class})
	private String name;

	public Category() {
		/*
		 * Empty for security
		 * Also to Satisfy Sonar Compilation
		 * Empty Constructor
		 */
	}

	/**
	 * @param category
	 */
	public Category(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Category other = (Category) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

}
