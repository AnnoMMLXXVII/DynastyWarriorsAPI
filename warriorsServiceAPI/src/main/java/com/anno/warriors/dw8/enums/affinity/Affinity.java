package com.anno.warriors.dw8.enums.affinity;

import com.anno.warriors.dw8.enums.DW8Enumeration;

public enum Affinity implements DW8Enumeration<Affinity> {

	HEAVEN("Heaven"), EARTH("Earth"), MAN("Man");

	/*
	 * Trianglular Relationship -> Man > Heaven -> Heaven > Earth -> Earth > Man
	 */

	private String value;

	private Affinity(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

	public static Affinity returnCorrectEnum(String str) {
		if (str.equals(Affinity.EARTH.getValue())) {
			return Affinity.EARTH;
		} else if (str.equals(Affinity.HEAVEN.getValue())) {
			return Affinity.HEAVEN;
		} else {
			return Affinity.MAN;
		}
	}

}
