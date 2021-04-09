package com.anno.warriors.dw8.manager.characters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.anno.warriors.dw8.characters.CharacterInterface;
import com.anno.warriors.dw8.characters.Officer;
import com.anno.warriors.dw8.characters.SubOfficer;
import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.manager.DW8MappingObjects;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.shared.DW8StaticObjects;

public class DW8CharacterParseManager implements DynastyWarriors8Object<DW8CharacterParseManager> {

	private static DW8CharacterParseManager instance;
	private static List<DynastyWarriors8Object<CharacterInterface>> officers = new ArrayList<>();
	private static List<DynastyWarriors8Object<CharacterInterface>> subOfficers = new ArrayList<>();
	private static List<DynastyWarriors8Object<CharacterInterface>> characters = new ArrayList<>();
	private static Map<Kingdom, List<DynastyWarriors8Object<CharacterInterface>>> kingdomCharacterMap = new HashMap<>();

	public static DynastyWarriors8Object<DW8CharacterParseManager> getInstance() {
		if (instance == null) {
			synchronized (DW8CharacterParseManager.class) {
				if (instance == null) {
					return new DW8CharacterParseManager();
				}
			}
		}
		return instance;
	}

	public static void main(String... args) {
		new DW8CharacterParseManager();
	}

	private DW8CharacterParseManager() {
		/*
		 * Two Types of Characters to Parse --> Officer --> SubOfficer Each Type of
		 * Character has 5 kingdoms Officer name is unique --> May need to create a Key
		 * Constraint (optional) SubOfficer name is not unique enough --> Will need to
		 * createa Key Constraint --> Atomic Number or some other unique ID
		 * 
		 */
		parseCharacters(DW8StaticObjects.getAllOfficerPathList());
		parseCharacters(DW8StaticObjects.getAllSubOfficerPathList());
	}

	@Override
	public DW8CharacterParseManager getManagerType() {
		return this;
	}

	public static List<DynastyWarriors8Object<CharacterInterface>> getCharacters() {
		return characters;
	}

	public static List<DynastyWarriors8Object<CharacterInterface>> getOfficers() {
		return officers;
	}

	public static List<DynastyWarriors8Object<CharacterInterface>> getSubOfficers() {
		return subOfficers;
	}

	public static Map<Kingdom, List<DynastyWarriors8Object<CharacterInterface>>> getKingdomCharacterMap() {
		return kingdomCharacterMap;
	}

	private static void parseCharacters(String[] paths) {
		File file = null;
		DW8MappingObjects<Kingdom, List<DynastyWarriors8Object<CharacterInterface>>, CharacterInterface> kingdomCharacterMappingObject = new DW8MappingObjects<>(
				kingdomCharacterMap);
		if (isOfficer(paths[0])) {
			for (String s : paths) {
				file = new File(s);
				readOfficerFile(file, kingdomCharacterMappingObject);
			}
			characters.addAll(officers);
		} else {
			for (String s : paths) {
				file = new File(s);
				readSubOfficerFile(file, kingdomCharacterMappingObject);
			}
			characters.addAll(officers);
		}
	}

	private static void readOfficerFile(File file,
			DW8MappingObjects<Kingdom, List<DynastyWarriors8Object<CharacterInterface>>, CharacterInterface> kingdomCharacterMappingObject) {
		try (Scanner z = new Scanner(new FileReader(file))) {
			String line = "";
			String[] lineArr;
			while (z.hasNextLine()) {
				line = z.nextLine();
				lineArr = line.split(",");
				parseOfficer(lineArr, kingdomCharacterMappingObject);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void parseOfficer(String[] arr,
			DW8MappingObjects<Kingdom, List<DynastyWarriors8Object<CharacterInterface>>, CharacterInterface> kingdomCharacterMappingObject) {
		CharacterInterface officer;
		Kingdom kingdom = Kingdom.returnCorrectEnum(arr[1].trim());
		// Instantiate and init officer Object with correct fields from lineArr
		officer = new Officer(arr[0].trim(), kingdom, arr[2].trim());
		// Create a List of All Officers
		officers.add(officer);
//		Create Map Kingdom-List<Officer> Key-Value
		kingdomCharacterMappingObject.mapKeyValueWithList(kingdom, officer);
	}

	private static void readSubOfficerFile(File file,
			DW8MappingObjects<Kingdom, List<DynastyWarriors8Object<CharacterInterface>>, CharacterInterface> kingdomCharacterMappingObject) {
		try (Scanner z = new Scanner(new FileReader(file))) {
			String line = "";
			String[] lineArr;
			while (z.hasNextLine()) {
				line = z.nextLine();
				lineArr = line.split(",");
				parseSubOfficer(lineArr, getKingdomFromFileName(file.getName()), kingdomCharacterMappingObject);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void parseSubOfficer(String[] arr, Kingdom kingdom,
			DW8MappingObjects<Kingdom, List<DynastyWarriors8Object<CharacterInterface>>, CharacterInterface> kingdomCharacterMappingObject) {
		CharacterInterface subOfficer;
		// Instantiate and init officer Object with correct fields from lineArr
		subOfficer = new SubOfficer(arr[0].trim(), kingdom);
		// Create a List of All Officers
		subOfficers.add(subOfficer);
//		Create Map Kingdom-List<Officer> Key-Value
		kingdomCharacterMappingObject.mapKeyValueWithList(kingdom, subOfficer);
	}

	private static boolean isOfficer(String path) {
		String[] splitByForwardSlash = path.split("/");
		for (int i = 0; i < splitByForwardSlash.length; i++) {
			if (splitByForwardSlash[i].equalsIgnoreCase("Officer")) {
				return true;
			}
		}
		return false;
	}

	private static Kingdom getKingdomFromFileName(String name) {
//		  File format --> Officer-List-[kingdom].txt 
//		  --> Extract and return [kingdom] value
		String[] splitByDash = name.split("-");
		String[] splitByPeriod = splitByDash[2].split("\\.");
		return Kingdom.returnCorrectEnum(splitByPeriod[0]);
	}
}
