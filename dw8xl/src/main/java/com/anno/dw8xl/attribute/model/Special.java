/**
 * 
 */
package com.anno.dw8xl.attribute.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.rarity.model.Rarity;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Haku Wei
 *
 */
@Component
@JsonTypeName("Special")
@JsonDeserialize(as = Special.class)
//@JsonView({ CharacterView.Officer.class, CharacterView.Attribute.class, CharacterView.Weapon.Attribute.class })
public class Special extends Attribute {

	@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "state")
	private String state = "special";

	public Special() {
		/*
		 * 
		 */
	}

	/**
	 * @param name
	 * @param description
	 */
	public Special(String name, String description) {
		super(name, description);
	}

	@Override
	public String getRarity() {
		return new Rarity("special").getType();
	}

	@Override
	public int getLevel() {
		return -1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Special other = (Special) obj;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

}
