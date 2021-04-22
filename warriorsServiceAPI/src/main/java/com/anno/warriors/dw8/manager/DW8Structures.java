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
import com.anno.warriors.dw8.enums.types.Types;
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
	private static Map<String, List<String>> officerImages = new HashMap<>();
	private static Map<OfficerKingdomKey, List<String>> weaponImages = new HashMap<>();
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

	private static final String NORMAL_STR = "normal";
	private static final String UNIQUE_STR = "unqiue";
	private static final String RARE_STR = "rare";
	private static final String XL_STR = "xtreme";
	private static final String ATTR_STR = "attirbutes";

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

	public static Map<String, List<String>> getOfficerImages() {
		return officerImages;
	}

	public static Map<OfficerKingdomKey, List<String>> getWeaponImages() {
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
		attributePath.put(NORMAL_STR, DW8Constants.ATTRIBUTES_NORMAL_FILE);
		attributePath.put("special", DW8Constants.ATTRIBUTES_SPECIAL_FILE);
		allPaths.put("attribute", attributePath);
	}

	private static void mapOfficerPath() {
		officerPath.put("shu", DW8Constants.OFFICER_SHU_FILE);
		officerPath.put("wu", DW8Constants.OFFICER_WU_FILE);
		officerPath.put("wei", DW8Constants.OFFICER_WEI_FILE);
		officerPath.put("jin", DW8Constants.OFFICER_JIN_FILE);
		officerPath.put("other", DW8Constants.OFFICER_OTHER_FILE);
		allPaths.put("officer", officerPath);
	}

	private static void mapSubOfficerPath() {
		subOfficerPath.put("shu", DW8Constants.SUBOFFICER_SHU_FILE);
		subOfficerPath.put("wu", DW8Constants.SUBOFFICER_WU_FILE);
		subOfficerPath.put("wei", DW8Constants.SUBOFFICER_WEI_FILE);
		subOfficerPath.put("jin", DW8Constants.SUBOFFICER_JIN_FILE);
		subOfficerPath.put("other", DW8Constants.SUBOFFICER_OTHER_FILE);
		allPaths.put("subOfficer", subOfficerPath);
	}

	private static void mapDasherPath() {
		dasherPath.put(NORMAL_STR, DW8Constants.WEAPON_DASHER_NORMAL_FILE);
		dasherPath.put(RARE_STR, DW8Constants.WEAPON_DASHER_RARE_FILE);
		dasherPath.put(UNIQUE_STR, DW8Constants.WEAPON_DASHER_UNIQUE_FILE);
		dasherPath.put(XL_STR, DW8Constants.WEAPON_DASHER_XTREME_FILE);
		dasherPath.put(ATTR_STR, DW8Constants.WEAPON_DASHER_ATTRIBUTES_FILE);
		allPaths.put("dasher", dasherPath);
	}

	private static void mapDiverPath() {
		diverPath.put(NORMAL_STR, DW8Constants.WEAPON_DIVER_NORMAL_FILE);
		diverPath.put(RARE_STR, DW8Constants.WEAPON_DIVER_RARE_FILE);
		diverPath.put(UNIQUE_STR, DW8Constants.WEAPON_DIVER_UNIQUE_FILE);
		diverPath.put(XL_STR, DW8Constants.WEAPON_DIVER_XTREME_FILE);
		diverPath.put(ATTR_STR, DW8Constants.WEAPON_DIVER_ATTRIBUTES_FILE);
		allPaths.put("diver", diverPath);
	}

	private static void mapShadowPath() {
		shadowPath.put(NORMAL_STR, DW8Constants.WEAPON_SHADOW_NORMAL_FILE);
		shadowPath.put(RARE_STR, DW8Constants.WEAPON_SHADOW_RARE_FILE);
		shadowPath.put(UNIQUE_STR, DW8Constants.WEAPON_SHADOW_UNIQUE_FILE);
		shadowPath.put(XL_STR, DW8Constants.WEAPON_SHADOW_XTREME_FILE);
		shadowPath.put(ATTR_STR, DW8Constants.WEAPON_SHADOW_ATTRIBUTES_FILE);
		allPaths.put("shadow", shadowPath);
	}

	private static void mapWhirlwindPath() {
		whirlwindPath.put(NORMAL_STR, DW8Constants.WEAPON_WHIRLWIND_NORMAL_FILE);
		whirlwindPath.put(RARE_STR, DW8Constants.WEAPON_WHIRLWIND_RARE_FILE);
		whirlwindPath.put(UNIQUE_STR, DW8Constants.WEAPON_WHIRLWIND_UNIQUE_FILE);
		whirlwindPath.put(XL_STR, DW8Constants.WEAPON_WHIRLWIND_XTREME_FILE);
		whirlwindPath.put(ATTR_STR, DW8Constants.WEAPON_WHIRLWIND_ATTRIBUTES_FILE);
		allPaths.put("whirlwind", whirlwindPath);
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
