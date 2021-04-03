/**
 * 
 */
package com.anno.dw8xl.attribute.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.level.model.LevelI;
import com.anno.dw8xl.level.model.NullLevel;
import com.anno.dw8xl.rarity.model.Rarity;
import com.anno.dw8xl.rarity.model.RarityI;
import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Haku Wei
 *
 */
@Component
@JsonTypeName("Normal")
@JsonDeserialize(as = Normal.class)
public class Normal extends Attribute {

	@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "state")
	private String state = "normal";

	@JsonView({ CharacterView.Weapon.Attribute.class })
	private LevelI level;

	public Normal() {
		/*
		 * 
		 */
	}

	/**
	 * @param name
	 */
	public Normal(String name) {
		super(name);
	}

	/**
	 * @param name
	 * @param description
	 */
	public Normal(String name, String description) {
		super(name, description);
		level = new NullLevel();
	}

	/**
	 * @param name
	 * @param level
	 */
	public Normal(String name, LevelI level) {
		super(name, "");
		this.level = level;
	}

	/**
	 * @param name
	 * @param description
	 * @param level
	 */
	public Normal(String name, String description, LevelI level) {
		super(name, description);
		this.level = level;
	}

	/**
	 * @param level
	 */
	public void setLevel(LevelI level) {
		this.level = level;
	}

	/**
	 * @return
	 */
	public LevelI getLevel() {
		return level;
	}

	@Override
	public RarityI getRarity() {
		return new Rarity("normal");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((level == null) ? 0 : level.hashCode());
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
		Normal other = (Normal) obj;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
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
		return String.format("%s, %s", super.toString(), getLevel().toString());
	}

}
