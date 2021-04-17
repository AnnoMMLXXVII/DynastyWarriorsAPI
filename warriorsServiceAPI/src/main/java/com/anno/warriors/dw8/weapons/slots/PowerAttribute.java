package com.anno.warriors.dw8.weapons.slots;

import com.anno.warriors.dw8.enums.attribute.AttributeInterface;

public class PowerAttribute extends AttributeSlot {
	private Integer level;

	protected PowerAttribute() {
		super();
	}

	public PowerAttribute(AttributeInterface attribute, Integer level) {
		super(attribute);
		this.level = level;
	}

	@Override
	public int compareTo(AttributeSlot o) {
		return getName().compareTo(o.getName());
	}

	public Integer getLevel() {
		return level;
	}

	public int compareToByLevels(int level) {
		return this.level - level;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((level == null) ? 0 : level.hashCode());
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
		PowerAttribute other = (PowerAttribute) obj;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " , level=" + level + "]";
	}

	@Override
	public String getState() {
		return "Normal";
	}

}