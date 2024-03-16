package com.anno.warriors.dw8.characters.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.images.model.DynastyWarriors8Image;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;

public class SubOfficer extends Character {

	public SubOfficer() {
		super();
	}

	public SubOfficer(String name, Kingdom kingdom) {
		super(UUID.randomUUID(), name, kingdom);
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
	public Character setWeaponType(String type) {
		return this;
	}

	@Override
	public Character setImage(List<DynastyWarriors8Image> image) {
		/*
		 * 
		 */
		return this;
	}

	@Override
	public List<DynastyWarriors8Image> getImage() {
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
	public Character setWeapons(List<WeaponInterface<Weapon>> weapons) {
		/*
		 * 
		 */
		return this;
	}

}
