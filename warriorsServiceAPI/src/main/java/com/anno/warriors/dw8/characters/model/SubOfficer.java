package com.anno.warriors.dw8.characters.model;

import java.util.ArrayList;
import java.util.List;

import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;

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
	public Types getWeaponType() {
		return null;
	}

	@Override
	public void setImage(List<String> image) {
		/*
		 * 
		 */
	}

	@Override
	public List<String> getImage() {
		return new ArrayList<>();
	}

	@Override
	public int compareTo(Character o) {
		return getName().compareTo(o.getName());
	}

	@Override
	public int compareTo(String o) {
		return getName().compareTo(o);
	}

	@Override
	public int compareTo(Types o) {
		return -1;
	}

	@Override
	public List<WeaponInterface<Weapon>> getWeapons() {
		return new ArrayList<>();
	}

	@Override
	public void setWeapons(List<WeaponInterface<Weapon>> weapons) {
		/*
		 * 
		 */
	}

}
