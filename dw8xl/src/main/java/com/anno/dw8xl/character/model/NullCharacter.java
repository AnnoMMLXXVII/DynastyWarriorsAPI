/**
 * 
 */
package com.anno.dw8xl.character.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.kingdom.model.NullKingdom;
import com.anno.dw8xl.type.model.NullType;
import com.anno.dw8xl.type.model.TypeI;
import com.anno.dw8xl.weapon.model.NullWeapon;
import com.anno.dw8xl.weapon.model.WeaponI;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Haku Wei
 *
 */
@Component
@JsonDeserialize(as = NullCharacter.class)
public class NullCharacter extends Character {
	@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "state")
	private String state = "null";

	/**
	 * 
	 */
	public NullCharacter() {
		/*
		 * 
		 */
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public KingdomI getKingdom() {
		return new NullKingdom();
	}

	@Override
	public WeaponI getWeapon() {
		return new NullWeapon();
	}

	public TypeI getType() {
		return new NullType();
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
		NullCharacter other = (NullCharacter) obj;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
}
