/**
 * 
 */
package com.anno.dw8xl.rarity.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * @author venividivicihofneondeion010101
 *
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE, include = As.PROPERTY)
@JsonSubTypes({ @Type(value = Rarity.class, name = "Rarity"), @Type(value = NullRarity.class, name = "Null"), })
public interface RarityI {

	public String getType();

	@Override
	public int hashCode();

	@Override
	public boolean equals(Object obj);

	@Override
	public String toString();
}
