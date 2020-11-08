package com.anno.dw8xl.rarity.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Component
@JsonTypeName("Rarity")
@JsonView(CharacterView.Rarity.class)
@JsonDeserialize(as = Rarity.class)
public class Rarity implements RarityI {
	
	@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "state")
	private String state = "rarity";
	
	@JsonView({CharacterView.Weapon.Affinity.Rarity.class, CharacterView.Weapon.Rarity.class})
	private String type;
	
	/**
	 * 
	 */
	public Rarity() {
		/*
		 * 
		 */
	}

	/**
	 * @param type
	 */
	public Rarity(String type) {
		super();
		this.type = type;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Rarity other = (Rarity) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  type;
	}
	
	
}
