package com.anno.warriors.dw8.attributes.dao;

import java.util.List;

import com.anno.warriors.dw8.attributes.model.AttributeInterface;

public interface AttributesDAOInterface {

	public List<AttributeInterface> getAllAttributes();

	public List<AttributeInterface> getNormalAttributes();

	public List<AttributeInterface> getSpecialAttributes();

	public List<AttributeInterface> getNormalAttributesByNames(String...names);

	public List<AttributeInterface> getSpecialAttributesByNames(String...names);
}
