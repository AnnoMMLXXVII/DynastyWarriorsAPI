package com.anno.warriors.dw8.weapons.model;

import java.util.List;

import com.anno.warriors.dw8.enums.affinity.Affinity;
import com.anno.warriors.dw8.enums.category.Category;
import com.anno.warriors.dw8.enums.rarity.Rarity;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.weapons.slots.AttributeSlot;

public class Extreme extends Weapon {

	private Affinity affinity;

	public Extreme(String name, Integer power, Integer star, Types type, Affinity affinity) {
		super(name, power, star, type);
		this.affinity = affinity;
	}

	@Override
	public int compareToByAffinity(WeaponInterface<Weapon> o) {
		return this.affinity.compareTo(o.getAffinity());
	}

	@Override
	public String getLength() {
		return "";
	}

	@Override
	public Affinity getAffinity() {
		return affinity;
	}

	@Override
	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	@Override
	public Rarity getRarity() {
		return rarity;
	}

	@Override
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public Category getCategory() {
		return category;
	}

	@Override
	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String getImage() {
		return image;
	}

	@Override
	public void setAttributeSlots(List<AttributeSlot> attributeSlot) {
		this.attributeSlot = attributeSlot;
	}

	@Override
	public List<AttributeSlot> getAttributeSlots() {
		return attributeSlot;
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((affinity == null) ? 0 : affinity.hashCode());
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
		Extreme other = (Extreme) obj;
		if (affinity != other.affinity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " affinity=" + affinity.name() + "]";
	}

}
