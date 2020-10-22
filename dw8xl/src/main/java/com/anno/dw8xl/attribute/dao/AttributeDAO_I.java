package com.anno.dw8xl.attribute.dao;

import java.util.List;

import com.anno.dw8xl.attribute.model.AttributeI;

public interface AttributeDAO_I {
	
	public List<AttributeI> executeGetAllAttributes();
	public List<AttributeI> executeGetNormalAttributes();
	public List<AttributeI> executeGetSpecialAttributes();
	public AttributeI executeGetAttributeByName(String name);
	
	public AttributeI executeCreateAttribute(AttributeI attribute);
	public List<AttributeI> executeRemoveAttribute(List<AttributeI> attribute);
	public List<AttributeI> executeUpdateAttributes(List<AttributeI> old, List<AttributeI> attribute);
}
