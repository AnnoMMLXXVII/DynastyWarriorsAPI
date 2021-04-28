package com.anno.warriors.dw8.weapons.slots;

import com.anno.warriors.dw8.enums.attribute.AttributeInterface;

public class PowerlessAttribute extends AttributeSlot {

	protected PowerlessAttribute() {
		super();
	}

	public PowerlessAttribute(AttributeInterface attribute) {
		super(attribute);
	}
	
	@Override
	public Integer getLevel() {
		return 0;
	}

	@Override
	public String getState() {
		return "Special";
	}

	@Override
	public int compareTo(AttributeSlot o) {
		return getName().compareTo(o.getName());
	}

}
