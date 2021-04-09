package com.anno.warriors.dw8.characters;

import com.anno.warriors.dw8.enums.kingdom.Kingdom;

public class SubOfficer implements CharacterInterface {

	private String name;
	private Kingdom kingdom;

	public SubOfficer() {
		super();
	}

	public SubOfficer(String name, Kingdom kingdom) {
		super();
		this.name = name;
		this.kingdom = kingdom;
	}

	@Override
	public CharacterInterface getManagerType() {
		return this;
	}

	public String getName() {
		return name;
	}

	public String getKingdom() {
		return kingdom.getValue();
	}

	@Override
	public String getWeapon() {
		return "";
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
		SubOfficer other = (SubOfficer) obj;
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
		return "SubOfficer [name=" + name + ", kingdom=" + kingdom + "]";
	}

}
