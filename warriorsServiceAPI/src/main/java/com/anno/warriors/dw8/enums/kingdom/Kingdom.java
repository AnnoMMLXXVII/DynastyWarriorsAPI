package com.anno.warriors.dw8.enums.kingdom;

import com.anno.warriors.dw8.enums.DW8Enumeration;

public enum Kingdom implements DW8Enumeration<Kingdom> {

	SHU("Shu"), WU("Wu"), WEI("Wei"), JIN("Jin"), OTHER("Other");

	private String value;

	private Kingdom(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Kingdom returnCorrectEnum(String str) {
		if (str.equals(Kingdom.SHU.getValue())) {
			return Kingdom.SHU;
		} else if (str.equals(Kingdom.WU.getValue())) {
			return Kingdom.WU;
		} else if (str.equals(Kingdom.WEI.getValue())) {
			return Kingdom.WEI;
		} else if (str.equals(Kingdom.JIN.getValue())) {
			return Kingdom.JIN;
		} else {
			return Kingdom.OTHER;
		}
	}

}
