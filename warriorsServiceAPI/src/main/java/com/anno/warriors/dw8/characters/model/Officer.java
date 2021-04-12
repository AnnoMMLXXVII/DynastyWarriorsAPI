package com.anno.warriors.dw8.characters.model;

import com.anno.warriors.dw8.enums.kingdom.Kingdom;

public class Officer extends Character {

	private String weapon;

	public Officer() {
		super();
	}

	public Officer(String name, Kingdom kingdom, String weapon) {
		super(name, kingdom);
		this.weapon = weapon;
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
	}

	@Override
	public String getWeapon() {
		return weapon;
	}

	@Override
	public int compareTo(Character o) {
		return this.getName().compareTo(o.getName());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((weapon == null) ? 0 : weapon.hashCode());
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
		Officer other = (Officer) obj;
		if (weapon == null) {
			if (other.weapon != null)
				return false;
		} else if (!weapon.equals(other.weapon))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " weapon=" + weapon;
	}

}
