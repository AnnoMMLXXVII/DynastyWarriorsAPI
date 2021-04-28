package com.anno.warriors.dw8.weapons.model;

import java.util.ArrayList;
import java.util.List;

import com.anno.warriors.dw8.enums.affinity.Affinity;
import com.anno.warriors.dw8.enums.category.Category;
import com.anno.warriors.dw8.enums.rarity.Rarity;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.weapons.slots.AttributeSlot;

public abstract class Weapon implements WeaponInterface<Weapon> {

	private String name;
	private Integer power;
	private Integer star;
	private Types type;
	private String image;
	private List<AttributeSlot> attributeSlot;

	protected Rarity rarity;
	protected Category category;
	protected Affinity affinity;

	public Weapon(String name, Integer power, Integer star, Types type) {
		this.name = name;
		this.power = power;
		this.star = star;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public Integer getPower() {
		return power;
	}

	public Integer getStar() {
		return star;
	}

	public Types getType() {
		return type;
	}

	@Override
	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String getImage() {
		return image == null ? "N/A" : image;
	}

	@Override
	public void setAttributeSlots(List<AttributeSlot> attributeSlot) {
		this.attributeSlot = attributeSlot;
	}

	@Override
	public List<AttributeSlot> getAttributeSlots() {
		return attributeSlot == null ? new ArrayList<>() : attributeSlot;
	}

	@Override
	public int compareTo(Weapon o) {
		return this.getName().compareTo(o.getName());
	}

	@Override
	public int compareTo(Integer o) {
		return this.getPower().compareTo(o);
	}

	@Override
	public int compareTo(int o) {
		return this.getStar().compareTo(o);
	}

	@Override
	public int compareTo(Types o) {
		return this.getType().compareTo(o);
	}

	@Override
	public int compareTo(Rarity o) {
		return this.getRarity().compareTo(o);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((power == null) ? 0 : power.hashCode());
		result = prime * result + ((star == null) ? 0 : star.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weapon other = (Weapon) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (power == null) {
			if (other.power != null)
				return false;
		} else if (!power.equals(other.power))
			return false;
		if (star == null) {
			if (other.star != null)
				return false;
		} else if (!star.equals(other.star))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Weapon [name=" + name + ", power=" + power + ", star=" + star + ", type=" + type + ", rarity=" + rarity
				+ ", category=" + category;
	}

}
