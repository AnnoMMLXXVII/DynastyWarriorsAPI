package com.anno.warriors.dw8.enums.category;

import com.anno.warriors.dw8.enums.DW8Enumeration;

public enum Category implements DW8Enumeration<Category> {

	WHIRLD_WIND("Whirl Wind"), DASHER("Dasher"), SHADOW_SPRINTER("Shadow Sprinter"), DIVER("Diver");

	private String value;

	private Category(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

	public static Category returnCorrectEnum(String str) {
		if (str.equals(Category.WHIRLD_WIND.getValue())) {
			return Category.WHIRLD_WIND;
		} else if (str.equals(Category.DASHER.getValue())) {
			return Category.DASHER;
		} else if (str.equals(Category.SHADOW_SPRINTER.getValue())) {
			return Category.SHADOW_SPRINTER;
		} else {
			return Category.DIVER;
		}
	}
}
