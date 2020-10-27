package com.anno.dw8xl.attribute.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE, include = As.PROPERTY)
@JsonSubTypes({ @Type(value = Normal.class, name = "Normal"), @Type(value = Special.class, name = "Special"),
		@Type(value = NullAttribute.class, name = "Null"), })
public interface AttributeI {
	public String getName();

	public String getDescription();

	@Override
	public int hashCode();

	@Override
	public boolean equals(Object obj);

	@JsonProperty("rarity")
	public abstract String getRarity();
}
