package com.anno.warriors.dw8.attributes.facade;

import java.util.List;

import com.anno.warriors.dw8.attributes.model.AttributeInterface;

public interface AttributesFacadeInterface {

	public List<AttributeInterface> callingGetAllAttributes();

	public AttributeInterface callingGetAllAttribute(String name);

	public List<AttributeInterface> callingGetAllAttributes(String type);

	public List<AttributeInterface> callingGetAllAttributes(String... name);

	public AttributeInterface callingUpdateAttribute(String key, AttributeInterface attribute);
	
	public AttributeInterface callingRemoveAttribute(String key);

	public AttributeInterface callingCreateAttribute(AttributeInterface attribute);

}
