package com.anno.warriors.dw8.enums.rarity;

import com.anno.warriors.dw8.enums.DW8Enumeration;

public enum Rarity implements DW8Enumeration<Rarity> {

	NORMAL("Normal"), RARE("Rare"), UNIQUE("Unique"), EXTREME("Xtreme"), SPECIAL("Special");

	private String value;

	private Rarity(String value) {
		this.value = value;
	}

	public String getFormatedString() {
		String firstLetter = value.substring(0, 1).toUpperCase();
		String latter = value.substring(1, value.length());
		return firstLetter + latter;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
	}

	public static Rarity returnCorrectEnum(String str) {
		for (Rarity r : values()) {
			if (r.getValue().equals(str)) {
				return r;
			}
		}
		return null;
	}
}
