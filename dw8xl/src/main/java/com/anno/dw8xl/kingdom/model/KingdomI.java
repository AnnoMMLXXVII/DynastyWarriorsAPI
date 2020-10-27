/**
 * 
 */
package com.anno.dw8xl.kingdom.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * @author Haku Wei
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE, include = As.PROPERTY)
@JsonSubTypes({ @Type(value = Kingdom.class, name = "Kingdom"), @Type(value = NullKingdom.class, name = "null"), })
public interface KingdomI {

	public String getName();

	@Override
	public int hashCode();

	@Override
	public boolean equals(Object obj);

	@Override
	public String toString();

}
