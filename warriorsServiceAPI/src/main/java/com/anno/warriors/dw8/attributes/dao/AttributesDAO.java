package com.anno.warriors.dw8.attributes.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.anno.warriors.dw8.attributes.model.Attribute;
import com.anno.warriors.dw8.attributes.model.AttributeInterface;
import com.anno.warriors.dw8.enums.attribute.NormalAttributes;
import com.anno.warriors.dw8.enums.attribute.SpecialAttributes;

@Repository
public class AttributesDAO implements AttributesDAOInterface {

	private List<AttributeInterface> attributes;

	@Override
	public List<AttributeInterface> getAllAttributes() {
		attributes = new ArrayList<>();
		addNormalAttributesToAttributesList();
		addSpecialAttributesToAttributesList();
		return attributes;
	}

	@Override
	public List<AttributeInterface> getNormalAttributes() {
		attributes = new ArrayList<>();
		addNormalAttributesToAttributesList();
		return attributes;
	}

	@Override
	public List<AttributeInterface> getSpecialAttributes() {
		attributes = new ArrayList<>();
		addSpecialAttributesToAttributesList();
		return attributes;
	}

	@Override
	public List<AttributeInterface> getNormalAttributesByNames(String... names) {
		List<AttributeInterface> local = new ArrayList<>();
		attributes = getNormalAttributes();
		AttributeInterface attribute = null;
		for (String s : names) {
			attribute = attributes.stream().filter(e -> e.getName().equalsIgnoreCase(s)).findFirst().get();
			local.add(attribute);
		}
		return local;
	}

	@Override
	public List<AttributeInterface> getSpecialAttributesByNames(String... names) {
		List<AttributeInterface> local = new ArrayList<>();
		attributes = getSpecialAttributes();
		AttributeInterface attribute = null;
		for (String s : names) {
			attribute = attributes.stream().filter(e -> e.getName().equalsIgnoreCase(s)).findFirst().get();
			local.add(attribute);
		}
		return local;
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

}
