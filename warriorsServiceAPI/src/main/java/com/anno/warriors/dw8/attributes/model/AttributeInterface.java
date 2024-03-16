package com.anno.warriors.dw8.attributes.model;

import com.anno.warriors.dw8.deserializer.AttributeDeserializer;
import com.anno.warriors.dw8.enums.DW8Enumeration;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
@JsonDeserialize(using = AttributeDeserializer.class)
public interface AttributeInterface extends DW8Enumeration<AttributeInterface> {

	abstract String getType();

	abstract String getName();

	abstract String getDescription();

	int hashCode();

	boolean equals(Object o);

}
