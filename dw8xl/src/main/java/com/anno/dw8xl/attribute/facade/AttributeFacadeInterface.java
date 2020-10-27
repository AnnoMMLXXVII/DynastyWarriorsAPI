/**
 * 
 */
package com.anno.dw8xl.attribute.facade;

import java.util.List;

import com.anno.dw8xl.attribute.model.AttributeI;

/**
 * @author venividivicihofneondeion010101
 *
 */
public interface AttributeFacadeInterface {

	public List<AttributeI> getAllAttributes();

	public List<AttributeI> getNormalAttributes();

	public List<AttributeI> getSpecialAttributes();

	public AttributeI getAttributeByName(String name);

	public AttributeI createAttribute(AttributeI attribute);

	public List<AttributeI> removeAttribute(List<AttributeI> attribute);

	public List<AttributeI> updateAttributes(List<AttributeI> attribute, String... name);

}
