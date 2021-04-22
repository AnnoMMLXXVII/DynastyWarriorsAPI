package com.anno.warriors.dw8.characters.model;

import java.util.ArrayList;
import java.util.List;

import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;

public class Officer extends Character {

	private Types weapon;
	private List<WeaponInterface<Weapon>> weapons;

	public Officer() {
		super();
	}

	public Officer(String name, Kingdom kingdom, Types weapon) {
		super(name, kingdom);
		this.weapon = weapon;
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
	}

	@Override
	public Types getWeaponType() {
		return weapon;
	}

	@Override
	public void setWeapons(List<WeaponInterface<Weapon>> weapons) {
		this.weapons = weapons;
	}

	@Override
	public List<WeaponInterface<Weapon>> getWeapons() {
		return weapons == null ? new ArrayList<>() : weapons;
	}

	@Override
	public void setImage(List<String> image) {
		this.image = image;
	}

	@Override
	public List<String> getImage() {
		return image == null ? new ArrayList<>() : image;
	}

	@Override
	public int compareTo(Character o) {
		return this.getName().compareTo(o.getName());
	}

	@Override
	public int compareTo(String o) {
		return this.getName().compareTo(o);
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
		if (weapon != other.weapon)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " weapon=" + weapon.getValue() + " Weapons " + weapons.toString();
	}

}
