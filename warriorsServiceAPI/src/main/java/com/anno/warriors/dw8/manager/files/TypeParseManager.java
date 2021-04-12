package com.anno.warriors.dw8.manager.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.warriors.dw8.enums.category.Category;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.manager.MappingObjects;
import com.anno.warriors.dw8.shared.DW8StaticObjects;

public class TypeParseManager implements DynastyWarriors8Object<TypeParseManager> {

	private static Logger logger = LoggerFactory.getLogger(TypeParseManager.class);

	private static DynastyWarriors8Object<TypeParseManager> instance;
	private static List<Types> types = new ArrayList<>();
	private static Map<Category, List<Types>> categoryTypesMap = new HashMap<>();

	public static DynastyWarriors8Object<TypeParseManager> getInstance() {
		if (instance == null) {
			synchronized (TypeParseManager.class) {
				if (instance == null) {
					logger.info("TypeParseManager instantiated");
					return new TypeParseManager();
				}
			}
		}
		return instance;
	}

	private TypeParseManager() {
		readFileAndMap();
		logger.info("Finished Type File and Mapping");
	}

	public static List<Types> getTypes() {
		return types;
	}

	public static Map<Category, List<Types>> getMappedTypes() {
		return categoryTypesMap;
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
	}

	private static void readFileAndMap() {
		Category category;
		Types type;
		MappingObjects<Category, List<Types>, Types> typesMappingObject = new MappingObjects<>(categoryTypesMap);
		try (Scanner z = new Scanner(new FileReader(new File(DW8StaticObjects.getWeaponTypePath())))) {
			String line = "";
			String[] arr;
			while (z.hasNextLine()) {
				line = z.nextLine();
				arr = line.split(",");
				category = Category.returnCorrectEnum(arr[0].trim());
				String temp = formattedTypeEnumName(arr[1].trim());
				type = Types.returnCorrectEnum(temp);
				types.add(type);
				typesMappingObject.mapKeyValueWithList(category, type);
			}
			logger.info("Mapped Types from " + DW8StaticObjects.getWeaponTypePath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String formattedTypeEnumName(String s) {
		if (!s.contains(" ")) {
			return s.toUpperCase();
		}
		String[] temp = s.split(" ");
		StringBuilder formated = new StringBuilder();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].contains("&")) {
				temp[i] = temp[i].trim().replace("&", "");
			}
			if (temp[i].contains("\'")) {
				temp[i] = temp[i].trim().replace("\'", "");
			}
			if (temp[i].contains("-")) {
				temp[i] = temp[i].trim().replace("-", "_");
			}
			if (!temp[i].isEmpty()) {
				formated.append(temp[i].trim() + "_");
			}
		}
		return formated.substring(0, formated.length() - 1).toUpperCase();

	}

}