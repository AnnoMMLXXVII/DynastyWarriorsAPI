package com.anno.warriors.dw8.weapons.model;

import java.util.List;

import com.anno.warriors.dw8.enums.affinity.Affinity;
import com.anno.warriors.dw8.enums.category.Category;
import com.anno.warriors.dw8.enums.rarity.Rarity;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.images.model.DynastyWarriors8Image;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.weapons.slots.AttributeSlot;

public interface WeaponInterface<T> extends Comparable<T>, DynastyWarriors8Object<WeaponInterface<T>> {

	public int compareTo(T o);

	public int compareTo(Integer o);

	public int compareTo(int o);

	public abstract int compareTo(Affinity o);

	public int compareTo(Types o);

	public int compareTo(Rarity o);

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

	public abstract void setImage(DynastyWarriors8Image path);

	public abstract DynastyWarriors8Image getImage();

	public abstract void setAttributeSlots(List<AttributeSlot> attributeSlot);

	public abstract List<AttributeSlot> getAttributeSlots();

}
