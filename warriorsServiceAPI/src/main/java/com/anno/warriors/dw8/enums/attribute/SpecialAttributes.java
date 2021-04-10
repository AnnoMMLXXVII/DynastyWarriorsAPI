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

	AWARENESS, DESPERATION, RESOLVE, SWIFTNESS, AGILITY, GREED, FURY, RIGIDITY, BATTLEAXE, ARMOR_SLEEVE, WAR_SHOES,
	RAKSHASA, SHINING_WARRIOR;

	private String name;
	private String description;

	@Override
	public String getValue() {
		return String.format("%s, %s", name, description);
	}

	@Override
	public String getName() {
		return name();
	}

	@Override
	public DW8Enumeration<AttributeInterface> getManagerType() {
		return this;
	}

	@Override
	public String getType() {
		return "Special";
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
		for (SpecialAttributes a : values()) {
			if (a.name().equalsIgnoreCase(str)) {
				return a;
			}
		}
		return null;
	}

}
