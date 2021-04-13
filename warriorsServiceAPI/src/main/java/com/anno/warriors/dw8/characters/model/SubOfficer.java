package com.anno.warriors.dw8.characters.model;

import com.anno.warriors.dw8.enums.kingdom.Kingdom;

public class SubOfficer extends Character {

	public SubOfficer() {
		super();
	}

	public SubOfficer(String name, Kingdom kingdom) {
		super(name, kingdom);
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
	}

	@Override
	public String getWeapon() {
		return "";
	}

	@Override
	public int compareTo(Character o) {
		return getName().compareTo(o.getName());
	}

	@Override
	public int compareTo(String o) {
		return getName().compareTo(o);
	}

}
