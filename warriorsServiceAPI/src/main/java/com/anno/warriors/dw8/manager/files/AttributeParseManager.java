package com.anno.warriors.dw8.manager.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.anno.warriors.dw8.enums.attribute.AttributeInterface;
import com.anno.warriors.dw8.enums.attribute.NormalAttributes;
import com.anno.warriors.dw8.enums.attribute.SpecialAttributes;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.manager.MappingObjects;
import com.anno.warriors.dw8.shared.DW8StaticObjects;

public class AttributeParseManager implements DynastyWarriors8Object<AttributeParseManager> {

	private static DynastyWarriors8Object<AttributeParseManager> instance;
	private static List<AttributeInterface> attributes = new ArrayList<>();
	private static List<AttributeInterface> normalAttributes = new ArrayList<>();
	private static List<AttributeInterface> specialAttributes = new ArrayList<>();
	private static Map<String, List<DynastyWarriors8Object<AttributeInterface>>> mappedListAttributes = new HashMap<>();

	public static DynastyWarriors8Object<AttributeParseManager> getInstance() {
		if (instance == null) {
			synchronized (ParsingFiles.class) {
				if (instance == null) {
					return new AttributeParseManager();
				}
			}
		}
		return instance;
	}

	private AttributeParseManager() {
		parseAttribute(DW8StaticObjects.getNormalAttributePath());
		parseAttribute(DW8StaticObjects.getSpecialAttributePath());
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

	public static Map<String, List<DynastyWarriors8Object<AttributeInterface>>> getMappedListAttributes() {
		return mappedListAttributes;
	}

	@Override
	public AttributeParseManager getManagerType() {
		return this;
	}

	private static void parseAttribute(String path) {
		File file = new File(path);
		MappingObjects<String, List<DynastyWarriors8Object<AttributeInterface>>, AttributeInterface> attributeListMappingObject = new MappingObjects<>(
				mappedListAttributes);
		if (isNormalAttribute(file.getName())) {
			try (Scanner z = new Scanner(new FileReader(file))) {
				String line = "";
				String[] arr;
				while (z.hasNextLine()) {
					line = z.nextLine();
					arr = line.split(",");
					parseNormalAttributes(arr, attributeListMappingObject);
				}
				attributes.addAll(normalAttributes);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			try (Scanner z = new Scanner(new FileReader(file))) {
				String line = "";
				String[] arr;
				while (z.hasNextLine()) {
					line = z.nextLine();
					arr = line.split(",");
					parseSpecialAttributes(arr, attributeListMappingObject);
				}
				attributes.addAll(specialAttributes);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private static void parseNormalAttributes(String[] arr,
			MappingObjects<String, List<DynastyWarriors8Object<AttributeInterface>>, AttributeInterface> attributeListMappingObject) {
		AttributeInterface attribute = NormalAttributes.returnCorrectEnum(arr[0].trim()), arr[1].trim();
//		attribute.setDescription(arr[1].trim());
		normalAttributes.add(attribute);
		attributeListMappingObject.mapKeyValueWithList(attribute.getType(), attribute);
	}

	private static void parseSpecialAttributes(String[] arr,
			MappingObjects<String, List<DynastyWarriors8Object<AttributeInterface>>, AttributeInterface> attributeListMappingObject) {
		AttributeInterface attribute;
		attribute = SpecialAttributes.returnCorrectEnum(arr[0].trim());
		attribute.setDescription(arr[1].trim());
		specialAttributes.add(attribute);
		attributeListMappingObject.mapKeyValueWithList(attribute.getType(), attribute);
	}

	private static boolean isNormalAttribute(String fileName) {
		String[] splitByPeriod = fileName.split("\\.");
		return (splitByPeriod[0].equalsIgnoreCase("normal"));
	}

}
