/**
 * 
 */
package com.anno.dw8xl.weapon.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.attribute.model.AttributeI;
import com.anno.dw8xl.attribute.model.Special;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Component
public class Attributes {

	private List<AttributeI> attribute;

	
	public Attributes() {
		/*
		 * 
		 */
	}
	
	/**
	 * @param attribute
	 */
	public Attributes(List<AttributeI> attribute) {
		super();
		this.attribute = attribute;
	}

	/**
	 * @return the attribute
	 */
	public List<AttributeI> getAttribute() {
		return attribute;
	}

	/**
	 * @param attribute the attribute to set
	 */
	public void setAttribute(List<AttributeI> attribute) {
		this.attribute = attribute;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attribute == null) ? 0 : attribute.hashCode());
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
		Attributes other = (Attributes) obj;
		if (attribute == null) {
			if (other.attribute != null)
				return false;
		} else if (!attribute.equals(other.attribute))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		attribute.forEach(e -> {
			String line = (e instanceof Special) ? String.format("[ %s ] ", e.getName())
					: String.format("[ %s : %s ] ", e.getName(), e.getLevel().getPower());
			str.append(line + ",");
		});
		return str.toString();
	}

}
