/**
 * 
 */
package com.anno.dw8xl.type.model;

import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.shared.TypeDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Haku Wei
 *
 */
@JsonDeserialize(using = TypeDeserializer.class)
@JsonSubTypes({ 
	@com.fasterxml.jackson.annotation.JsonSubTypes.Type(value = Type.class, name = "Type"),
	@com.fasterxml.jackson.annotation.JsonSubTypes.Type(value = NullType.class, name = "NullType")
})
public interface TypeI {
	@JsonIgnore
	public String getName();

	public void setCategory(CategoryI category);
	
	public CategoryI getCategory();

	@Override
	public boolean equals(Object obj);

	@Override
	public int hashCode();

	@Override
	public String toString();
}
