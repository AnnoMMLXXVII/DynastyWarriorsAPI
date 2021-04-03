/**
 * 
 */
package com.anno.dw8xl.rarity.model;

import com.anno.dw8xl.shared.RarityDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author venividivicihofneondeion010101
 *
 */
@JsonDeserialize(using = RarityDeserializer.class)
@JsonSubTypes({ @Type(value = Rarity.class, name = "Rarity"), @Type(value = NullRarity.class, name = "Null"), })
public interface RarityI {

	@JsonIgnore
	public String getType();

	@Override
	public int hashCode();

	@Override
	public boolean equals(Object obj);

	@Override
	public String toString();
}
