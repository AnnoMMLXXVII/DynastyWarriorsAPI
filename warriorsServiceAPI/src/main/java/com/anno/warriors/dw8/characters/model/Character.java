package com.anno.warriors.dw8.characters.model;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.images.model.DynastyWarriors8Image;

public abstract class Character implements CharacterInterface<Character> {

	private String id;
	private String name;
	private Kingdom kingdom;
	protected List<DynastyWarriors8Image> image;

	public Character() {

	}

	public Character(UUID id, String name, Kingdom kingdom) {
		setId(id);
		setName(name);
		this.kingdom = kingdom;
	}

	public Character(UUID id, String name, String kingdom) {
		setId(id);
		setName(name);
		setKingdom(kingdom);
	}

	@Override
	public String getId() {
		return id;
	}

	public Character setId(UUID id) {
		this.id = id.toString();
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Character setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public Character setKingdom(String kingdom) {
		this.kingdom = Kingdom.valueOf(kingdom);
		return this;
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
		return Objects.hash(id, kingdom, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Character)) {
			return false;
		}
		Character other = (Character) obj;
		return Objects.equals(id, other.id) && kingdom == other.kingdom && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Character: name=" + name + ", kingdom=" + kingdom;
	}

}
