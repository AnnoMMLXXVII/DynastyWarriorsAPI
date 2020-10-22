package com.anno.dw8xl.attribute.model;

import com.anno.dw8xl.rarity.model.Rarity;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(
use = JsonTypeInfo.Id.NAME, 
include = As.PROPERTY, 
property = "ID-Type"
)
@JsonSubTypes({
@Type(value = Normal.class, name = "N"),
@Type(value = Special.class, name = "S"),
})
public interface AttributeI {
	public String getName();
	public String getDescription();
//	public abstract int getId();
	public int hashCode();
	public boolean equals(Object obj);
	public abstract Rarity getType();
}
