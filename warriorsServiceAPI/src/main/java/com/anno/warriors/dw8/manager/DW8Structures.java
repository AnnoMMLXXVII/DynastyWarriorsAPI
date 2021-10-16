package com.anno.warriors.dw8.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.enums.category.Category;
import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.enums.rarity.Rarity;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.images.model.DynastyWarriors8Image;
import com.anno.warriors.dw8.keys.OfficerKingdomKey;
import com.anno.warriors.dw8.keys.WeaponName_TypesAttributesKey;
import com.anno.warriors.dw8.manager.files.ParsingFiles;
import com.anno.warriors.dw8.manager.images.ParsingImages;
import com.anno.warriors.dw8.shared.DW8Constants;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;
import com.anno.warriors.dw8.weapons.slots.AttributeSlot;

/*
 * Class will deal w/ various data structures that 
 * could be used to capture some stats/metadata
 * about the files that were parsed
 * 
 */
public class DW8Structures implements DynastyWarriors8Object<DW8Structures> {

	private static Logger logger = LoggerFactory.getLogger(DW8Structures.class);

	private static DynastyWarriors8Object<DW8Structures> instance;
	private static Map<String, String> attributePath = new HashMap<>();
	private static Map<String, String> officerPath = new HashMap<>();
	private static Map<String, String> subOfficerPath = new HashMap<>();
	private static Map<String, String> dasherPath = new HashMap<>();
	private static Map<String, String> diverPath = new HashMap<>();
	private static Map<String, String> shadowPath = new HashMap<>();
	private static Map<String, String> whirlwindPath = new HashMap<>();
	private static Map<String, Map<String, String>> allPaths = new HashMap<>();
	private static Map<String, List<DynastyWarriors8Image>> officerImages = new HashMap<>();
	private static Map<Types, List<DynastyWarriors8Image>> weaponImages = new HashMap<>();
	private static Map<String, String> weaponNamePathMap = new HashMap<>();
	private static List<String> weaponNames = new ArrayList<>();
	private static List<CharacterInterface<Character>> officers = new ArrayList<>();
	private static List<CharacterInterface<Character>> subOfficers = new ArrayList<>();
	private static List<CharacterInterface<Character>> characters = new ArrayList<>();
	private static Map<Kingdom, List<CharacterInterface<Character>>> kingdomCharacterMap = new HashMap<>();
	private static Map<WeaponName_TypesAttributesKey, List<AttributeSlot>> weapNameTypesKeyAttributesMap = new HashMap<>();
	private static List<WeaponInterface<Weapon>> weapons = new ArrayList<>();
	private static Map<Category, List<WeaponInterface<Weapon>>> categoryWeaponsMap = new HashMap<>();
	private static Map<Types, List<WeaponInterface<Weapon>>> typesWeaponListMap = new HashMap<>();
	private static Map<String, List<WeaponInterface<Weapon>>> weaponNameWeaponsMap = new HashMap<>();

	public static DynastyWarriors8Object<DW8Structures> getInstance() {
		if (instance == null) {
			synchronized (DW8Structures.class) {
				if (instance == null) {
					logger.info("DW8Structures instantiated");
					return new DW8Structures();
				}
			}
		}
		return instance;
	}

	private DW8Structures() {
		mapPathFromConstants();
		mapCharacterFiles();
		mapWeaponsAndAttributes();

	}

	public static Map<String, String> getAttributePath() {
		return attributePath;
	}

	public static Map<String, String> getOfficerPath() {
		return officerPath;
	}

	public static Map<String, String> getSubOfficerPath() {
		return subOfficerPath;
	}

	public static Map<String, String> getDasherPath() {
		return dasherPath;
	}

	public static Map<String, String> getDiverPath() {
		return diverPath;
	}

	public static Map<String, String> getShadowPath() {
		return shadowPath;
	}

	public static Map<String, String> getWhirlwindPath() {
		return whirlwindPath;
	}

	public static Map<String, List<DynastyWarriors8Image>> getOfficerImages() {
		return officerImages;
	}

	public static Map<Types, List<DynastyWarriors8Image>> getWeaponImages() {
		return weaponImages;
	}

	public static Map<String, String> getMappedWeaponImagesPathMap() {
		return weaponNamePathMap;
	}

	public static Map<String, Map<String, String>> getAllPaths() {
		return allPaths;
	}

	public static List<CharacterInterface<Character>> getOfficers() {
		return officers;
	}

	public static List<CharacterInterface<Character>> getSubOfficers() {
		return subOfficers;
	}

	public static List<CharacterInterface<Character>> getCharacters() {
		return characters;
	}

	public static Map<Kingdom, List<CharacterInterface<Character>>> getKingdomCharacterMap() {
		return kingdomCharacterMap;
	}

	public static Map<WeaponName_TypesAttributesKey, List<AttributeSlot>> getWeapNameTypesKeyAttributesMap() {
		return weapNameTypesKeyAttributesMap;
	}

	public static List<String> getWeaponNames() {
		return weaponNames;
	}

	public static List<WeaponInterface<Weapon>> getWeapons() {
		return weapons;
	}

	public static Map<Category, List<WeaponInterface<Weapon>>> getCategoryWeaponsMap() {
		return categoryWeaponsMap;
	}

	public static Map<Types, List<WeaponInterface<Weapon>>> getTypeWeaponKeyKeyMap() {
		return typesWeaponListMap;
	}

	public static Map<String, List<WeaponInterface<Weapon>>> getWeaponNameWeaponsMap() {
		return weaponNameWeaponsMap;
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
	}

	private static void mapPathFromConstants() {
		mapAttributePath();
		logger.info("Mapped Attributes");
		mapOfficerPath();
		mapSubOfficerPath();
		logger.info("Mapped Characters Paths - Officers-SubOfficers");
		mapDasherPath();
		mapDiverPath();
		mapShadowPath();
		mapWhirlwindPath();
		logger.info("Mapped Category Enums");
		mapOfficerImagePath();
		logger.info("Mapped Officer Images");
		mapWeaponImagePath();
		mapWeaponImagesMapPath();
		logger.info("Mapped Weapon Images");
	}

	private static void mapCharacterFiles() {
		mapParsedCharacters();
		mapParsedOfficers();
		mapParsedSubOfficers();
		mapParsedKingdomCharactersMap();
		logger.info("Mapped Characters - Officers-SubOfficers");
	}

	private static void mapWeaponsAndAttributes() {
		mapParsedWeaponsMap();
		mapWeaponNamesList();
		mapWeaponsList();
		mapCategoryWeaponsMap();
		mapTypesWeaponListMap();
		mapWeaponNameWeaponsMap();
	}

	private static void mapAttributePath() {
		attributePath.put(DW8Constants.MetaData.NORMAL.getValue().toLowerCase(), DW8Constants.ATTRIBUTES_NORMAL_FILE);
		attributePath.put(DW8Constants.MetaData.SPECIAL.getValue().toLowerCase(), DW8Constants.ATTRIBUTES_SPECIAL_FILE);
		allPaths.put(DW8Constants.MetaData.ATTRIBUTE.getValue().toLowerCase(), attributePath);
	}

	private static void mapOfficerPath() {
		officerPath.put(Kingdom.SHU.getValue().toLowerCase(), DW8Constants.OFFICER_SHU_FILE);
		officerPath.put(Kingdom.WU.getValue().toLowerCase(), DW8Constants.OFFICER_WU_FILE);
		officerPath.put(Kingdom.WEI.getValue().toLowerCase(), DW8Constants.OFFICER_WEI_FILE);
		officerPath.put(Kingdom.JIN.getValue().toLowerCase(), DW8Constants.OFFICER_JIN_FILE);
		officerPath.put(Kingdom.OTHER.getValue().toLowerCase(), DW8Constants.OFFICER_OTHER_FILE);
		allPaths.put(DW8Constants.MetaData.OFFICER.getValue().toLowerCase(), officerPath);
	}

	private static void mapSubOfficerPath() {
		subOfficerPath.put(Kingdom.SHU.getValue().toLowerCase(), DW8Constants.SUBOFFICER_SHU_FILE);
		subOfficerPath.put(Kingdom.WU.getValue().toLowerCase(), DW8Constants.SUBOFFICER_WU_FILE);
		subOfficerPath.put(Kingdom.WEI.getValue().toLowerCase(), DW8Constants.SUBOFFICER_WEI_FILE);
		subOfficerPath.put(Kingdom.JIN.getValue().toLowerCase(), DW8Constants.SUBOFFICER_JIN_FILE);
		subOfficerPath.put(Kingdom.OTHER.getValue().toLowerCase(), DW8Constants.SUBOFFICER_OTHER_FILE);
		allPaths.put(DW8Constants.MetaData.SUBOFFICER.getValue().toLowerCase(), subOfficerPath);
	}

	private static void mapDasherPath() {
		dasherPath.put(Rarity.NORMAL.getValue().toLowerCase(), DW8Constants.WEAPON_DASHER_NORMAL_FILE);
		dasherPath.put(Rarity.RARE.getValue().toLowerCase(), DW8Constants.WEAPON_DASHER_RARE_FILE);
		dasherPath.put(Rarity.UNIQUE.getValue().toLowerCase(), DW8Constants.WEAPON_DASHER_UNIQUE_FILE);
		dasherPath.put(Rarity.EXTREME.getValue().toLowerCase(), DW8Constants.WEAPON_DASHER_XTREME_FILE);
		dasherPath.put(DW8Constants.MetaData.SUBOFFICER.getValue().toLowerCase() + "s",
				DW8Constants.WEAPON_DASHER_ATTRIBUTES_FILE);
		allPaths.put(Category.DASHER.getValue().toLowerCase(), dasherPath);
	}

	private static void mapDiverPath() {
		diverPath.put(Rarity.NORMAL.getValue().toLowerCase(), DW8Constants.WEAPON_DIVER_NORMAL_FILE);
		diverPath.put(Rarity.RARE.getValue().toLowerCase(), DW8Constants.WEAPON_DIVER_RARE_FILE);
		diverPath.put(Rarity.UNIQUE.getValue().toLowerCase(), DW8Constants.WEAPON_DIVER_UNIQUE_FILE);
		diverPath.put(Rarity.EXTREME.getValue().toLowerCase(), DW8Constants.WEAPON_DIVER_XTREME_FILE);
		diverPath.put(DW8Constants.MetaData.SUBOFFICER.getValue().toLowerCase() + "s",
				DW8Constants.WEAPON_DIVER_ATTRIBUTES_FILE);
		allPaths.put(Category.DIVER.getValue().toLowerCase(), diverPath);
	}

	private static void mapShadowPath() {
		shadowPath.put(Rarity.NORMAL.getValue().toLowerCase(), DW8Constants.WEAPON_SHADOW_NORMAL_FILE);
		shadowPath.put(Rarity.RARE.getValue().toLowerCase(), DW8Constants.WEAPON_SHADOW_RARE_FILE);
		shadowPath.put(Rarity.UNIQUE.getValue().toLowerCase(), DW8Constants.WEAPON_SHADOW_UNIQUE_FILE);
		shadowPath.put(Rarity.EXTREME.getValue().toLowerCase(), DW8Constants.WEAPON_SHADOW_XTREME_FILE);
		shadowPath.put(DW8Constants.MetaData.SUBOFFICER.getValue().toLowerCase() + "s",
				DW8Constants.WEAPON_SHADOW_ATTRIBUTES_FILE);
		allPaths.put(Category.SHADOW_SPRINTER.getValue().toLowerCase(), shadowPath);
	}

	private static void mapWhirlwindPath() {
		whirlwindPath.put(Rarity.NORMAL.getValue().toLowerCase(), DW8Constants.WEAPON_WHIRLWIND_NORMAL_FILE);
		whirlwindPath.put(Rarity.RARE.getValue().toLowerCase(), DW8Constants.WEAPON_WHIRLWIND_RARE_FILE);
		whirlwindPath.put(Rarity.UNIQUE.getValue().toLowerCase(), DW8Constants.WEAPON_WHIRLWIND_UNIQUE_FILE);
		whirlwindPath.put(Rarity.EXTREME.getValue().toLowerCase(), DW8Constants.WEAPON_WHIRLWIND_XTREME_FILE);
		whirlwindPath.put(DW8Constants.MetaData.SUBOFFICER.getValue().toLowerCase() + "s",
				DW8Constants.WEAPON_WHIRLWIND_ATTRIBUTES_FILE);
		allPaths.put(Category.WHIRLD_WIND.getValue().toLowerCase(), whirlwindPath);
	}

	private static void mapOfficerImagePath() {
		officerImages = ParsingImages.getOfficerImages();
	}

	private static void mapWeaponImagePath() {
		weaponImages = ParsingImages.getWeaponImages();
	}

	private static void mapWeaponImagesMapPath() {
		weaponNamePathMap = ParsingImages.getWeaponNamePathMap();
	}

	private static void mapParsedCharacters() {
		characters = ParsingFiles.getAllCharacters();
	}

	private static void mapParsedOfficers() {
		officers = ParsingFiles.getAllOfficers();
	}

	private static void mapParsedSubOfficers() {
		subOfficers = ParsingFiles.getAllSubOfficers();
	}

	private static void mapParsedKingdomCharactersMap() {
		kingdomCharacterMap = ParsingFiles.getMappedKingdomCharacters();
	}

	private static void mapParsedWeaponsMap() {
		weapNameTypesKeyAttributesMap = ParsingFiles.getWeapNameTypesKeyAttributesMap();
	}

	private static void mapWeaponNamesList() {
		weaponNames = ParsingFiles.getAllWeaponNames();
	}

	private static void mapWeaponsList() {
		weapons = ParsingFiles.getWeaponsList();
	}

	private static void mapCategoryWeaponsMap() {
		categoryWeaponsMap = ParsingFiles.getCategoryWeaponsMap();
	}

	private static void mapTypesWeaponListMap() {
		typesWeaponListMap = ParsingFiles.getTypesWeaponListMap();
	}

	private static void mapWeaponNameWeaponsMap() {
		weaponNameWeaponsMap = ParsingFiles.getWeaponNameWeaponsMap();
	}

}
