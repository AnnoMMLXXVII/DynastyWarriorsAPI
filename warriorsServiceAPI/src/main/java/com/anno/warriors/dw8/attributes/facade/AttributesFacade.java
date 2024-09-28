package com.anno.warriors.dw8.attributes.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.warriors.dw8.attributes.dao.AttributesDAOInterface;
import com.anno.warriors.dw8.attributes.model.Attribute;
import com.anno.warriors.dw8.attributes.model.AttributeInterface;

@Service
public class AttributesFacade implements AttributesFacadeInterface {

	@Autowired
	private AttributesDAOInterface dao;

	@Override
	public List<AttributeInterface> callingGetAllAttributes() {
		return dao.getAllAttributes();
	}

	@Override
	public List<AttributeInterface> callingGetAllAttributes(String type) {
		if (StringUtils.isBlank(type)) {
			return Optional.of(new ArrayList<AttributeInterface>()).get();
		}
		return dao.getAttributeByType(type);
	}

	@Override
	public List<AttributeInterface> callingGetAllAttributes(String... name) {
		if (name == null || name.length == 0) {
			return Optional.of(new ArrayList<AttributeInterface>()).get();
		}
		return dao.getAttributesByName(name);
	}

	@Override
	public AttributeInterface callingGetAllAttribute(String name) {
		if (StringUtils.isBlank(name)) {
			// Update Return Object to be More Generic
			return Optional.ofNullable(new Attribute()).get();
		}
		return dao.getAttributeByName(name);
	}

	@Override
	public AttributeInterface callingCreateAttribute(AttributeInterface attribute) {
		if (attribute == null) {
			// Update Return Object to be More Generic
			return Optional.ofNullable(new Attribute()).get();
		}
		return dao.createAttribute(attribute);
	}

	@Override
	public AttributeInterface callingUpdateAttribute(String key, AttributeInterface attribute) {
		if (attribute == null || (!key.equalsIgnoreCase(attribute.getName()))) {
			// Update Return Object to be More Generic
			return Optional.ofNullable(new Attribute()).get();
		}
		return dao.updateAttribute(attribute);
	}

	@Override
	public AttributeInterface callingRemoveAttribute(String key) {
		if (key == null) {
			return Optional.ofNullable(new Attribute()).get();
		}
		return dao.removeAttribute(key);
	}

}
