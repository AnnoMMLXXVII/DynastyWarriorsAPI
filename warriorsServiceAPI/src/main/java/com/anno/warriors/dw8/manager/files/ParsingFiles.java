package com.anno.warriors.dw8.manager.files;

import java.util.List;
import java.util.Map;

import com.anno.warriors.dw8.characters.CharacterInterface;
import com.anno.warriors.dw8.enums.attribute.AttributeInterface;
import com.anno.warriors.dw8.enums.category.Category;
import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;

/*
 * Class is responsible to load and read all files
 * Will Most likely use the DW8Structures class to keep track of 
 * all statistics/metadata about the objects and files
 */
public class ParsingFiles implements DynastyWarriors8Object<ParsingFiles> {

	private static DynastyWarriors8Object<ParsingFiles> instance;

	public static DynastyWarriors8Object<ParsingFiles> getInstance() {
		if (instance == null) {
			synchronized (ParsingFiles.class) {
				if (instance == null) {
					return new ParsingFiles();
				}
			}
		}
		return instance;
	}

	private ParsingFiles() {
		CharacterParseManager.getInstance();
//		 Parse Attributes File
//		 Parse Type File

	}

	@Override
	public ParsingFiles getObjectType() {
		return this;
	}

	public static List<CharacterInterface> getAllOfficers() {
		return CharacterParseManager.getOfficers();
	}

	public static List<CharacterInterface> getAllSubOfficers() {
		return CharacterParseManager.getSubOfficers();
	}

	public static List<CharacterInterface> getAllCharacters() {
		return CharacterParseManager.getOfficers();
	}

	public static Map<Kingdom, List<CharacterInterface>> getMappedKingdomCharacters() {
		return CharacterParseManager.getKingdomCharacterMap();
	}

	public static List<AttributeInterface> getAllAttributes() {
		return AttributeParseManager.getAttributes();
	}

	public static List<AttributeInterface> getNormalAttributes() {
		return AttributeParseManager.getNormalAttributes();
	}

	public static List<AttributeInterface> getSpecialAttributes() {
		return AttributeParseManager.getSpecialAttributes();
	}

	public static Map<String, List<AttributeInterface>> getMappedAttributes() {
		return AttributeParseManager.getMappedListAttributes();
	}

	public static Map<Category, List<Types>> getMappedTypes() {
		return TypeParseManager.getMappedTypes();
	}
}
