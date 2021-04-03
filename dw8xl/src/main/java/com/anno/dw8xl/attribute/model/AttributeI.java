package com.anno.dw8xl.attribute.model;

import com.anno.dw8xl.shared.AttributeDeserializer;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//@JsonView({ CharacterView.Attribute.class, CharacterView.Weapon.Attribute.class })
@JsonDeserialize(using = AttributeDeserializer.class)
@JsonSubTypes({ @Type(value = Normal.class, name = "Normal"), @Type(value = Special.class, name = "Special"),
		@Type(value = NullAttribute.class, name = "Null"), })
public interface AttributeI {

	public String getName();

	public String getDescription();

	@Override
	public int hashCode();

	@Override
	public boolean equals(Object obj);

	public abstract String getRarity();

	public abstract int getLevel();
}
