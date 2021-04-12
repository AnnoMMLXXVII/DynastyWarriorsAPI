package com.anno.warriors.dw8.characters.model;

import com.anno.warriors.dw8.manager.DynastyWarriors8Object;

public interface CharacterInterface<T> extends Comparable<T>, DynastyWarriors8Object<CharacterInterface<T>> {

	public String getName();

	public String getKingdom();

	public abstract String getWeapon();

	public abstract int compareTo(T o);

	public int hashCode();

	public boolean equals(Object obj);

	public String toString();

}
