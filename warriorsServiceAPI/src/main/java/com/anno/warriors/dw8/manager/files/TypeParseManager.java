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
import com.anno.warriors.dw8.manager.MappingObjectsWithReference;
import com.anno.warriors.dw8.shared.DW8Constants;
import com.anno.warriors.dw8.shared.DW8StaticObjects;

@SuppressWarnings("unused")
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
		MappingObjectsWithReference<Category, List<Types>, Types> typesMappingObject = new MappingObjectsWithReference<>(
				categoryTypesMap);
		try (Scanner z = new Scanner(new FileReader(new File(DW8StaticObjects.getWeaponTypePath())))) {
			String line = DW8Constants.Split.EMPTY.getValue();
			String[] arr;
			while (z.hasNextLine()) {
				line = z.nextLine();
				arr = line.split(DW8Constants.Split.COMMA.getValue());
				category = Category.returnCorrectEnum(arr[0].trim());
				type = Types.returnCorrectEnum(arr[1].trim());
				types.add(type);
				typesMappingObject.mapKeyValueWithList(category, type);
			}
			logger.info("Mapped Types from " + DW8StaticObjects.getWeaponTypePath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String formattedTypeEnumName(String s) {
		if (!s.contains(DW8Constants.Split.WHITE_SPACE.getValue())) {
			return s.toUpperCase();
		}
		String[] temp = s.split(DW8Constants.Split.WHITE_SPACE.getValue());
		StringBuilder formated = new StringBuilder();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].contains(DW8Constants.Split.AMPERSAND.getValue())) {
				temp[i] = temp[i].trim().replace(DW8Constants.Split.AMPERSAND.getValue(),
						DW8Constants.Split.EMPTY.getValue());
			}
			if (temp[i].contains(DW8Constants.Split.APOSTROPHE.getValue())) {
				temp[i] = temp[i].trim().replace(DW8Constants.Split.APOSTROPHE.getValue(),
						DW8Constants.Split.EMPTY.getValue());
			}
			if (temp[i].contains(DW8Constants.Split.AMPERSAND.getValue())) {
				temp[i] = temp[i].trim().replace(DW8Constants.Split.HYPHEN.getValue(),
						DW8Constants.Split.UNDER_SCORE.getValue());
			}
			if (!temp[i].isEmpty()) {
				formated.append(temp[i].trim() + DW8Constants.Split.UNDER_SCORE.getValue());
			}
		}
		return formated.substring(0, formated.length() - 1).toUpperCase();

	}

}