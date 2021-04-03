/**
 * 
 */
package com.anno.dw8xl.level.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.rarity.model.Rarity;
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
@JsonTypeName("Level")
@JsonView(CharacterView.Attribute.class)
@JsonDeserialize(as = Rarity.class)
public class Level implements LevelI {
	
	@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "state")
	private String state = "level";
	
	@JsonView({CharacterView.Weapon.Attribute.class})
	private int power;
	
	public Level() {
		/*
		 * 
		 */
	}

	/**
	 * @param power
	 */
	public Level(int power) {
		super();
		this.power = power;
	}

	/**
	 * @return the power
	 */
	public String getPower() {
		return this.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + power;
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
		Level other = (Level) obj;
		if (power != other.power)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%d", power);
	}

}
