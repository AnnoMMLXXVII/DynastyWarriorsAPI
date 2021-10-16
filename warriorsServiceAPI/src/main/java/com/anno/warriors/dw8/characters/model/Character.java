package com.anno.warriors.dw8.characters.model;

import java.util.List;

import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.images.model.DynastyWarriors8Image;

public abstract class Character implements CharacterInterface<Character> {

	private String name;
	private Kingdom kingdom;
	protected List<DynastyWarriors8Image> image;

	public Character() {

	}

	public Character(String name, Kingdom kingdom) {
		this.name = name;
		this.kingdom = kingdom;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Kingdom getKingdom() {
		return kingdom;
	}

	@Override
	public int compareTo(Character o) {
		return getName().compareTo(o.getName());
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
		if (kingdom != other.kingdom)
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
		return "Character: name=" + name + ", kingdom=" + kingdom;
	}

}
