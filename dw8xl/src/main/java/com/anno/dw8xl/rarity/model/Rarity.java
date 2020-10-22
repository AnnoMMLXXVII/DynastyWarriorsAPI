package com.anno.dw8xl.rarity.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Rarity {
	@JsonValue
	NORMAL, RARE, UNIQUE, EXTREME, SPECIAL
}
