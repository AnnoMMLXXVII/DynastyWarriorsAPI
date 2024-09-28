package com.anno.warriors.dw8.characters.model;

import java.util.List;
import java.util.UUID;

import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.images.model.DynastyWarriors8Image;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;

public interface CharacterInterface<T> extends Comparable<T>, DynastyWarriors8Object<CharacterInterface<T>> {

	public String getId();

	public String getName();

	public Character setName(String name);

	public Character setKingdom(String kingdom);

	public Kingdom getKingdom();

	public abstract Types getWeaponType();

	public Character setWeaponType(String type);

	public abstract List<WeaponInterface<Weapon>> getWeapons();

	public abstract Character setWeapons(List<WeaponInterface<Weapon>> weapons);

	public abstract int compareTo(T o);

	public abstract int compareTo(String o);

	public abstract int compareTo(Types o);

	public abstract Character setImage(List<DynastyWarriors8Image> path);

	public abstract List<DynastyWarriors8Image> getImage();

	public abstract Character setId(UUID id);

	public int hashCode();

	public boolean equals(Object obj);

	public String toString();

}
