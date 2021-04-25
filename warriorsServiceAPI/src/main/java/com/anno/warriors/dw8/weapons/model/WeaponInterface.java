package com.anno.warriors.dw8.weapons.model;

import java.util.List;

import com.anno.warriors.dw8.enums.affinity.Affinity;
import com.anno.warriors.dw8.enums.category.Category;
import com.anno.warriors.dw8.enums.rarity.Rarity;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.weapons.slots.AttributeSlot;

public interface WeaponInterface<T> extends Comparable<T>, DynastyWarriors8Object<WeaponInterface<T>> {

	public int compareTo(T o);

	public int compareToByPower(Integer o);

	public int compareToByStar(Integer o);

	public abstract int compareToByAffinity(Affinity o);

	public String getName();

	public Integer getPower();

	public abstract String getLength();

	public abstract Affinity getAffinity();

	public Integer getStar();

	public Types getType();

	public void setRarity(Rarity rarity);

	public Rarity getRarity();

	public void setCategory(Category category);

	public Category getCategory();

	public abstract void setImage(String path);

	public abstract String getImage();

	public abstract void setAttributeSlots(List<AttributeSlot> attributeSlot);

	public abstract List<AttributeSlot> getAttributeSlots();

}
