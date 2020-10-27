/**
 * 
 */
package com.anno.dw8xl.character.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.type.model.TypeI;
import com.anno.dw8xl.view.CharacterView;
import com.anno.dw8xl.weapon.model.WeaponI;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author Haku Wei
 *
 */
@Component
@JsonView(CharacterView.Officer.class)
public class Officer extends Character {
	
	private TypeI type;
	private WeaponI weapon;
	
	public Officer() {
		/*
		 * Empty On purpose
		 * Must Be empty
		 * Commenting to resolve sonar
		 */
	}
	
	/**
	 * @param name
	 * @param kingdom
	 * @param type
	 */
	public Officer(String name, KingdomI kingdom, TypeI type) {
		super(name, kingdom);
		this.type = type;
	}

	public TypeI getType() {
		return type;
	}
	
	public WeaponI getWeapon() {
		return weapon;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((weapon == null) ? 0 : weapon.hashCode());
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
		Officer other = (Officer) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (weapon == null) {
			if (other.weapon != null)
				return false;
		} else if (!weapon.equals(other.weapon))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + type.toString();
	}
	
	
}
