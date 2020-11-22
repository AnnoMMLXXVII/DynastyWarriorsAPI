/**
 * 
 */
package com.anno.dw8xl.character.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.type.model.TypeI;
import com.anno.dw8xl.view.CharacterView;
import com.anno.dw8xl.weapon.model.WeaponI;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Haku Wei
 *
 */
@Component
@JsonView(CharacterView.Officer.class)
@JsonDeserialize(as = Officer.class)
public class Officer extends Character {

	@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "state")
	private String state = "officer";

	@JsonView(CharacterView.Officer.class)
	private TypeI type;
	@JsonView(CharacterView.Officer.class)
	private Weapons weapons;

	public Officer() {
		/*
		 * Empty On purpose Must Be empty Commenting to resolve sonar
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

	public void setWeapon(Weapons weapons) {
		this.weapons = weapons;
	}

	public List<WeaponI> getWeapons() {
		return weapons.getWeapons();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((weapons == null) ? 0 : weapons.hashCode());
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
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (weapons == null) {
			if (other.weapons != null)
				return false;
		} else if (!weapons.equals(other.weapons))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + type.toString();
	}

}
