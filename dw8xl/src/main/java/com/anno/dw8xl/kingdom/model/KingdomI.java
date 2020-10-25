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
property = "Kingdom-Type"
)
@JsonSubTypes({
@Type(value = Kingdom.class, name = "Kingdom"),
@Type(value = NullKingdom.class, name = "NULL-Kingdom"),
})
public interface KingdomI {
	public String getName();
	public int hashCode();
	public boolean equals(Object obj);
	public String toString();
	
}
