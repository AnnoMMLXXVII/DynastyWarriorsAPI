package com.anno.warriors.dw8.attributes.model;

import com.anno.warriors.dw8.shared.DW8Constants;

public class Attribute implements AttributeInterface {

	private String name;
	private String description;
	private String type;

	public Attribute(String name, String description, String type) {
		this.name = name;
		this.description = description;
		this.type = type;
	}

	@Override
	public String getValue() {
		return name.toUpperCase();
	}

	@Override
	public String getState() {
		return DW8Constants.MetaData.ATTRIBUTE.getValue();
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Attribute [name=" + name + ", description=" + description + ", type=" + type + "]";
	}

}
