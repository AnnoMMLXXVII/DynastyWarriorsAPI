/**
 * 
 */
package com.anno.dw8xl.character.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.type.model.TypeI;

/**
 * @author Haku Wei
 *
 */
@Component
public abstract class Character implements CharacterI {

	private String name;
	private KingdomI kingdom;
	
	public Character() {}

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
	public String getName() {
		return name;
	}

	/**
	 * @return the kingdom
	 */
	public KingdomI getKingdom() {
		return kingdom;
	}

	public abstract TypeI getType();

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

	@Override
	public String toString() {
		return  name + ", "+kingdom ;
	}
	
	
}
