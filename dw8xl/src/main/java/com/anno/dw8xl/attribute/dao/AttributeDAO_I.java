package com.anno.dw8xl.attribute.dao;

import java.util.List;

import com.anno.dw8xl.attribute.model.AttributeI;

public interface AttributeDAO_I {
	public List<AttributeI> getAllAttributes();
	public List<AttributeI> getNormalAttributes();
	public List<AttributeI> getSpecialAttributes();
	public AttributeI getAttributeByName(String name);
	
	public void createAttribute(AttributeI attribute);
	public void removeAttribute(AttributeI attribute);
	public void updateAttribute(AttributeI old, AttributeI attribute);
}
