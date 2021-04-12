package com.anno.warriors.dw8.manager.files;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.warriors.dw8.enums.attribute.AttributeInterface;
import com.anno.warriors.dw8.enums.attribute.NormalAttributes;
import com.anno.warriors.dw8.enums.attribute.SpecialAttributes;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.manager.MappingObjects;

public class AttributeParseManager implements DynastyWarriors8Object<AttributeParseManager> {

	private static Logger logger = LoggerFactory.getLogger(AttributeParseManager.class);
	private static DynastyWarriors8Object<AttributeParseManager> instance;
	private static List<AttributeInterface> attributes = new ArrayList<>();
	private static List<AttributeInterface> normalAttributes = new ArrayList<>();
	private static List<AttributeInterface> specialAttributes = new ArrayList<>();
	private static Map<String, List<AttributeInterface>> mappedListAttributes = new HashMap<>();

	public static DynastyWarriors8Object<AttributeParseManager> getInstance() {
		if (instance == null) {
			synchronized (AttributeParseManager.class) {
				if (instance == null) {
					logger.info("AttributeParseManager instantiated");
					return new AttributeParseManager();
				}
			}
		}
		return instance;
	}

	private AttributeParseManager() {
		initializeListsAndMaps();
		logger.info("Finished initializing Attributes to List and Maps");
	}

	public static List<AttributeInterface> getAttributes() {
		return attributes;
	}

	public static List<AttributeInterface> getNormalAttributes() {
		return normalAttributes;
	}

	public static List<AttributeInterface> getSpecialAttributes() {
		return specialAttributes;
	}

	public static Map<String, List<AttributeInterface>> getMappedListAttributes() {
		return mappedListAttributes;
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
	}

	private static void initializeListsAndMaps() {
		MappingObjects<String, List<AttributeInterface>, AttributeInterface> attributeListMappingObject = new MappingObjects<>(
				mappedListAttributes);
		for (NormalAttributes a : NormalAttributes.values()) {
			normalAttributes.add(a);
			attributes.add(a);
			attributeListMappingObject.mapKeyValueWithList(a.getType(), a);
		}

		for (SpecialAttributes a : SpecialAttributes.values()) {
			specialAttributes.add(a);
			attributes.add(a);
			attributeListMappingObject.mapKeyValueWithList(a.getType(), a);
		}

	}

}
