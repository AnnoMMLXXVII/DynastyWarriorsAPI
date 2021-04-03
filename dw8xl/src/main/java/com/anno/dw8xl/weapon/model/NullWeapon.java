/**
 * 
 */
package com.anno.dw8xl.weapon.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.affinity.model.Affinity;
import com.anno.dw8xl.affinity.model.AffinityI;
import com.anno.dw8xl.attribute.model.AttributeI;
import com.anno.dw8xl.length.model.LengthI;
import com.anno.dw8xl.rarity.model.NullRarity;
import com.anno.dw8xl.rarity.model.RarityI;
import com.anno.dw8xl.weapon.dao.Attributes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Haku Wei
 *
 */
@Component
@JsonDeserialize(as = NullWeapon.class)
public class NullWeapon extends Weapon {
	@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "state")
	private String state = "null";
	
	@JsonIgnore
	private String name;
	@JsonIgnore
	private RarityI rarity;
	@JsonIgnore
	private AffinityI affinity;
	@JsonIgnore
	private Integer baseAttack;
	@JsonIgnore
	private Integer star;
	@JsonIgnore
	private LengthI length;
	
	/**
	 * 
	 */
	public NullWeapon() {
		/*
		 * 
		 */
	}

	@Override
	public RarityI getRarity() {
		return new NullRarity();
	}

	@Override
	public AffinityI getAffinity() {
		return new Affinity("-");
	}
	
	@Override
	public Attributes getAttributes() {
		return new Attributes(new ArrayList<>());
	}

	@Override
	public void setAttributes(Attributes attributes) {
		/*
		 * 
		 */
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((affinity == null) ? 0 : affinity.hashCode());
		result = prime * result + ((baseAttack == null) ? 0 : baseAttack.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rarity == null) ? 0 : rarity.hashCode());
		result = prime * result + ((star == null) ? 0 : star.hashCode());
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
		NullWeapon other = (NullWeapon) obj;
		if (affinity == null) {
			if (other.affinity != null)
				return false;
		} else if (!affinity.equals(other.affinity))
			return false;
		if (baseAttack == null) {
			if (other.baseAttack != null)
				return false;
		} else if (!baseAttack.equals(other.baseAttack))
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rarity == null) {
			if (other.rarity != null)
				return false;
		} else if (!rarity.equals(other.rarity))
			return false;
		if (star == null) {
			if (other.star != null)
				return false;
		} else if (!star.equals(other.star))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

}
