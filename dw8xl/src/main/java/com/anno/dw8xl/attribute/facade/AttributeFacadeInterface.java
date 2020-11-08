/**
 * 
 */
package com.anno.dw8xl.attribute.facade;

import java.util.Collection;
import java.util.List;

import com.anno.dw8xl.attribute.model.AttributeI;

/**
 * @author venividivicihofneondeion010101
 *
 */
public interface AttributeFacadeInterface {

	public Collection<AttributeI> getAllAttributes();

	public Collection<AttributeI> getNormalAttributes();

	public Collection<AttributeI> getSpecialAttributes();

	public AttributeI getAttributeByName(String name);

	public AttributeI createAttribute(AttributeI attribute);

	public Collection<AttributeI> removeAttribute(List<AttributeI> attribute);
	
	public Collection<AttributeI> getInValid();

	public Collection<AttributeI> updateAttributes(List<AttributeI> attribute, String... name);

}
