/**
 * 
 */
package com.anno.warriors.dw8.enums.attribute;

import com.anno.warriors.dw8.enums.DW8Enumeration;

/**
 * @author venividivicihofneondeion010101
 *
 */
public enum SpecialAttributes implements AttributeInterface {

	AWARENESS("Awareness", "Can block attacks from the rear"),
	DESPERATION("Desperation", "Doubles attack power when in critical condition"),
	RESOLVE("Resolve", "Doubles defense power when in critical condition"),
	SWITFTNESS("Switftness", "Doubles movement speed when in critical condition"),
	AGILITY("Agility", "Releases a damaging war cry when recovering from an attack in mid-air"),
	GREED("Greed", "Produces money by attack blocking enemies"),
	FURY("Fury", "Enables the use of True Mosou regardless of health"),
	RIGIDITY("Rigidity", "The user's guard cannot be broke by any attack"),
	BATTLEAXE("Battleaxe", "Doubles attack power momentarily upon defeating 50 enemies"),
	ARMOR_SLEEVE("Armor Sleeve", "Doubles defense power momentarily upon defeating 50 enemies"),
	WAR_SHOES("War Shoes", "Doubles movement speed momentarily upon defeating 50 enemies"),
	RAKSHASA("Rakshasa", "Lowers health"),
	SHINING_WARRIOR("Shining Warrior", "Raises attack power the more allies are nearby");

	private String name;
	private String description;

	private SpecialAttributes() {

	}

	SpecialAttributes(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String getValue() {
		return String.format("%s, %s", name, description);
	}

	@Override
	public String getName() {
		return name();
	}

	@Override
	public DW8Enumeration<AttributeInterface> getObjectType() {
		return this;
	}

	@Override
	public String getType() {
		return "Special";
	}

	@Override
	public String getDescription() {
		return description;
	}

	public static AttributeInterface returnCorrectEnum(String str) {
		for (SpecialAttributes a : values()) {
			if (a.name().equalsIgnoreCase(str)) {
				return a;
			}
		}
		return null;
	}

}
