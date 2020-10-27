/**
 * 
 */
package com.anno.dw8xl.weapon.model;

import com.anno.dw8xl.affinity.model.AffinityI;
import com.anno.dw8xl.rarity.model.RarityI;
import com.anno.dw8xl.type.model.TypeI;

/**
 * @author venividivicihofneondeion010101
 *
 */
public class AbNormal extends Weapon {

	private AffinityI affinity;
	private RarityI rarity;

	public AbNormal() {
		super();
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
	}

	@Override
	public AffinityI getAffinity() {
		return affinity;
	}

	@Override
	public RarityI getRarity() {
		return rarity;
	}
	
	@Override
	public String getLength() {
		return "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((affinity == null) ? 0 : affinity.hashCode());
		result = prime * result + ((rarity == null) ? 0 : rarity.hashCode());
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
		if (rarity == null) {
			if (other.rarity != null)
				return false;
		} else if (!rarity.equals(other.rarity))
			return false;
		return true;
	}

}
