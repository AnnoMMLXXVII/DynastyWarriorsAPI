/**
 * 
 */
package com.anno.dw8xl.weapon.dao;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.type.model.TypeI;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Component
public class WeaponKey {
	private String weaponName;
	private TypeI weaponType;

	public WeaponKey(String weaponName, TypeI weaponType) {
		this.weaponName = weaponName;
		this.weaponType = weaponType;
	}

	/**
	 * @return the weaponName
	 */
	public String getWeaponName() {
		return weaponName;
	}

	/**
	 * @return the weaponType
	 */
	public TypeI getWeaponType() {
		return weaponType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((weaponName == null) ? 0 : weaponName.hashCode());
		result = prime * result + ((weaponType == null) ? 0 : weaponType.hashCode());
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
		WeaponKey other = (WeaponKey) obj;
		if (weaponName == null) {
			if (other.weaponName != null)
				return false;
		} else if (!weaponName.equals(other.weaponName))
			return false;
		if (weaponType == null) {
			if (other.weaponType != null)
				return false;
		} else if (!weaponType.equals(other.weaponType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[ " + weaponName + ", " + weaponType.getName() + " ]";
	}
}
