package com.anno.warriors.dw8.keys;

import com.anno.warriors.dw8.enums.types.Types;

public class WeaponName_TypesAttributesKey {

	private String weaponName;
	private Types type;

	protected WeaponName_TypesAttributesKey() {
		super();
	}

	public WeaponName_TypesAttributesKey(String weaponName, Types type) {
		this.weaponName = weaponName;
		this.type = type;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public Types getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((weaponName == null) ? 0 : weaponName.hashCode());
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
		WeaponName_TypesAttributesKey other = (WeaponName_TypesAttributesKey) obj;
		if (type != other.type)
			return false;
		if (weaponName == null) {
			if (other.weaponName != null)
				return false;
		} else if (!weaponName.equals(other.weaponName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WeaponName_TypesAttributesKey [weaponName=" + weaponName + ", type=" + type + "]";
	}

}
