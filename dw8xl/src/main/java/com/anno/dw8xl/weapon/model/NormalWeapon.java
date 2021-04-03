/**
 * 
 */
package com.anno.dw8xl.weapon.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.affinity.model.Affinity;
import com.anno.dw8xl.affinity.model.AffinityI;
import com.anno.dw8xl.length.model.LengthI;
import com.anno.dw8xl.rarity.model.Rarity;
import com.anno.dw8xl.rarity.model.RarityI;
import com.anno.dw8xl.type.model.TypeI;
import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Component
@JsonTypeName("NormalWeapon")
@JsonDeserialize(as = NormalWeapon.class)
public class NormalWeapon extends Weapon {

	@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "state")
	private String state = "normal";
	
	@JsonView(CharacterView.Weapon.class)
	private LengthI length;
	@JsonView(CharacterView.Weapon.class)
	private AffinityI affinity;

	public NormalWeapon() {
		/*
		 * 
		 */
	}

	/**
	 * @param name
	 * @param baseAttack
	 * @param length
	 * @param type
	 * @param star
	 */
	public NormalWeapon(String name, Integer baseAttack, LengthI length, Integer star, TypeI type) {
		super(name, baseAttack, star, type);
		this.length = length;
		affinity = new Affinity("?");
	}

	@Override
	public RarityI getRarity() {
		return new Rarity("Normal");
	}

	/**
	 * @return the length
	 */
	public LengthI getLength() {
		return length;
	}
	
	public void setAffinity(AffinityI affinity) {
		this.affinity = affinity;
	}
	
	@Override
	public AffinityI getAffinity() {
		return affinity;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(LengthI length) {
		this.length = length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((length == null) ? 0 : length.hashCode());
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
		NormalWeapon other = (NormalWeapon) obj;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return String.format("%s, %5s, %8s, %s",super.toString(), affinity.toString(), length.toString(), getRarity().toString());
	}

}
