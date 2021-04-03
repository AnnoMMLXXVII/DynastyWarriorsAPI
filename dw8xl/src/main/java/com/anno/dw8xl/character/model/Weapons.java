/**
 * 
 */
package com.anno.dw8xl.character.model;

import java.util.List;

import com.anno.dw8xl.weapon.model.WeaponI;

/**
 * @author Haku Wei
 *
 */
public class Weapons {

	private List<WeaponI> characterWeapons;
	
	public Weapons(List<WeaponI> characterWeapons) {
		this.characterWeapons= characterWeapons;
	}
	
	public List<WeaponI> getWeapons() {
		return characterWeapons;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((characterWeapons == null) ? 0 : characterWeapons.hashCode());
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
		Weapons other = (Weapons) obj;
		if (characterWeapons == null) {
			if (other.characterWeapons != null)
				return false;
		} else if (!characterWeapons.equals(other.characterWeapons))
			return false;
		return true;
	}

}
