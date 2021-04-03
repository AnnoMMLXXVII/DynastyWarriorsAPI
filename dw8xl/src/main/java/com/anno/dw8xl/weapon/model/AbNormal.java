/**
 * 
 */
package com.anno.dw8xl.weapon.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.affinity.model.AffinityI;
import com.anno.dw8xl.length.model.Length;
import com.anno.dw8xl.length.model.LengthI;
import com.anno.dw8xl.rarity.model.RarityI;
import com.anno.dw8xl.type.model.TypeI;
import com.anno.dw8xl.weapon.dao.Attributes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Component
@JsonTypeName("AbNormal")
@JsonDeserialize(as = AbNormal.class)
public class AbNormal extends Weapon {

	@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "state")
	private String state = "abnormal";

	private AffinityI affinity;
	private RarityI rarity;
	private LengthI length;
	private Attributes attributes;

	public AbNormal() {
		/*
		 * 
		 */
	}

	/**
	 * @param name
	 * @param baseAttack
	 * @param star
	 * @param type
	 */
	public AbNormal(String name, Integer baseAttack, AffinityI affinity, Integer star, TypeI type, RarityI rarity) {
		super(name, baseAttack, star, type);
		this.affinity = affinity;
		this.rarity = rarity;
		length = new Length("---");
	}

	public AffinityI getAffinity() {
		return affinity;
	}

	@Override
	public RarityI getRarity() {
		return rarity;
	}

	public LengthI getLength() {
		return length;
	}

	public void setLength(LengthI length) {
		this.length = length;
	}

	@Override
	public Attributes getAttributes() {
		return attributes;
	}

	@Override
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	/**
	 * @param affinity the affinity to set
	 */
	public void setAffinity(AffinityI affinity) {
		this.affinity = affinity;
	}

	/**
	 * @param rarity the rarity to set
	 */
	public void setRarity(RarityI rarity) {
		this.rarity = rarity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((affinity == null) ? 0 : affinity.hashCode());
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((rarity == null) ? 0 : rarity.hashCode());
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
		AbNormal other = (AbNormal) obj;
		if (affinity == null) {
			if (other.affinity != null)
				return false;
		} else if (!affinity.equals(other.affinity))
			return false;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (rarity == null) {
			if (other.rarity != null)
				return false;
		} else if (!rarity.equals(other.rarity))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s, %5s, %8s, %s, %s", super.toString(), 
				affinity.toString(), 
				length.toString(),
				getRarity().toString(), 
				(attributes.getAttribute().isEmpty()) ? attributes.getAttribute().toString() : "-");
	}

}
