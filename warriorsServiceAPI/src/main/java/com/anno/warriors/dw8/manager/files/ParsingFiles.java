package com.anno.warriors.dw8.manager.files;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.warriors.dw8.attributes.model.AttributeInterface;
import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.enums.category.Category;
import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.keys.WeaponName_TypesAttributesKey;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.manager.weapons.WeaponAttributeParseManager;
import com.anno.warriors.dw8.manager.weapons.WeaponParseManager;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;
import com.anno.warriors.dw8.weapons.slots.AttributeSlot;

/*
 * Class is responsible to load and read all files
 * Will Most likely use the DW8Structures class to keep track of 
 * all statistics/metadata about the objects and files
 */
public class ParsingFiles implements DynastyWarriors8Object<ParsingFiles> {

	private static DynastyWarriors8Object<ParsingFiles> instance;
	private static Logger logger = LoggerFactory.getLogger(ParsingFiles.class);

	public static DynastyWarriors8Object<ParsingFiles> getInstance() {
		if (instance == null) {
			synchronized (ParsingFiles.class) {
				if (instance == null) {
					logger.info("ParsingFiles instantiated");
					return new ParsingFiles();
				}
			}
		}
		return instance;
	}

	private ParsingFiles() {
		AttributeParseManager.getInstance();
		CharacterParseManager.getInstance();
		TypeParseManager.getInstance();
		WeaponParseManager.getInstance();
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
	}

	public static List<CharacterInterface<Character>> getAllOfficers() {
		return CharacterParseManager.getOfficers();
	}

	public static List<CharacterInterface<Character>> getAllSubOfficers() {
		return CharacterParseManager.getSubOfficers();
	}

	public static List<CharacterInterface<Character>> getAllCharacters() {
		return CharacterParseManager.getCharacters();
	}

	public static Map<Kingdom, List<CharacterInterface<Character>>> getMappedKingdomCharacters() {
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

	public static Map<WeaponName_TypesAttributesKey, List<AttributeSlot>> getWeapNameTypesKeyAttributesMap() {
		return WeaponAttributeParseManager.getWeapNameTypesKeyAttributesMap();
	}

	public static List<String> getAllWeaponNames() {
		return WeaponParseManager.getWeaponNames();
	}

	public static List<WeaponInterface<Weapon>> getWeaponsList() {
		return WeaponParseManager.getWeapons();
	}

	public static Map<Category, List<WeaponInterface<Weapon>>> getCategoryWeaponsMap() {
		return WeaponParseManager.getCategoryWeaponsMap();
	}

	public static Map<Types, List<WeaponInterface<Weapon>>> getTypesWeaponListMap() {
		return WeaponParseManager.getTypesWeaponListMap();
	}

	public static Map<String, List<WeaponInterface<Weapon>>> getWeaponNameWeaponsMap() {
		return WeaponParseManager.getWeaponNameWeaponsMap();
	}
}
