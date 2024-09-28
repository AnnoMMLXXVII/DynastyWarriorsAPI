package com.anno.warriors.dw8.manager.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.characters.model.Officer;
import com.anno.warriors.dw8.characters.model.SubOfficer;
import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.manager.MappingObjectsWithReference;
import com.anno.warriors.dw8.shared.DW8Constants;
import com.anno.warriors.dw8.shared.DW8StaticObjects;
import com.anno.warriors.dw8.utils.FileStreamHandler;
import com.anno.warriors.dw8.utils.WarriorsParingException;

public class CharacterParseManager implements DynastyWarriors8Object<CharacterParseManager> {

	private static Logger logger = LoggerFactory.getLogger(CharacterParseManager.class);

	private static DynastyWarriors8Object<CharacterParseManager> instance;
	private static List<CharacterInterface<Character>> officers = new ArrayList<>();
	private static List<CharacterInterface<Character>> subOfficers = new ArrayList<>();
	private static List<CharacterInterface<Character>> characters = new ArrayList<>();
	private static Map<Kingdom, List<CharacterInterface<Character>>> kingdomCharacterMap = new HashMap<>();

	public static DynastyWarriors8Object<CharacterParseManager> getInstance() {
		if (instance == null) {
			synchronized (CharacterParseManager.class) {
				if (instance == null) {
					logger.info("CharacterParseManager instantiated");
					return new CharacterParseManager();
				}
			}
		}
		return instance;
	}

	private CharacterParseManager() {
		/*
		 * Two Types of Characters to Parse --> Officer --> SubOfficer Each Type of
		 * Character has 5 kingdoms Officer name is unique --> May need to create a Key
		 * Constraint (optional) SubOfficer name is not unique enough --> Will need to
		 * createa Key Constraint --> Atomic Number or some other unique ID
		 * 
		 */
		parseCharacters(DW8StaticObjects.getAllOfficerPathList());
		parseCharacters(DW8StaticObjects.getAllSubOfficerPathList());
		logger.info("Finished parsing all Characters");
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
	}

	public static List<CharacterInterface<Character>> getCharacters() {
		return characters;
	}

	public static List<CharacterInterface<Character>> getOfficers() {
		return officers;
	}

	public static List<CharacterInterface<Character>> getSubOfficers() {
		return subOfficers;
	}

	public static Map<Kingdom, List<CharacterInterface<Character>>> getKingdomCharacterMap() {
		return kingdomCharacterMap;
	}

	private static void parseCharacters(String[] paths) {
		File file = null;
		MappingObjectsWithReference<Kingdom, List<CharacterInterface<Character>>, CharacterInterface<Character>> kingdomCharacterMappingObject = new MappingObjectsWithReference<>(
				kingdomCharacterMap);
		try {
			if (isOfficer(paths[0])) {
				for (String s : paths) {
//				file = new File(s);
					readOfficerFile(new FileStreamHandler(s), kingdomCharacterMappingObject);
					logger.info("parsed officers from " + s);
				}
				characters.addAll(officers);
			} else {
				for (String s : paths) {
					readSubOfficerFile(new FileStreamHandler(s), kingdomCharacterMappingObject);
					logger.info("parsed subofficers from " + s);
				}
				characters.addAll(subOfficers);
			}
		} catch (Exception e) {
			throw new WarriorsParingException(e);
		}
	}

	private static void readOfficerFile(FileStreamHandler fsh,
			MappingObjectsWithReference<Kingdom, List<CharacterInterface<Character>>, CharacterInterface<Character>> kingdomCharacterMappingObject) {
		try (BufferedReader br = fsh.getBufferedReader()) {
			String raw = "";
			while ((raw = br.readLine()) != null) {
				String[] line = raw.split(DW8Constants.Split.COMMA.getValue());
				parseOfficer(line, kingdomCharacterMappingObject);
			}
		} catch (IOException | NullPointerException ex) {
			throw new WarriorsParingException(ex.getMessage());
		}
	}

	private static void parseOfficer(String[] arr,
			MappingObjectsWithReference<Kingdom, List<CharacterInterface<Character>>, CharacterInterface<Character>> kingdomCharacterMappingObject) {
		Kingdom kingdom = Kingdom.returnCorrectEnum(arr[1].trim());
		// Instantiate and init officer Object with correct fields from lineArr
		CharacterInterface<Character> officer = new Officer(arr[0].trim(), kingdom,
				Types.returnCorrectEnum(arr[2].trim()));
		// Create a List of All Officers
		officers.add(officer);
//		Create Map Kingdom-List<Officer> Key-Value
		kingdomCharacterMappingObject.mapKeyValueWithList(kingdom, officer);
	}

	private static void readSubOfficerFile(FileStreamHandler fsh,
			MappingObjectsWithReference<Kingdom, List<CharacterInterface<Character>>, CharacterInterface<Character>> kingdomCharacterMappingObject) {
		try (BufferedReader br = fsh.getBufferedReader()) {
			String raw = "";
			while ((raw = br.readLine()) != null) {
				String[] line = raw.split(DW8Constants.Split.COMMA.getValue());
				parseSubOfficer(line, getKingdomFromFileName(fsh.getFileName()), kingdomCharacterMappingObject);
			}
		} catch (IOException | NullPointerException ex) {
			throw new WarriorsParingException(ex.getMessage());
		}
	}

	private static void parseSubOfficer(String[] arr, Kingdom kingdom,
			MappingObjectsWithReference<Kingdom, List<CharacterInterface<Character>>, CharacterInterface<Character>> kingdomCharacterMappingObject) {
		// Instantiate and init officer Object with correct fields from lineArr
		CharacterInterface<Character> subOfficer = new SubOfficer(arr[0].trim(), kingdom);
		// Create a List of All Officers
		subOfficers.add(subOfficer);
//		Create Map Kingdom-List<Officer> Key-Value
		kingdomCharacterMappingObject.mapKeyValueWithList(kingdom, subOfficer);
	}

	private static boolean isOfficer(String path) {
		String[] splitByForwardSlash = path.split(DW8Constants.Split.FWD_SLASH.getValue());
		for (int i = 0; i < splitByForwardSlash.length; i++) {
			if (splitByForwardSlash[i].equalsIgnoreCase(DW8Constants.MetaData.OFFICER.getValue())) {
				return true;
			}
		}
		return false;
	}

	private static Kingdom getKingdomFromFileName(String name) {
//		  File format --> Officer-List-[kingdom].txt 
//		  --> Extract and return [kingdom] value
		String[] splitByDash = name.split(DW8Constants.Split.HYPHEN.getValue());
		String[] splitByPeriod = splitByDash[2].split(DW8Constants.Split.PERIOD.getValue());
		return Kingdom.returnCorrectEnum(splitByPeriod[0]);
	}
}
