package com.anno.warriors.dw8.characters;

import com.anno.warriors.dw8.manager.DynastyWarriors8Object;

public interface CharacterInterface extends DynastyWarriors8Object<CharacterInterface> {

	public String getName();

	public String getKingdom();

	public abstract String getWeapon();

	public int hashCode();

	public boolean equals(Object obj);

	public String toString();

}
