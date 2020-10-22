/**
 * 
 */
package com.anno.dw8xl.attribute.facade;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.dw8xl.attribute.dao.AttributeDAO_I;
import com.anno.dw8xl.attribute.model.AttributeI;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Service
public class AttributeFacade implements AttributeFacade_I {
	private static final Logger log = LoggerFactory.getLogger(AttributeFacade.class);
	@Autowired
	private AttributeDAO_I dao;
	
	public List<AttributeI> getAllAttributes() {
		return dao.executeGetAllAttributes();
	}
	public List<AttributeI> getNormalAttributes() {
		return dao.executeGetNormalAttributes();
	}
	public List<AttributeI> getSpecialAttributes() {
		return dao.executeGetSpecialAttributes();
	}
	public AttributeI getAttributeByName(String name) {
		if(name.equals("")) {
			log.debug("Attribute name is Empty!");
			return null;
		}
		String temp = (name.substring(0, 1).toUpperCase() + name.substring(1)).trim();
		return dao.executeGetAttributeByName(temp);
	}
	
	public AttributeI createAttribute(AttributeI attribute) {
		isValidAttribute(attribute);
		if(getAttributeByName(attribute.getName()) != null) {
			log.debug("Cannot create new Attribute due to already-existing Attribute");
//			throw new IllegalArgumentException("Cannot create new Attribute due to already-existing Attribute");
			return null;
		}
		return dao.executeCreateAttribute(attribute);
	}
	public List<AttributeI> removeAttribute(List<AttributeI> attribute) {
		if(attribute.isEmpty()) {
			return new ArrayList<>();						
		}
		return dao.executeRemoveAttribute(attribute); 
	}
	public List<AttributeI> updateAttributes(List<AttributeI> attribute, String...name) {
		List<AttributeI> old = new ArrayList<>();
		AttributeI temp = null;
		for(String s : name) {
			temp = dao.executeGetAttributeByName(s);
			if(temp != null) {
				old.add(temp);
			}
		}
		old.stream().forEach(e-> System.out.println(e.toString()));
		attribute.forEach(e -> isValidAttribute(e));
		return dao.executeUpdateAttributes(old, attribute);
	}
	
//	private boolean isExist(String name) {
//		boolean flag = true;
//		return getAttributeByName(name) != null ? flag : !flag;
//	}
	
	private boolean isValidAttribute(AttributeI attribute) {
		if(attribute == null) {
			log.debug("Attribute instance: Null");
			throw new NullPointerException("Attribute is Null!");
		}
		else if(attribute.getName().equals("") || attribute.getDescription().equals("")) {
			log.debug("Attribute Name or Description error: Empty");
			throw new IllegalArgumentException("Attribute Name or Description is Empty");
		} 
		return false;
	}

}
