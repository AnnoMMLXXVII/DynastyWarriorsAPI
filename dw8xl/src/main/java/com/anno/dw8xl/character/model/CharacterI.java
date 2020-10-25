/**
 * 
 */
package com.anno.dw8xl.character.model;

import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.type.model.TypeI;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * @author Haku Wei
 *
 */

@JsonTypeInfo(
use = JsonTypeInfo.Id.NAME, 
include = As.PROPERTY, 
property = "char-type"
)
@JsonSubTypes({
@Type(value = Officer.class, name = "Officer"),
@Type(value = SubOfficer.class, name = "SubOfficer"),
})
public interface CharacterI {

	public String getName();
	public KingdomI getKingdom();
	public abstract TypeI getType();
	
	
}
