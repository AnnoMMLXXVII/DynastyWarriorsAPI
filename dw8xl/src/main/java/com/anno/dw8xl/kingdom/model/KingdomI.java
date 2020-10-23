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
@JsonTypeInfo(
use = JsonTypeInfo.Id.NAME, 
include = As.PROPERTY, 
property = "ID-Kingdom"
)
@JsonSubTypes({
@Type(value = Kingdom.class, name = "K"),
@Type(value = NullKingdom.class, name = "NK"),
})
public interface KingdomI {
	public String getKingdom();
	public KingdomI getInstance();
	
	public int hashCode();
	public boolean equals(Object obj);
	
}
