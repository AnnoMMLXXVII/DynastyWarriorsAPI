package com.anno.warriors.dw8.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.keys.OfficerKingdomKey;
import com.anno.warriors.dw8.shared.DW8Constants;

public class DW8ParsingImages implements DynastyWarriors8Object<DW8ParsingImages> {

	private static DynastyWarriors8Object<DW8ParsingImages> instance;
	private static Map<String, List<String>> officerImages = new HashMap<>();
	private static Map<OfficerKingdomKey, List<String>> weaponImages = new HashMap<>();
	private static Map<OfficerKingdomKey, Map<String, String>> officerNameToWeaponName = new HashMap<>();
	private static String[] fiveStarPath = { DW8Constants.WEAPON_IMAGES_JIN_5_STAR_PATH,
			DW8Constants.WEAPON_IMAGES_SHU_5_STAR_PATH, DW8Constants.WEAPON_IMAGES_WU_5_STAR_PATH,
			DW8Constants.WEAPON_IMAGES_WEI_5_STAR_PATH, DW8Constants.WEAPON_IMAGES_OTHER_5_STAR_PATH };
	private static String[] sixStarPath = { DW8Constants.WEAPON_IMAGES_JIN_6_STAR_PATH,
			DW8Constants.WEAPON_IMAGES_SHU_6_STAR_PATH, DW8Constants.WEAPON_IMAGES_WU_6_STAR_PATH,
			DW8Constants.WEAPON_IMAGES_WEI_6_STAR_PATH, DW8Constants.WEAPON_IMAGES_OTHER_6_STAR_PATH };
	private String weaponName;
	private String key;

	public static DynastyWarriors8Object<DW8ParsingImages> getInstance() {
		if (instance == null) {
			synchronized (DW8ParsingImages.class) {
				if (instance == null) {
					return new DW8ParsingImages();
				}
			}
		}
		return instance;
	}

	private DW8ParsingImages() {
		readOfficerImageFolder();
		readWeaponImagesFolder();
	}

	public static Map<String, List<String>> getOfficerImages() {
		return officerImages;
	}

	public static Map<OfficerKingdomKey, List<String>> getWeaponImages() {
		return weaponImages;
	}

	public static Map<OfficerKingdomKey, Map<String, String>> getOfficerWeaponMap() {
		return officerNameToWeaponName;
	}

	@Override
	public DW8ParsingImages getManagerType() {
		return this;
	}

	private void readOfficerImageFolder() {
		File folder = new File(DW8Constants.OFFICER_IMAGES_PATH);
		File[] file = folder.listFiles();
		String shortName = "";
		for (int i = 0; i < file.length; i++) {
			shortName = formatOfficerImageFileNameForKey(file[i].getName());
			mappingKeyAndValue(shortName, file[i].getPath(), officerImages);
		}
	}

	private String formatOfficerImageFileNameForKey(String fileName) {
		String[] firstParse = fileName.split("\\.");
		String removeLastChar = firstParse[0].substring(0, firstParse[0].length() - 2);
		String replaceUnderScore = removeLastChar.replace("_", " ");
		return replaceUnderScore.trim();
	}

	private void readWeaponImagesFolder() {
		readWeaponsImagesByPath(fiveStarPath);
		readWeaponsImagesByPath(sixStarPath);
	}

	private void readWeaponsImagesByPath(String[] paths) {
		File folder = null;
		File[] file = null;
		Kingdom kingdom;
		for (String s : paths) {
			kingdom = getKingdomFromPath(s);
			folder = new File(s);
			file = folder.listFiles();
			for (int i = 0; i < file.length; i++) {
				weaponName = formatWeaponImageFileName(file[i].getName());
				mappingKeyAndValue(new OfficerKingdomKey(key, kingdom), file[i].getPath(), weaponImages);
				mappingKeyAndValue(new OfficerKingdomKey(key, kingdom), weaponName, file[i].getPath(),
						officerNameToWeaponName);
			}
		}
	}

	private String formatWeaponImageFileName(String fileName) {
		String[] splitByPeriod = fileName.split("\\.");
		String[] splitByHyphen = splitByPeriod[0].split("-");
		key = splitByHyphen[splitByHyphen.length - 1];
		return formatWeaponNameConditionally(splitByHyphen[0]);
	}

	private String formatWeaponNameConditionally(String preFormattedName) {
		return preFormattedName.contains("_") ? preFormattedName.replace("_", " ") : preFormattedName;
	}

	private void mappingKeyAndValue(String key, String value, Map<String, List<String>> map) {
		List<String> tempList;
		if (map.containsKey(key)) {
			tempList = map.get(key);
			tempList.add(value);
			map.put(key, tempList);
		} else {
			tempList = new ArrayList<>();
			tempList.add(value);
			map.put(key, tempList);
		}
	}

	private void mappingKeyAndValue(OfficerKingdomKey key, String value, Map<OfficerKingdomKey, List<String>> map) {
		List<String> tempList;
		if (map.containsKey(key)) {
			tempList = map.get(key);
			tempList.add(value);
			map.put(key, tempList);
		} else {
			tempList = new ArrayList<>();
			tempList.add(value);
			map.put(key, tempList);
		}
	}

	private void mappingKeyAndValue(OfficerKingdomKey key, String value, String value2,
			Map<OfficerKingdomKey, Map<String, String>> map) {
		Map<String, String> tempMap;
		if (map.containsKey(key)) {
			tempMap = map.get(key);
			tempMap.put(value, value2);
			map.put(key, tempMap);

		} else {
			tempMap = new HashMap<>();
			tempMap.put(value, value2);
			map.put(key, tempMap);
		}
	}

	private Kingdom getKingdomFromPath(String path) {
		String[] splitByForwardSlash = path.split("/");
		String str = splitByForwardSlash[splitByForwardSlash.length - 1];
		String caseKingdom = str.substring(0, 1).toUpperCase() + str.substring(1);
		return Kingdom.returnCorrectEnum(caseKingdom.trim());
	}

}
