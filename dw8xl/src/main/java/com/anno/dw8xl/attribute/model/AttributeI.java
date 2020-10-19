package com.anno.dw8xl.attribute.model;

import com.anno.dw8xl.rarity.model.Rarity;

public interface AttributeI {

	public String getName();
	public String getDescription();
	public int hashCode();
	public boolean equals(Object obj);
	public abstract Rarity getType();
}
