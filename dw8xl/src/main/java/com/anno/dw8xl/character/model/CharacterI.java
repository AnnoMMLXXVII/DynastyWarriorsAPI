package com.anno.dw8xl.character.model;

import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.shared.CharacterIDeserializer;
import com.anno.dw8xl.type.model.TypeI;
import com.anno.dw8xl.weapon.model.WeaponI;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Haku Wei
 *
 */

@JsonDeserialize(using = CharacterIDeserializer.class)
@JsonSubTypes({ @Type(value = Officer.class, name = "Officer"), @Type(value = SubOfficer.class, name = "SubOfficer"),
		@Type(value = NullCharacter.class, name = "null") })
public interface CharacterI {

	public String getName();

	public KingdomI getKingdom();

	public TypeI getType();

	public WeaponI getWeapon();

	public int hashCode();

	public boolean equals(Object obj);

}
