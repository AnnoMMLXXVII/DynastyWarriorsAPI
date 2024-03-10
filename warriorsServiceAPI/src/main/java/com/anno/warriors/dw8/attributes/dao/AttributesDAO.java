package com.anno.warriors.dw8.attributes.dao;

import static com.anno.warriors.dw8.database.DatabaseDYNConstants.TABLES.ATTRIBUTES;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Repository;

import com.anno.warriors.dw8.attributes.model.Attribute;
import com.anno.warriors.dw8.attributes.model.AttributeInterface;
import com.anno.warriors.dw8.database.DYNDatabaseLibrary;
import com.anno.warriors.dw8.database.DatabaseDYNConstants;
import com.anno.warriors.dw8.database.DatabaseDYNConstants.COLUMNS;
import com.anno.warriors.dw8.enums.attribute.NormalAttributes;
import com.anno.warriors.dw8.enums.attribute.SpecialAttributes;

@Repository
public class AttributesDAO implements AttributesDAOInterface {

	private Logger logger = LogManager.getLogger();
	private List<AttributeInterface> attributes;

	@Override
	public List<AttributeInterface> getAllAttributes() {
		clearAttributes();
		ResultSet rs = DYNDatabaseLibrary.executeSelectAll(ATTRIBUTES);
		return convertToPojoAndGetList(rs);
	}

	@Override
	public List<AttributeInterface> getAttributeByType(String type) {
		final String TYPE = type.equalsIgnoreCase(DatabaseDYNConstants.NORMAL) ? DatabaseDYNConstants.NORMAL : DatabaseDYNConstants.SPECIAL;
		clearAttributes();
		ResultSet rs = DYNDatabaseLibrary.executeSelectAllWhere(ATTRIBUTES, COLUMNS.ATTRTYPE, TYPE);
		return convertToPojoAndGetList(rs);
	}

	@Override
	public AttributeInterface getAttributeByName(String name) {
		clearAttributes();
		if (name == null || name.isEmpty()) {
			return null;
		}
		ResultSet rs = DYNDatabaseLibrary.executeSelectAllWhere(ATTRIBUTES, COLUMNS.ATTRNAME, name);
		try {
			rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return convertToPojo(rs);
	}

	@Override
	public List<AttributeInterface> getAttributesByName(String... name) {
		clearAttributes();
		if (name == null || name.length <= 0) {
			return attributes;
		}
		ResultSet rs = DYNDatabaseLibrary.executeSelectAllWhere(ATTRIBUTES, COLUMNS.ATTRNAME, name);
		return convertToPojoAndGetList(rs);
	}

	@Override
	public List<AttributeInterface> getAttributeByContainedDescription(String description) {
		clearAttributes();
		if (description == null || StringUtils.isBlank(description)) {
			return attributes;
		}
		ResultSet rs = DYNDatabaseLibrary.executeSelectAllWhereLike(ATTRIBUTES, COLUMNS.ATTRDESC, description);
		return convertToPojoAndGetList(rs);
	}

	@Override
	public AttributeInterface updateAttribute(AttributeInterface object) {
		if (object == null) {
			logger.info("Object was null");
			// Return an object that indicates to the user the update did not happen
			return Optional.of(object).orElse(new Attribute());
		}
		final String key = object.getName();
		AttributeInterface tempObject = getAttributeByName(key); // retrieve object first from DB
		if (tempObject == null) {
			logger.info("No Attribute was found");
			return Optional.of(tempObject).orElse(new Attribute());
		}
		Map<COLUMNS, String> colValMap = new HashMap<>();
		colValMap.put(COLUMNS.ATTRDESC, object.getDescription());
		colValMap.put(COLUMNS.ATTRTYPE, object.getType());
		if (tempObject.equals(object)) {
			logger.info("No change was detected");
			return Optional.of(object).orElse(new Attribute());
		}
		if (tempObject.getDescription().equalsIgnoreCase(object.getDescription())) {
			colValMap.remove(COLUMNS.ATTRDESC);
		}
		if (tempObject.getType().equalsIgnoreCase(object.getType())) {
			colValMap.remove(COLUMNS.ATTRTYPE);
		}
		boolean isUpdated = DYNDatabaseLibrary.executeUpdate(ATTRIBUTES, COLUMNS.ATTRNAME, key,
				colValMap.keySet().toArray(), colValMap.values().toArray());
		if (isUpdated) {
			return getAttributeByName(object.getName());
		}
		return Optional.of(object).orElse(new Attribute());
	}

	private void addNormalAttributesToAttributesList() {
		for (NormalAttributes a : NormalAttributes.values()) {
			attributes.add(new Attribute(a.getName(), a.getDescription(), a.getType()));
		}
	}

	private void addSpecialAttributesToAttributesList() {
		for (SpecialAttributes a : SpecialAttributes.values()) {
			attributes.add(new Attribute(a.getName(), a.getDescription(), a.getType()));
		}
	}

	private List<AttributeInterface> convertToPojoAndGetList(ResultSet rs) {
		clearAttributes();
		List<AttributeInterface> temp = new ArrayList<>();
		if (rs != null) {
			try {
				while (rs.next()) {
					AttributeInterface t = convertToPojo(rs);
					if (t != null) {
						temp.add(t);
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return temp;
	}

	private AttributeInterface convertToPojo(ResultSet rs) {
		try {
			String name = rs.getString(COLUMNS.ATTRNAME.getColumn());
			String desc = rs.getString(COLUMNS.ATTRDESC.getColumn());
			String type = rs.getString(COLUMNS.ATTRTYPE.getColumn());
			return new Attribute(name, desc, type);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private void clearAttributes() {
		if (attributes != null && !attributes.isEmpty()) {
			attributes.clear();
		} else {
			attributes = new ArrayList<>();
		}
	}

}
