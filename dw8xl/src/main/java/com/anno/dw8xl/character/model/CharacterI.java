package com.anno.dw8xl.character.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * @author Haku Wei
 *
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE, include = As.PROPERTY)
@JsonSubTypes({ @Type(value = Officer.class, name = "Officer"), @Type(value = SubOfficer.class, name = "SubOfficer"), })
public interface CharacterI {

	public String getName();

	public String getKingdom();

}
