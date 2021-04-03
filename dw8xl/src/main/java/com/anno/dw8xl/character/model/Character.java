package com.anno.dw8xl.character.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Haku Wei
 *
 */
@Component
@JsonDeserialize(as = CharacterI.class)
@JsonView({CharacterView.Officer.class, CharacterView.SubOfficer.class})
public abstract class Character implements CharacterI {
	
	private String name;
	private KingdomI kingdom;
	
	public Character() {
		/*
		 * Empty On purpose Must Be empty Commenting to resolve sonar
		 */
	}

	/**
	 * @param name
	 * @param kingdom
	 */
	public Character(String name, KingdomI kingdom) {
		super();
		this.name = name;
		this.kingdom = kingdom;
	}

	/**
	 * @return the name
	 */
	@Override
	@JsonView({ CharacterView.Officer.class, CharacterView.SubOfficer.class })
	public String getName() {
		return name;
	}

	/**
	 * @return the kingdom
	 */
	@Override
	@JsonView({ CharacterView.Officer.class, CharacterView.SubOfficer.class })
	public KingdomI getKingdom() {
		return kingdom;
	}

	@Override
	public String toString() {
		return name + ", " + kingdom.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kingdom == null) ? 0 : kingdom.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Character other = (Character) obj;
		if (kingdom == null) {
			if (other.kingdom != null)
				return false;
		} else if (!kingdom.equals(other.kingdom))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
