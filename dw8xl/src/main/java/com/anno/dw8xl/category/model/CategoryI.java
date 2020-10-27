package com.anno.dw8xl.category.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * @author venividivicihofneondeion010101
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE, include = As.PROPERTY)
@JsonSubTypes({ @Type(value = Category.class, name = "Category"), @Type(value = NullCategory.class, name = "Null"), })
public interface CategoryI {
	public String getName();

	@Override
	public int hashCode();

	@Override
	public boolean equals(Object obj);

	@Override
	public String toString();
}
