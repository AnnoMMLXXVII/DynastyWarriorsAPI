package com.anno.warriors.dw8.characters.model;

import com.anno.warriors.dw8.enums.kingdom.Kingdom;

public class Officer implements Comparable<Officer>, CharacterInterface {

	private String name;
	private Kingdom kingdom;
	private String weapon;

	public Officer() {
		super();
	}

	public Officer(String name, Kingdom kingdom, String weapon) {
		super();
		this.name = name;
		this.kingdom = kingdom;
		this.weapon = weapon;
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getKingdom() {
		return kingdom.getValue();
	}

	@Override
	public String getWeapon() {
		return weapon;
	}

	@Override
	public int compareTo(Officer o) {
		return this.getName().compareTo(o.getName());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kingdom == null) ? 0 : kingdom.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((weapon == null) ? 0 : weapon.hashCode());
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
		Officer other = (Officer) obj;
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
		if (weapon == null) {
			if (other.weapon != null)
				return false;
		} else if (!weapon.equals(other.weapon))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Officer [name=" + name + ", kingdom=" + kingdom + ", weapon=" + weapon + "]";
	}

}
