package com.anno.dw8xl.category.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * @author venividivicihofneondeion010101
 *
 */
@JsonTypeInfo(
use = JsonTypeInfo.Id.NAME, 
include = As.PROPERTY, 
property = "CategoryI-Type"
)
@JsonSubTypes({
@Type(value = Category.class, name = "Category"),
@Type(value = NullCategory.class, name = "NullCategory"),
})
public interface CategoryI {
	public String getName();
	public int hashCode();
	public boolean equals(Object obj);
	public String toString();
}
