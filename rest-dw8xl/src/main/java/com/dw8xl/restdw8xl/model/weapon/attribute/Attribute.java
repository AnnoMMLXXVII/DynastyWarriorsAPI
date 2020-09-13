/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon.attribute;

import com.dw8xl.restdw8xl.model.weapon.attribute.level.LevelI;

/**
 * @author Haku Wei
 *
 */
/**
 * @author Haku Wei
 *
 */
public class Attribute implements AttributeI{

	private String attribute, description;
	private LevelI level;
	
	/**
	 * @param attribute
	 */
	public Attribute(String attribute) {
		super();
		this.attribute = attribute;
	}

	/**
	 * @param attribute
	 * @param level
	 */
	public Attribute(String attribute, LevelI level) {
		super();
		this.attribute = attribute;
		this.level = level;
	}

	/**
	 * @param attribute
	 * @param description
	 * @param level
	 */
	public Attribute(String attribute, String description, LevelI level) {
		super();
		this.attribute = attribute;
		this.description = description;
		this.level = level;
	}

	/**
	 * @return the attribute
	 */
	public String getAttribute() {
		return attribute;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param attribute the attribute to set
	 */
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setLevel(LevelI level) {
		this.level = level;
	}

	@Override
	public LevelI getLevel() {
		return level;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attribute == null) ? 0 : attribute.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
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
		Attribute other = (Attribute) obj;
		if (attribute == null) {
			if (other.attribute != null)
				return false;
		} else if (!attribute.equals(other.attribute))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Attribute [attribute=" + attribute + ", description=" + description + ", level=" + level + "]";
	}
	
	


	
	
}
