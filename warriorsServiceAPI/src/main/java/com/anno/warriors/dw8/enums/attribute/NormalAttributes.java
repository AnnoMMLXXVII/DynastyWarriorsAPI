package com.anno.warriors.dw8.enums.attribute;

import com.anno.warriors.dw8.enums.DW8Enumeration;

public enum NormalAttributes implements AttributeInterface {

	THORNS, SURVIVAL, FRENZY, BARRICADE, AGGRESSION, VELOCITY, FLURRY, CHAIN, INFERNO, FROST, THUNDER, CYCLONE, SLASH,
	VENOM, FLASH, SPURT, RECOVERY, UPLIFT, ENLIGHTENMENT, EXPLOSIVE, INDUCTION, JOLT, HARMONY, PROTECTION, FEAR, AWE,
	MORASS, JUBILATION, ROAR, TRIUMPH, GALE, COMET, THUNDERCLAP, EFFLORESCENCE, CONFLAGRATION;

	private String name;
	private String description;

	@Override
	public String getValue() {
		return String.format("%s, %s", name, description);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public DW8Enumeration<AttributeInterface> getManagerType() {
		return this;
	}

	@Override
	public String getType() {
		return "Normal";
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public static AttributeInterface returnCorrectEnum(String str) {
		for (NormalAttributes a : values()) {
			if (a.getName().equalsIgnoreCase(str)) {
				return a;
			}
		}
		return null;
	}

}
