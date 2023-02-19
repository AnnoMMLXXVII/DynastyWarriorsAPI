package com.anno.warriors.dw8.attributes.dao;

import java.util.List;

import com.anno.warriors.dw8.attributes.model.AttributeInterface;

public interface AttributesDAOInterface {

	public List<AttributeInterface> getAllAttributes();

	public List<AttributeInterface> getAttributeByType(String type);

	public AttributeInterface getAttributeByName(String name);

	public List<AttributeInterface> getAttributesByName(String... name);

	public List<AttributeInterface> getAttributeByContainedDescription(String name);

	public AttributeInterface updateAttribute(AttributeInterface object);

}
