package com.anno.warriors.dw8.manager.images;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.keys.OfficerKingdomKey;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.manager.MappingObjectsWithReference;
import com.anno.warriors.dw8.shared.DW8Constants;
import com.anno.warriors.dw8.shared.DW8StaticObjects;

@SuppressWarnings("unused")
public class ParsingImages implements DynastyWarriors8Object<ParsingImages> {

	private static Logger logger = LoggerFactory.getLogger(ParsingImages.class);
	private static DynastyWarriors8Object<ParsingImages> instance;
	private static Map<String, List<String>> officerImages = new HashMap<>();
	private static Map<String, String> weaponNamePathMap = new HashMap<>();
	private static Map<OfficerKingdomKey, List<String>> weaponImages = new HashMap<>();
	private static Map<OfficerKingdomKey, Map<String, String>> officerNameToWeaponName = new HashMap<>();
	private static Map<Kingdom, List<CharacterInterface<Character>>> mappedCharsByKingom;
	private String weaponName;
	private String key;

	public static DynastyWarriors8Object<ParsingImages> getInstance() {
		if (instance == null) {
			synchronized (ParsingImages.class) {
				if (instance == null) {
					logger.info("ParsingImages instantiated");
					return new ParsingImages();
				}
			}
		}
		return instance;
	}

//	public static void main(String args[]) {
////		CharacterParseManager.getInstance();
////		mappedCharsByKingom = CharacterParseManager.getKingdomCharacterMap();
//		new ParsingImages();
//	}

	private ParsingImages() {
		readOfficerImageFolder();
		logger.info("finished reading OfficerImageFolder");
		readWeaponImagesFolder();
		logger.info("finished reading WeaponImagesFolder");
	}

	public static Map<String, List<String>> getOfficerImages() {
		return officerImages;
	}

	public static Map<OfficerKingdomKey, List<String>> getWeaponImages() {
		return weaponImages;
	}

	public static Map<String, String> getWeaponNamePathMap() {
		return weaponNamePathMap;
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
	}

	private void readOfficerImageFolder() {
		File folder = new File(DW8Constants.OFFICER_IMAGES_PATH);
		File[] file = folder.listFiles();
		String shortName = "";
		MappingObjectsWithReference<String, List<String>, String> mappingObject = new MappingObjectsWithReference<>(
				officerImages);
		for (int i = 0; i < file.length; i++) {
			shortName = formatOfficerImageFileNameForKey(file[i].getName());
			mappingObject.mapKeyValueWithList(shortName, file[i].getPath());
		}
		logger.info("Officer Images mapped");
	}

	private String formatOfficerImageFileNameForKey(String fileName) {
		String[] firstParse = fileName.split("\\.");
		String removeLastChar = firstParse[0].substring(0, firstParse[0].length() - 2);
		String replaceUnderScore = removeLastChar.replace("_", " ");
		return replaceUnderScore.trim();
	}

	private void readWeaponImagesFolder() {
//		readWeaponsImagesByPath(DW8StaticObjects.getOneStarPathWeaponImageList());
//		readWeaponsImagesByPath(DW8StaticObjects.getTwoStarPathWeaponImageList());
//		readWeaponsImagesByPath(DW8StaticObjects.getThreeStarPathWeaponImageList());
//		readWeaponsImagesByPath(DW8StaticObjects.getFourStarPathWeaponImageList());
		readWeaponsImagesByPath(DW8StaticObjects.getFiveStarPathWeaponImageList());
//		readWeaponsImagesByPath(DW8StaticObjects.getSixStarPathWeaponImageList());
		hyphenateKeys();
	}

	private void readWeaponsImagesByPath(String[] paths) {
		File folder = null;
		File[] file = null;
		Kingdom kingdom;
		MappingObjectsWithReference<OfficerKingdomKey, List<String>, String> imageMappingObject = new MappingObjectsWithReference<>(
				weaponImages);
//		MappingObjects<OfficerKingdomKey, Map<String, String>, String> officerWeaponNameMappingObject = new MappingObjects<>(
//				officerNameToWeaponName);
		for (String s : paths) {
			kingdom = getKingdomFromPath(s);
//			List<CharacterInterface<Character>> characters = mappedCharsByKingom.get(kingdom);
//			Optional<CharacterInterface<Character>> opt = null;
//			CharacterInterface<Character> character = null;
			folder = new File(s);
			file = folder.listFiles();
			for (int i = 0; i < file.length; i++) {
				weaponName = formatWeaponImageFileName(file[i].getName());
				imageMappingObject.mapKeyValueWithList(new OfficerKingdomKey(key, kingdom), file[i].getPath());
//				officerWeaponNameMappingObject.mapKeyValueWithMap(new OfficerKingdomKey(key, kingdom), weaponName,
//						file[i].getPath());
				String fileLastName = formatWeaponImageFileNameToGetLastName(file[i].getName());
//				characters.forEach(e -> System.out.printf("%s, ", getCharactersLastName(e.getName())));
//				System.out.println();
//				opt = characters.stream().filter(e -> getCharactersLastName(e.getName()).equals(fileLastName))
//						.findFirst();
//				if (opt.isPresent()) {
//					character = opt.get();
//					System.out.printf("[%d]\t%-5s - %-18s - %s : %s\n", i, kingdom, weaponName, character.getName(),
//							fileLastName);
//				} else {
//					System.out.printf("[%d]\t%-5s - %-18s - %s\n", i, kingdom, weaponName, fileLastName);
//				}
				weaponNamePathMap.put(weaponName, file[i].getPath());
			}
			weaponImages = imageMappingObject.getMapObject();
//			officerNameToWeaponName = officerWeaponNameMappingObject.getMapObject();
			logger.info("Parsed Images from " + s);

		}
	}

	private void hyphenateKeys() {
		addHyphenToKey("Nine Layered Heaven", "Nine-layered Heaven");
		addHyphenToKey("Bronze Studded Staff", "Bronze-studded Staff");
		addHyphenToKey("Light Breaking Staff", "Light-Breaking Staff");
	}

	private String getCharactersLastName(String lastName) {
		return (lastName.contains(" ")) ? lastName.split(" ")[1].trim() : lastName.trim();
	}

	private String formatWeaponImageFileName(String fileName) {
		String[] splitByPeriod = fileName.split("\\.");
		String[] splitByHyphen = splitByPeriod[0].split("-");
		key = splitByHyphen[splitByHyphen.length - 1];
		return formatWeaponNameConditionally(splitByHyphen[0]).trim();
	}

	private String formatWeaponImageFileNameToGetLastName(String fileName) {
		String[] splitByPeriod = fileName.split("\\.");
		String[] splitByHyphen = splitByPeriod[0].split("-");
		return splitByHyphen[splitByHyphen.length - 1].trim();
	}

	private String formatWeaponNameConditionally(String preFormattedName) {
		return preFormattedName.contains("_") ? preFormattedName.replace("_", " ") : preFormattedName;
	}

	private void addHyphenToKey(String original, String key) {
		String temp = weaponNamePathMap.get(original);
		if (temp == null) {
			return;
		}
		weaponNamePathMap.remove(original);
		weaponNamePathMap.put(key, temp);
	}

	private Kingdom getKingdomFromPath(String path) {
		String[] splitByForwardSlash = path.split("/");
		String str = splitByForwardSlash[splitByForwardSlash.length - 1];
		String caseKingdom = str.substring(0, 1).toUpperCase() + str.substring(1);
		return Kingdom.returnCorrectEnum(caseKingdom.trim());
	}

}
