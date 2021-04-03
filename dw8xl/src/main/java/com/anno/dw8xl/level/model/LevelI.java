package com.anno.dw8xl.level.model;

import com.anno.dw8xl.shared.LevelDeserializer;
import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonView({ CharacterView.Attribute.class, CharacterView.Weapon.Attribute.class })
@JsonDeserialize(using = LevelDeserializer.class)
@JsonSubTypes({ @Type(value = Level.class, name = "Level"), })
public interface LevelI {
	int getPower();

	@Override
	int hashCode();

	@Override
	boolean equals(Object obj);
}
