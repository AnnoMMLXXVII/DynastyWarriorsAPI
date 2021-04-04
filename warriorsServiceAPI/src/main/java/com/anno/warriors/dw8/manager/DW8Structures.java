package com.anno.warriors.dw8.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.anno.warriors.dw8.keys.OfficerKingdomKey;
import com.anno.warriors.dw8.shared.DW8Constants;

/*
 * Class will deal w/ various data structures that 
 * could be used to capture some stats/metadata
 * about the files that were parsed
 * 
 */
public class DW8Structures implements DynastyWarriors8Object<DW8Structures> {

	private static DynastyWarriors8Object<DW8Structures> instance;
	private static Map<String, String> attributePath = new HashMap<>();
	private static Map<String, String> officerPath = new HashMap<>();
	private static Map<String, String> subOfficerPath = new HashMap<>();
	private static Map<String, String> dasherPath = new HashMap<>();
	private static Map<String, String> diverPath = new HashMap<>();
	private static Map<String, String> shadowPath = new HashMap<>();
	private static Map<String, String> whirlwindPath = new HashMap<>();
	private static Map<String, List<String>> officerImages = new HashMap<>();
	private static Map<OfficerKingdomKey, List<String>> weaponImages = new HashMap<>();
	private static final String NORMAL_STR = "normal";
	private static final String UNIQUE_STR = "unqiue";
	private static final String RARE_STR = "rare";
	private static final String XL_STR = "xtreme";
	private static final String ATTR_STR = "attirbutes";

	public static DynastyWarriors8Object<DW8Structures> getInstance() {
		if (instance == null) {
			synchronized (DW8Structures.class) {
				if (instance == null) {
					return new DW8Structures();
				}
			}
		}
		return instance;
	}

	private DW8Structures() {
		mapPathFromConstants();
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

	@Override
	public DW8Structures getManagerType() {
		return this;
	}

	private static void mapPathFromConstants() {
		mapAttributePath();
		mapOfficerPath();
		mapSubOfficerPath();
		mapDasherPath();
		mapDiverPath();
		mapShadowPath();
		mapWhirlwindPath();
		mapOfficerImagePath();
		mapWeaponImagePath();

	}

	private static void mapAttributePath() {
		attributePath.put(NORMAL_STR, DW8Constants.ATTRIBUTES_NORMAL_FILE);
		attributePath.put("special", DW8Constants.ATTRIBUTES_SPECIAL_FILE);
	}

	private static void mapOfficerPath() {
		officerPath.put("shu", DW8Constants.OFFICER_SHU_FILE);
		officerPath.put("wu", DW8Constants.OFFICER_WU_FILE);
		officerPath.put("wei", DW8Constants.OFFICER_WEI_FILE);
		officerPath.put("jin", DW8Constants.OFFICER_JIN_FILE);
		officerPath.put("other", DW8Constants.OFFICER_OTHER_FILE);
	}

	private static void mapSubOfficerPath() {
		subOfficerPath.put("shu", DW8Constants.SUBOFFICER_SHU_FILE);
		subOfficerPath.put("wu", DW8Constants.SUBOFFICER_WU_FILE);
		subOfficerPath.put("wei", DW8Constants.SUBOFFICER_WEI_FILE);
		subOfficerPath.put("jin", DW8Constants.SUBOFFICER_JIN_FILE);
		subOfficerPath.put("other", DW8Constants.SUBOFFICER_OTHER_FILE);
	}

	private static void mapDasherPath() {
		dasherPath.put(NORMAL_STR, DW8Constants.WEAPON_DASHER_NORMAL_FILE);
		dasherPath.put(RARE_STR, DW8Constants.WEAPON_DASHER_RARE_FILE);
		dasherPath.put(UNIQUE_STR, DW8Constants.WEAPON_DASHER_UNIQUE_FILE);
		dasherPath.put(XL_STR, DW8Constants.WEAPON_DASHER_XTREME_FILE);
		dasherPath.put(ATTR_STR, DW8Constants.WEAPON_DASHER_ATTRIBUTES_FILE);
	}

	private static void mapDiverPath() {
		diverPath.put(NORMAL_STR, DW8Constants.WEAPON_DIVER_NORMAL_FILE);
		diverPath.put(RARE_STR, DW8Constants.WEAPON_DIVER_RARE_FILE);
		diverPath.put(UNIQUE_STR, DW8Constants.WEAPON_DIVER_UNIQUE_FILE);
		diverPath.put(XL_STR, DW8Constants.WEAPON_DIVER_XTREME_FILE);
		diverPath.put(ATTR_STR, DW8Constants.WEAPON_DIVER_ATTRIBUTES_FILE);
	}

	private static void mapShadowPath() {
		shadowPath.put(NORMAL_STR, DW8Constants.WEAPON_SHADOW_NORMAL_FILE);
		shadowPath.put(RARE_STR, DW8Constants.WEAPON_SHADOW_RARE_FILE);
		shadowPath.put(UNIQUE_STR, DW8Constants.WEAPON_SHADOW_UNIQUE_FILE);
		shadowPath.put(XL_STR, DW8Constants.WEAPON_SHADOW_XTREME_FILE);
		shadowPath.put(ATTR_STR, DW8Constants.WEAPON_SHADOW_ATTRIBUTES_FILE);
	}

	private static void mapWhirlwindPath() {
		whirlwindPath.put(NORMAL_STR, DW8Constants.WEAPON_WHIRLWIND_NORMAL_FILE);
		whirlwindPath.put(RARE_STR, DW8Constants.WEAPON_WHIRLWIND_RARE_FILE);
		whirlwindPath.put(UNIQUE_STR, DW8Constants.WEAPON_WHIRLWIND_UNIQUE_FILE);
		whirlwindPath.put(XL_STR, DW8Constants.WEAPON_WHIRLWIND_XTREME_FILE);
		whirlwindPath.put(ATTR_STR, DW8Constants.WEAPON_WHIRLWIND_ATTRIBUTES_FILE);
	}

	private static void mapOfficerImagePath() {
		officerImages = DW8ParsingImages.getOfficerImages();
	}

	private static void mapWeaponImagePath() {
		weaponImages = DW8ParsingImages.getWeaponImages();
	}

}
