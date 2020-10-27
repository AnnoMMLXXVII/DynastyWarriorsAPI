/**
 * 
 */
package com.anno.dw8xl.level.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Component
public class Level implements LevelI {
	
	@JsonView({CharacterView.Weapon.Attribute.class})
	@JsonProperty("value")
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
	public int getPower() {
		return power;
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

}
