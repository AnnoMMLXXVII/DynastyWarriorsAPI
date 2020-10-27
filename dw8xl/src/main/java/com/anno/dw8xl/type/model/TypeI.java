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
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE, include = As.PROPERTY)
@JsonSubTypes({ @com.fasterxml.jackson.annotation.JsonSubTypes.Type(value = Type.class, name = "Type"),
		@com.fasterxml.jackson.annotation.JsonSubTypes.Type(value = NullType.class, name = "NullType"), })
public interface TypeI {

	public String getName();

	public void setCategory(CategoryI category);

	public String getCategory();

	@Override
	public boolean equals(Object obj);

	@Override
	public int hashCode();

	@Override
	public String toString();
}
