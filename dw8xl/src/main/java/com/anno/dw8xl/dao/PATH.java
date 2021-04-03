package com.anno.dw8xl.dao;

/**
 * @author venividivicihofneondeion010101
 *
 */
public enum PATH {

	URL_ROOT("src/main/resources/"), TEXT_FILE_PATH("Text-Files/"), CATEGORY_END("category/category.txt"),
	CHARACTER_ROOT("characters/"), ATTRIBUTES_ROOT("attributes/"), KINGDOM_END("kingdoms/kingdom.txt"),
	N_ATTRIBUTE_END(ATTRIBUTES_ROOT.getStringUrl() + "normal/normal"), RARITY_END("rarity/rarity.txt"),
	S_ATTRIBUTE_END(ATTRIBUTES_ROOT.getStringUrl() + "special/special"), WEAPONS_ROOT("weapons/"),

	OFFICER_SHU_END(CHARACTER_ROOT.getStringUrl() + "officer/Officer-List-Shu.txt"),
	OFFICER_WU_END(CHARACTER_ROOT.getStringUrl() + "officer/Officer-List-Wu.txt"),
	OFFICER_OTHER_END(CHARACTER_ROOT.getStringUrl() + "officer/Officer-List-Other.txt"),
	OFFICER_JIN_END(CHARACTER_ROOT.getStringUrl() + "officer/Officer-List-Jin.txt"),
	OFFICER_WEI_END(CHARACTER_ROOT.getStringUrl() + "officer/Officer-List-Wei.txt"),

	SUBOFFICER_SHU_END(CHARACTER_ROOT.getStringUrl() + "sub-officer/SubOfficer-List-Shu.txt"),
	SUBOFFICER_WU_END(CHARACTER_ROOT.getStringUrl() + "sub-officer/SubOfficer-List-Wu.txt"),
	SUBOFFICER_OTHER_END(CHARACTER_ROOT.getStringUrl() + "sub-officer/SubOfficer-List-Other.txt"),
	SUBOFFICER_JIN_END(CHARACTER_ROOT.getStringUrl() + "sub-officer/SubOfficer-List-Wei.txt"),
	SUBOFFICER_WEI_END(CHARACTER_ROOT.getStringUrl() + "sub-officer/SubOfficer-List-Wu.txt"),

	TYPE_END("type/type"),

	DASHER_ATTRIBUTE_LEVEL_END(WEAPONS_ROOT.getStringUrl() + "dasher/WeaponAttributeLevel.txt"),
	DASHER_NORMAL_END(WEAPONS_ROOT.getStringUrl() + "dasher/NormalWeapons.txt"),
	DASHER_RARE_END(WEAPONS_ROOT.getStringUrl() + "dasher/RareWeapons.txt"),
	DASHER_UNIQUE_END(WEAPONS_ROOT.getStringUrl() + "dasher/UniqueWeapons-5-Stars.txt"),
	DASHER_XTREME_END(WEAPONS_ROOT.getStringUrl() + "dasher/XLWeapons-6-Stars.txt"),

	DIVER_ATTRIBUTE_LEVEL_END(WEAPONS_ROOT.getStringUrl() + "diver/WeaponAttributeLevel.txt"),
	DIVER_NORMAL_END(WEAPONS_ROOT.getStringUrl() + "diver/NormalWeapons.txt"),
	DIVER_RARE_END(WEAPONS_ROOT.getStringUrl() + "diver/RareWeapons.txt"),
	DIVER_UNIQUE_END(WEAPONS_ROOT.getStringUrl() + "diver/UniqueWeapons-5-Stars.txt"),
	DIVER_XTREME_END(WEAPONS_ROOT.getStringUrl() + "diver/XLWeapons-6-Stars.txt"),

	SHADOW_ATTRIBUTE_LEVEL_END(WEAPONS_ROOT.getStringUrl() + "shadow/WeaponAttributeLevel.txt"),
	SHADOW_NORMAL_END(WEAPONS_ROOT.getStringUrl() + "shadow/NormalWeapons.txt"),
	SHADOW_RARE_END(WEAPONS_ROOT.getStringUrl() + "shadow/RareWeapons.txt"),
	SHADOW_UNIQUE_END(WEAPONS_ROOT.getStringUrl() + "shadow/UniqueWeapons-5-Stars.txt"),
	SHADOW_XTREME_END(WEAPONS_ROOT.getStringUrl() + "shadow/XLWeapons-6-Stars.txt"),

	WHIRLWIND_ATTRIBUTE_LEVEL_END(WEAPONS_ROOT.getStringUrl() + "whirlwind/WeaponAttributeLevel.txt"),
	WHIRLWIND_NORMAL_END(WEAPONS_ROOT.getStringUrl() + "whirlwind/NormalWeapons.txt"),
	WHIRLWIND_RARE_END(WEAPONS_ROOT.getStringUrl() + "whirlwind/RareWeapons.txt"),
	WHIRLWIND_UNIQUE_END(WEAPONS_ROOT.getStringUrl() + "whirlwind/UniqueWeapons-5-Stars.txt"),
	WHIRLWIND_XTREME_END(WEAPONS_ROOT.getStringUrl() + "whirlwind/XLWeapons-6-Stars.txt"),

	NORMAL_ATTRIBUTE_PATH(
			PATH.URL_ROOT.getStringUrl() + PATH.TEXT_FILE_PATH.getStringUrl() + PATH.N_ATTRIBUTE_END.getStringUrl()),

	// Attributes
	SPECIAL_ATTRIBUTE_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + S_ATTRIBUTE_END.getStringUrl()),
	// Category
	CATEGORY_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + CATEGORY_END.getStringUrl()),
	// Character
	// --> Officer
	OFFICER_SHU_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + OFFICER_SHU_END.getStringUrl()),
	OFFICER_WU_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + OFFICER_WU_END.getStringUrl()),
	OFFICER_OTHER_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + OFFICER_OTHER_END.getStringUrl()),
	OFFICER_JIN_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + OFFICER_JIN_END.getStringUrl()),
	OFFICER_WEI_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + OFFICER_WEI_END.getStringUrl()),
	// --> SubOfficer
	SUBOFFICER_SHU_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + SUBOFFICER_SHU_END.getStringUrl()),
	SUBOFFICER_WU_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + SUBOFFICER_WU_END.getStringUrl()),
	SUBOFFICER_OTHER_PATH(
			URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + SUBOFFICER_OTHER_END.getStringUrl()),
	SUBOFFICER_JIN_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + SUBOFFICER_JIN_END.getStringUrl()),
	SUBOFFICER_WEI_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + SUBOFFICER_WEI_END.getStringUrl()),
	// Kingdoms
	KINGDOM_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + KINGDOM_END.getStringUrl()),
	// Rarity
	RARITY_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + RARITY_END.getStringUrl()),
	// Type
	TYPE_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + TYPE_END.getStringUrl()),
	// Weapons
	// --> Dasher
	DASHER_ATTRIBUTE_LEVEL_PATH(
			URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + DASHER_ATTRIBUTE_LEVEL_END.getStringUrl()),
	DASHER_NORMAL_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + DASHER_NORMAL_END.getStringUrl()),
	DASHER_RARE_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + DASHER_RARE_END.getStringUrl()),
	DASHER_UNIQUE_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + DASHER_UNIQUE_END.getStringUrl()),
	DASHER_XTREME_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + DASHER_XTREME_END.getStringUrl()),
	// --> Diver
	DIVER_ATTRIBUTE_LEVEL_PATH(
			URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + DIVER_ATTRIBUTE_LEVEL_END.getStringUrl()),
	DIVER_NORMAL_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + DIVER_NORMAL_END.getStringUrl()),
	DIVER_RARE_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + DIVER_RARE_END.getStringUrl()),
	DIVER_UNIQUE_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + DIVER_UNIQUE_END.getStringUrl()),
	DIVER_XTREME_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + DIVER_XTREME_END.getStringUrl()),
	// --> Shadow
	SHADOW_ATTRIBUTE_LEVEL_PATH(
			URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + SHADOW_ATTRIBUTE_LEVEL_END.getStringUrl()),
	SHADOW_NORMAL_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + SHADOW_NORMAL_END.getStringUrl()),
	SHADOW_RARE_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + SHADOW_RARE_END.getStringUrl()),
	SHADOW_UNIQUE_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + SHADOW_UNIQUE_END.getStringUrl()),
	SHADOW_XTREME_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + SHADOW_XTREME_END.getStringUrl()),
	// --> Whirlwind
	WHIRLWIND_ATTRIBUTE_LEVEL_PATH(
			URL_ROOT.getStringUrl() + TEXT_FILE_PATH + WHIRLWIND_ATTRIBUTE_LEVEL_END.getStringUrl()),
	WHIRLWIND_NORMAL_PATH(
			URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + WHIRLWIND_NORMAL_END.getStringUrl()),
	WHIRLWIND_RARE_PATH(URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + WHIRLWIND_RARE_END.getStringUrl()),
	WHIRLWIND_UNIQUE_PATH(
			URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + WHIRLWIND_UNIQUE_END.getStringUrl()),
	WHIRLWIND_XTREME_PATH(
			URL_ROOT.getStringUrl() + TEXT_FILE_PATH.getStringUrl() + WHIRLWIND_XTREME_END.getStringUrl());

	private final String str;

	PATH(String str) {
		this.str = str;
	}

	public String getStringUrl() {
		return str;
	}

	public static PATH[] getAllOfficersPath() {
		return new PATH[] { OFFICER_SHU_PATH, OFFICER_WU_PATH, OFFICER_WEI_PATH, OFFICER_JIN_PATH, OFFICER_OTHER_PATH };
	}

	public static PATH[] getSubOfficerPaths() {
		return new PATH[] { SUBOFFICER_SHU_PATH, SUBOFFICER_WU_PATH, SUBOFFICER_WEI_PATH, SUBOFFICER_JIN_PATH,
				SUBOFFICER_OTHER_PATH };
	}
	
	public static PATH[] getDasherWeaponsPaths() {
		return new PATH[] {
				DASHER_NORMAL_PATH, DASHER_RARE_PATH, DASHER_UNIQUE_PATH, DASHER_XTREME_PATH
		};
	}
	
	public static PATH[] getDiverWeaponsPaths() {
		return new PATH[] {
				DIVER_NORMAL_PATH, DIVER_RARE_PATH, DIVER_UNIQUE_PATH, DIVER_XTREME_PATH
		};
	}
	
	public static PATH[] getShadowWeaponsPaths() {
		return new PATH[] {
				SHADOW_NORMAL_PATH, SHADOW_RARE_PATH, SHADOW_UNIQUE_PATH, SHADOW_XTREME_PATH
		};
	}
	
	public static PATH[] getWhirlwindWeaponsPaths() {
		return new PATH[] {
				WHIRLWIND_NORMAL_PATH, WHIRLWIND_RARE_PATH, WHIRLWIND_UNIQUE_PATH, WHIRLWIND_XTREME_PATH
		};
	}
	
	public static PATH[] getNormalRarityWeaponsPaths() {
		return new PATH[] {
				DASHER_NORMAL_PATH, DIVER_NORMAL_PATH, SHADOW_NORMAL_PATH, WHIRLWIND_NORMAL_PATH,
		};
	}
	
	public static PATH[] getRareRarityWeaponsPaths() {
		return new PATH[] {
				DASHER_RARE_PATH, DIVER_RARE_PATH, SHADOW_RARE_PATH, WHIRLWIND_RARE_PATH,
		};
	}
	
	public static PATH[] getUniqueRarityWeaponsPaths() {
		return new PATH[] {
				DASHER_UNIQUE_PATH, DIVER_UNIQUE_PATH, SHADOW_UNIQUE_PATH, WHIRLWIND_UNIQUE_PATH,
		};
	}
	
	public static PATH[] getXtremeRarityWeaponsPaths() {
		return new PATH[] {
				DASHER_XTREME_PATH, DIVER_XTREME_PATH, SHADOW_XTREME_PATH, WHIRLWIND_XTREME_PATH,
		};
	}

}
