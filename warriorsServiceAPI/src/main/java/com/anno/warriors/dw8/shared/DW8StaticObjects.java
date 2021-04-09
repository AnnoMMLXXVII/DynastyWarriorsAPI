package com.anno.warriors.dw8.shared;

public class DW8StaticObjects {

	public static String[] getFiveStarPathWeaponImageList() {
		return new String[] { DW8Constants.WEAPON_IMAGES_JIN_5_STAR_PATH, DW8Constants.WEAPON_IMAGES_SHU_5_STAR_PATH,
				DW8Constants.WEAPON_IMAGES_WU_5_STAR_PATH, DW8Constants.WEAPON_IMAGES_WEI_5_STAR_PATH,
				DW8Constants.WEAPON_IMAGES_OTHER_5_STAR_PATH };
	}

	public static String[] getSixStarPathWeaponImageList() {
		return new String[] { DW8Constants.WEAPON_IMAGES_JIN_6_STAR_PATH, DW8Constants.WEAPON_IMAGES_SHU_6_STAR_PATH,
				DW8Constants.WEAPON_IMAGES_WU_6_STAR_PATH, DW8Constants.WEAPON_IMAGES_WEI_6_STAR_PATH,
				DW8Constants.WEAPON_IMAGES_OTHER_6_STAR_PATH };
	}

	public static String[] getAllOfficerPathList() {
		return new String[] { DW8Constants.OFFICER_JIN_FILE, DW8Constants.OFFICER_OTHER_FILE,
				DW8Constants.OFFICER_SHU_FILE, DW8Constants.OFFICER_WEI_FILE, DW8Constants.OFFICER_WU_FILE };
	}

	public static String[] getAllSubOfficerPathList() {
		return new String[] { DW8Constants.SUBOFFICER_JIN_FILE, DW8Constants.SUBOFFICER_OTHER_FILE,
				DW8Constants.SUBOFFICER_SHU_FILE, DW8Constants.SUBOFFICER_WEI_FILE, DW8Constants.SUBOFFICER_WU_FILE };
	}
}
