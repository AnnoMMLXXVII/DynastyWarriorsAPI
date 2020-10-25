/**
 * 
 */
package com.anno.dw8xl.type.model;

import com.anno.dw8xl.category.model.CategoryI;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;


/**
 * @author Haku Wei
 *
 */
@JsonTypeInfo(
use = JsonTypeInfo.Id.NAME, 
include = As.PROPERTY, 
property = "TypeI-Type"
)
@JsonSubTypes({
@com.fasterxml.jackson.annotation.JsonSubTypes.Type(value = Type.class, name = "Type"),
@com.fasterxml.jackson.annotation.JsonSubTypes.Type(value = NullType.class, name = "NullType"),
})
public interface TypeI {
	public void setCategory(CategoryI category);
	public String getName();
	public CategoryI getCategory();
	public boolean equals(Object obj);
	public int hashCode();
	public String toString();
}
