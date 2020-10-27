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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Component
public class Normal extends Weapon {

	@JsonView(CharacterView.Length.class)
	private LengthI length;

	protected Normal() {
		/**
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
	public Normal(String name, Integer baseAttack, LengthI length, Integer star, TypeI type) {
		super(name, baseAttack, star, type);
		this.length = length;
	}

	@Override
	public RarityI getRarity() {
		return new Rarity("Normal");
	}

	/**
	 * @return the length
	 */
	public String getLength() {
		return length.getSize();
	}

	@Override
	public AffinityI getAffinity() {
		return new Affinity("?");
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
		Normal other = (Normal) obj;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return String.format("%s, %s", super.toString(), length.getSize());
	}

}
