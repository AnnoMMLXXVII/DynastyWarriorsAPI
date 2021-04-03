package com.anno.dw8xl.affinity.model;

import com.anno.dw8xl.shared.AffinityDeserializer;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = AffinityDeserializer.class)
@JsonSubTypes({ 
	@Type(value = Affinity.class, name = "Affinity")
})
public interface AffinityI {
	public String getName();

	@Override
	public int hashCode();

	@Override
	public boolean equals(Object obj);

}
