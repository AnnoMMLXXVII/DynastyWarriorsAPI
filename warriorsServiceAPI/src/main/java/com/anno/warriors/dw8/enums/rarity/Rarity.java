package com.anno.warriors.dw8.enums.rarity;

import com.anno.warriors.dw8.enums.DW8Enumeration;

public enum Rarity implements DW8Enumeration<Rarity> {

	NORMAL("Normal"), RARE("Rare"), UNIQUE("Unique"), EXTREME("Xtreme"), SPECIAL("Special");

	private String value;

	private Rarity(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

	public static Rarity returnCorrectEnum(String str) {
		if (str.equals(Rarity.NORMAL.getValue())) {
			return Rarity.NORMAL;
		} else if (str.equals(Rarity.RARE.getValue())) {
			return Rarity.RARE;
		} else if (str.equals(Rarity.UNIQUE.getValue())) {
			return Rarity.UNIQUE;
		} else if (str.equals(Rarity.EXTREME.getValue())) {
			return Rarity.EXTREME;
		} else {
			return Rarity.SPECIAL;
		}
	}
}
