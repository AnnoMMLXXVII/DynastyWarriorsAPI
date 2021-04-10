package com.anno.warriors.dw8.manager;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.keys.OfficerKingdomKey;
import com.anno.warriors.dw8.shared.DW8Constants;
import com.anno.warriors.dw8.shared.DW8StaticObjects;

public class DW8ParsingImages implements DynastyWarriors8Object<DW8ParsingImages> {

	private static DynastyWarriors8Object<DW8ParsingImages> instance;
	private static Map<String, List<String>> officerImages = new HashMap<>();
	private static Map<OfficerKingdomKey, List<String>> weaponImages = new HashMap<>();
	private static Map<OfficerKingdomKey, Map<String, String>> officerNameToWeaponName = new HashMap<>();
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
		DW8MappingObjects<String, List<String>, String> mappingObject = new DW8MappingObjects<>(officerImages);
		for (int i = 0; i < file.length; i++) {
			shortName = formatOfficerImageFileNameForKey(file[i].getName());
			mappingObject.mapKeyValueWithList(shortName, file[i].getPath());
		}
		officerImages = mappingObject.getMapObject();
	}

	private String formatOfficerImageFileNameForKey(String fileName) {
		String[] firstParse = fileName.split("\\.");
		String removeLastChar = firstParse[0].substring(0, firstParse[0].length() - 2);
		String replaceUnderScore = removeLastChar.replace("_", " ");
		return replaceUnderScore.trim();
	}

	private void readWeaponImagesFolder() {
		readWeaponsImagesByPath(DW8StaticObjects.getFiveStarPathWeaponImageList());
		readWeaponsImagesByPath(DW8StaticObjects.getSixStarPathWeaponImageList());
	}

	private void readWeaponsImagesByPath(String[] paths) {
		File folder = null;
		File[] file = null;
		Kingdom kingdom;
		DW8MappingObjects<OfficerKingdomKey, List<String>, String> imageMappingObject = new DW8MappingObjects<>(
				weaponImages);
		DW8MappingObjects<OfficerKingdomKey, Map<String, String>, String> officerWeaponNameMappingObject = new DW8MappingObjects<>(
				officerNameToWeaponName);
		for (String s : paths) {
			kingdom = getKingdomFromPath(s);
			folder = new File(s);
			file = folder.listFiles();
			for (int i = 0; i < file.length; i++) {
				weaponName = formatWeaponImageFileName(file[i].getName());
				imageMappingObject.mapKeyValueWithList(new OfficerKingdomKey(key, kingdom), file[i].getPath());
				officerWeaponNameMappingObject.mapKeyValueWithMap(new OfficerKingdomKey(key, kingdom), weaponName,
						file[i].getPath());
			}
			weaponImages = imageMappingObject.getMapObject();
			officerNameToWeaponName = officerWeaponNameMappingObject.getMapObject();
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

	private Kingdom getKingdomFromPath(String path) {
		String[] splitByForwardSlash = path.split("/");
		String str = splitByForwardSlash[splitByForwardSlash.length - 1];
		String caseKingdom = str.substring(0, 1).toUpperCase() + str.substring(1);
		return Kingdom.returnCorrectEnum(caseKingdom.trim());
	}

}
