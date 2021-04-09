package com.anno.warriors.dw8.manager;

import java.util.List;
import java.util.Map;

import com.anno.warriors.dw8.characters.CharacterInterface;
import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.manager.characters.DW8CharacterParseManager;

/*
 * Class is responsible to load and read all files
 * Will Most likely use the DW8Structures class to keep track of 
 * all statistics/metadata about the objects and files
 */
public class DW8ParsingFiles implements DynastyWarriors8Object<DW8ParsingFiles> {

	private static DynastyWarriors8Object<DW8ParsingFiles> instance;
	private static DynastyWarriors8Object<DW8Structures> structure;

	public static DynastyWarriors8Object<DW8ParsingFiles> getInstance() {
		if (instance == null) {
			synchronized (DW8ParsingFiles.class) {
				if (instance == null) {
					return new DW8ParsingFiles();
				}
			}
		}
		return instance;
	}

	private DW8ParsingFiles() {
		DW8CharacterParseManager.getInstance();
	}

	@Override
	public DW8ParsingFiles getManagerType() {
		return this;
	}

	public static List<DynastyWarriors8Object<CharacterInterface>> getAllOfficers() {
		return DW8CharacterParseManager.getOfficers();
	}

	public static List<DynastyWarriors8Object<CharacterInterface>> getAllSubOfficers() {
		return DW8CharacterParseManager.getSubOfficers();
	}

	public static List<DynastyWarriors8Object<CharacterInterface>> getAllCharacters() {
		return DW8CharacterParseManager.getOfficers();
	}

	public static Map<Kingdom, List<DynastyWarriors8Object<CharacterInterface>>> getMappedKingdomCharacters() {
		return DW8CharacterParseManager.getKingdomCharacterMap();
	}

}
