package com.anno.dw8xl.attribute.model;

import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author Haku Wei
 *
 */
public abstract class Attribute implements AttributeI {
	
	@JsonView({CharacterView.Attribute.class, CharacterView.Weapon.Attribute.class})
	private String name;
	@JsonView({CharacterView.Attribute.class})
	private String description;
	
	protected Attribute() {
		/*
		 * Empty On purpose
		 * Must Be empty
		 * Commenting to resolve sonar
		 */
	}
	
	/**
	 * @param name
	 * @param description
	 */
	protected Attribute(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		Attribute other = (Attribute) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
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
		return name + ", " + description + ", "+ getRarity();
	}

}
