/**
 * 
 */
package com.anno.dw8xl.attribute.model;

import com.anno.dw8xl.level.model.LevelI;
import com.anno.dw8xl.level.model.NullLevel;
import com.anno.dw8xl.rarity.model.NullRarity;
import com.anno.dw8xl.rarity.model.RarityI;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @author venividivicihofneondeion010101
 *
 */
@JsonTypeName("Null")
public class NullAttribute implements AttributeI {

	@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "state")
	private String state = "null";
	
	public NullAttribute() {
		/*
		 * Empty On purpose
		 * Must Be empty
		 * Commenting to resolve sonar
		 */
	}

	@Override
	public RarityI getRarity() {
		return new NullRarity();
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public String getDescription() {
		return "";
	}
	
	@Override
	public LevelI getLevel() {
		return new NullLevel();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		NullAttribute other = (NullAttribute) obj;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

}
