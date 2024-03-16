package com.anno.warriors.dw8.attributes.dao;

import static com.anno.warriors.dw8.database.DatabaseDYNConstants.TABLES.ATTRIBUTES;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Repository;

import com.anno.warriors.dw8.attributes.model.Attribute;
import com.anno.warriors.dw8.attributes.model.AttributeInterface;
import com.anno.warriors.dw8.database.DYNDatabaseLibrary;
import com.anno.warriors.dw8.database.DatabaseDYNConstants;
import com.anno.warriors.dw8.database.DatabaseDYNConstants.COLUMNS;
import com.anno.warriors.dw8.database.MissingValueException;
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
		final String TYPE = type.equalsIgnoreCase(DatabaseDYNConstants.NORMAL) ? DatabaseDYNConstants.NORMAL
				: DatabaseDYNConstants.SPECIAL;
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
		AttributeInterface attribute = null;
		try {
			while (rs.next()) {
				attribute = convertToPojo(rs);
			}
		} catch (SQLException e) {
			attribute = new Attribute();
			e.printStackTrace();
		}
		return attribute;
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
	public AttributeInterface createAttribute(AttributeInterface object) {
		if (object == null) {
			logger.info("Object was null");
			// Return an object that indicates to the user the update did not happen
			return Optional.of(object).orElse(new Attribute());
		}
		Map<COLUMNS, String> colValMap = new LinkedHashMap<>();
		colValMap.put(COLUMNS.ATTRNAME, object.getName());
		colValMap.put(COLUMNS.ATTRDESC, object.getDescription());
		colValMap.put(COLUMNS.ATTRTYPE, object.getType());
		try {
			checkIfMissingFields(colValMap);
		} catch (MissingValueException ex) {
			logger.error("{}", ex.getMessage());
			return Optional.ofNullable(object).orElse(new Attribute());
		}
		final String key = object.getName();
		AttributeInterface attribute = getAttributeByName(key); // retrieve object first from DB
		if (attribute != null) {
			logger.info("Attribute with {} already exists!", key);
			return Optional.of(attribute).orElse(new Attribute());
		}
		boolean isInserted = DYNDatabaseLibrary.executeInsert(ATTRIBUTES, convertToSimpleColumnName(colValMap.keySet()),
				colValMap.values().toArray());
		if (isInserted) {
			logger.info("Successfully Created Attribute: {}", key);
		}
		attribute = getAttributeByName(key);
		return Optional.of(attribute).orElse(new Attribute());
	}

	@Override
	public AttributeInterface updateAttribute(AttributeInterface object) {
		if (object == null) {
			logger.info("Object was null");
			// Return an object that indicates to the user the update did not happen
			return Optional.of(object).orElse(new Attribute());
		}
		final String key = object.getName();
		AttributeInterface attribute = getAttributeByName(key); // retrieve object first from DB
		if (attribute == null || attribute.equals(new Attribute())) {
			logger.info("No Attribute was found");
			return Optional.ofNullable(attribute).orElse(attribute);
		}
		Map<COLUMNS, String> colValMap = new HashMap<>();
		colValMap.put(COLUMNS.ATTRDESC, object.getDescription());
		colValMap.put(COLUMNS.ATTRTYPE, object.getType());
		if (attribute.equals(object)) {
			logger.info("No change was detected");
			return Optional.of(object).orElse(new Attribute());
		}
		if (attribute.getDescription().equalsIgnoreCase(object.getDescription())) {
			colValMap.remove(COLUMNS.ATTRDESC);
		}
		if (attribute.getType().equalsIgnoreCase(object.getType())) {
			colValMap.remove(COLUMNS.ATTRTYPE);
		}
		boolean isUpdated = DYNDatabaseLibrary.executeUpdate(ATTRIBUTES, COLUMNS.ATTRNAME, key,
				convertToSimpleColumnName(colValMap.keySet()), colValMap.values().toArray());
		if (isUpdated) {
			return getAttributeByName(object.getName());
		}
		return Optional.of(object).orElse(new Attribute());
	}

	@Override
	public AttributeInterface removeAttribute(String name) {
		if (name == null || name.isEmpty()) {
			return null;
		}
		AttributeInterface tempObject = getAttributeByName(name); // retrieve object first from DB
		if (tempObject == null) {
			logger.info("No Attribute was found to be deleted!");
			return Optional.ofNullable(tempObject).orElse(new Attribute());
		}
		Map<COLUMNS, String> colValMap = new HashMap<>();
		colValMap.put(COLUMNS.ATTRNAME, name);
		boolean isRemoved = DYNDatabaseLibrary.executeDelete(ATTRIBUTES, convertToSimpleColumnName(colValMap.keySet()),
				colValMap.values().toArray());
		if (isRemoved) {
			attributes.removeIf(e -> e.getName().trim().equalsIgnoreCase(name.trim()));
		}
		return tempObject;
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
					temp.add(convertToPojo(rs));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return temp;
	}

	private AttributeInterface convertToPojo(ResultSet rs) throws SQLException {
		String name = rs.getString(COLUMNS.ATTRNAME.getColumn());
		String desc = rs.getString(COLUMNS.ATTRDESC.getColumn());
		String type = rs.getString(COLUMNS.ATTRTYPE.getColumn());
		return new Attribute(name, desc, type);
	}

	private void clearAttributes() {
		if (attributes != null && !attributes.isEmpty()) {
			attributes.clear();
		} else {
			attributes = new ArrayList<>();
		}
	}

	private Object[] convertToSimpleColumnName(Set<COLUMNS> columns) {
		return columns.stream().map(COLUMNS::getColumn).toArray();
	}

	private void checkIfMissingFields(Map<COLUMNS, String> colValMap) throws MissingValueException {
		for (Entry<COLUMNS, String> c : colValMap.entrySet()) {
			if (c.getValue() == null || StringUtils.isBlank(c.getValue())) {
				throw new MissingValueException(c.getKey().getColumn());
			}
		}
	}

}
