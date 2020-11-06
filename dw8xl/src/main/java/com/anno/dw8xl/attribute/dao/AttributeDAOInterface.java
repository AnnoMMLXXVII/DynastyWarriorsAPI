package com.anno.dw8xl.attribute.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.dw8xl.attribute.model.AttributeI;
import com.anno.dw8xl.attribute.model.NullAttribute;
import com.anno.dw8xl.dao.DataAccessObjectInterface;

public interface AttributeDAOInterface extends DataAccessObjectInterface<AttributeI, Object> {

	public List<AttributeI> executeGetAllAttributes();

	public List<AttributeI> executeGetNormalAttributes();

	public List<AttributeI> executeGetSpecialAttributes();

	public AttributeI executeGetAttributeByName(String name);

	public AttributeI executeCreateAttribute(AttributeI attribute);

	public List<AttributeI> executeRemoveAttribute(List<AttributeI> attribute);

	public List<AttributeI> executeUpdateAttributes(List<AttributeI> old, List<AttributeI> attribute);

	public static final Logger log = LoggerFactory.getLogger(AttributeDAO.class);

	static boolean isValidToAdd(AttributeI entity) {
		if (entity == null) {
			log.info("Cannot add Attribute due to Null Exception...");
			throw new NullPointerException("Attribute cannot be added due to Null!");
		}
		if (entity instanceof NullAttribute || entity.getName().equals("")) {
			log.info("Cannot add Attribute due to Null Or Empty Rarity...");
			return false;
		}
		return true;
	}

	static boolean isValidToRemove(AttributeI entity) {
		if (entity == null) {
			log.info("Cannot remove Attribute due to Null Exception...");
			throw new NullPointerException("Attribute cannot be removed due to Null!");
		}
		if (entity instanceof NullAttribute || entity.getName().equals("")) {
			log.info("Cannot remove Attribute due to Null Attribute Object Or Empty request [name]...");
			return false;
		}
		return true;
	}
}
