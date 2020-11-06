package com.anno.dw8xl.length.model;

import com.anno.dw8xl.shared.LengthDeserializer;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = LengthDeserializer.class)
@JsonSubTypes({ 
	@Type(value = Length.class, name = "Length")
})
public interface LengthI {
	
	void setSize(String size);
	String getSize();
	
	@Override 
	int hashCode();
	@Override
	boolean equals(Object obj);
	
}
