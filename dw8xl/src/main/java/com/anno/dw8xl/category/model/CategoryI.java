package com.anno.dw8xl.category.model;

import com.anno.dw8xl.shared.CategoryDeserializer;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author venividivicihofneondeion010101
 *
 */
@JsonDeserialize(using = CategoryDeserializer.class)
@JsonSubTypes({ 
	@Type(value = Category.class, name = "Category"), 
	@Type(value = NullCategory.class, name = "null"), 
})
public interface CategoryI {
	public String getName();

	@Override
	public int hashCode();

	@Override
	public boolean equals(Object obj);

	@Override
	public String toString();
}
