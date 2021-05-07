package com.anno.warriors.dw8.manager.weapons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.warriors.dw8.enums.DW8Enumeration;
import com.anno.warriors.dw8.enums.affinity.Affinity;
import com.anno.warriors.dw8.enums.category.Category;
import com.anno.warriors.dw8.enums.rarity.Rarity;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.keys.WeaponName_TypesAttributesKey;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.manager.MappingObjectsWithReference;
import com.anno.warriors.dw8.shared.DW8Constants;
import com.anno.warriors.dw8.shared.DW8StaticObjects;
import com.anno.warriors.dw8.weapons.model.Extreme;
import com.anno.warriors.dw8.weapons.model.Normal;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;
import com.anno.warriors.dw8.weapons.slots.AttributeSlot;

public class WeaponParseManager implements DynastyWarriors8Object<WeaponParseManager> {

	private static Logger logger = LoggerFactory.getLogger(WeaponParseManager.class);

	private static DynastyWarriors8Object<WeaponParseManager> instance;
	private static WeaponInterface<Weapon> temp = null;
	private static List<WeaponInterface<Weapon>> weapons = new ArrayList<>();
	private static List<String> weaponNames = new ArrayList<>();
	private static Map<Category, List<WeaponInterface<Weapon>>> categoryWeaponsMap = new HashMap<>();
	private static Map<Types, List<WeaponInterface<Weapon>>> typesWeaponListMap = new HashMap<>();
	private static Map<String, List<WeaponInterface<Weapon>>> weaponNameWeaponsMap = new HashMap<>();

	public static DynastyWarriors8Object<WeaponParseManager> getInstance() {
		if (instance == null) {
			synchronized (WeaponParseManager.class) {
				if (instance == null) {
					return new WeaponParseManager();
				}
			}
		}
		return instance;
	}

	private WeaponParseManager() {
//		Weapon MetaData
//		 --> Rarity (Normal, Rare, Unique, Xtreme), Category (Dasher, Diver, Shadow_Sprinter, Whirlwind_Master)
//		Weapon Characteristics
//			-> Normal
//		 		--> Name (String), Attack Power (Integer), Length (String), Star (Integer), Type (String)
//			-> Rare, Unique, XLWeapons (EXTREME)
//				--> Name (String), Attack power (Integer), Affinity(String), Star(Integer), Type (String)
//		WeaponTypeKey - Value
//		 --> (WeaponName, Type) - Weapon
//		----------------------------------------------------------------------------------------------------
//		Weapon Linking to Character
//			-> Using WeaponTypeKey -> Type to link to Character -> Type

		scanFiles(DW8StaticObjects.getDasherWeaponsFiles());
		scanFiles(DW8StaticObjects.getDiverWeaponsFiles());
		scanFiles(DW8StaticObjects.getShadowWeaponsFiles());
		scanFiles(DW8StaticObjects.getWhirlWindWeaponsFiles());

//		System.out.println(WeaponAttributeParseMananger.getWeapNameTypesKeyAttributesMap().toString());
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
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

	public static Map<Types, List<WeaponInterface<Weapon>>> getTypesWeaponListMap() {
		return typesWeaponListMap;
	}

	public static Map<String, List<WeaponInterface<Weapon>>> getWeaponNameWeaponsMap() {
		return weaponNameWeaponsMap;
	}

	private static void scanFiles(String... path) {
		int i = 1;
		File[] file = new File[path.length];
		for (int j = 0; j < path.length; j++) {
			file[j] = new File(path[j]);
		}
		MappingObjectsWithReference<Category, List<WeaponInterface<Weapon>>, WeaponInterface<Weapon>> categoryMappingObject = new MappingObjectsWithReference<>(
				categoryWeaponsMap);
		MappingObjectsWithReference<String, List<WeaponInterface<Weapon>>, WeaponInterface<Weapon>> weaponNameMappingObject = new MappingObjectsWithReference<>(
				weaponNameWeaponsMap);
		MappingObjectsWithReference<Types, List<WeaponInterface<Weapon>>, WeaponInterface<Weapon>> typesWeaponsListObject = new MappingObjectsWithReference<>(
				typesWeaponListMap);
		parseWeaponAttributesFile(file, path);
		try (Scanner z = new Scanner(new FileReader(file[i]))) {
			logger.info("Reading file - " + path[i]);
			while (z.hasNextLine()) {
				String line = z.nextLine();
				String[] arr = line.split(DW8Constants.Split.COMMA.getValue());
				temp = parseNormalWeapons(file[i].getName(), arr);
				weapons.add(temp);
				weaponNames.add(temp.getName());
//				typesWeaponListMap.put(temp.getType(), temp);
				typesWeaponsListObject.mapKeyValueWithList(temp.getType(), temp);
				categoryMappingObject.mapKeyValueWithList(temp.getCategory(), temp);
				weaponNameMappingObject.mapKeyValueWithList(temp.getName(), temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (i = 2; i < path.length; i++) {
			try (Scanner z = new Scanner(new FileReader(file[i]))) {
				logger.info("Reading file - " + path[i]);
				while (z.hasNextLine()) {
					String line = z.nextLine();
					String[] arr = line.split(DW8Constants.Split.COMMA.getValue());
					temp = parseExtremeWeapons(file[i].getName(), arr);
					WeaponName_TypesAttributesKey key = new WeaponName_TypesAttributesKey(temp.getName(),
							temp.getType());
					List<AttributeSlot> slots = WeaponAttributeParseManager.getWeapNameTypesKeyAttributesMap().get(key);
					temp.setAttributeSlots(slots);
					weapons.add(temp);
					weaponNames.add(temp.getName());
					typesWeaponsListObject.mapKeyValueWithList(temp.getType(), temp);
					categoryMappingObject.mapKeyValueWithList(temp.getCategory(), temp);
					weaponNameMappingObject.mapKeyValueWithList(temp.getName(), temp);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private static void parseWeaponAttributesFile(File[] file, String[] path) {
		try (Scanner z = new Scanner(new FileReader(file[0]))) {
			logger.info("Reading Weapon Attribute file " + path[0]);
			WeaponAttributeParseManager.readWeaponAttributesFile(path[0]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static WeaponInterface<Weapon> parseNormalWeapons(String fileName, String... args) {
		Types temp = Types.returnCorrectEnum(args[4].trim());
		WeaponInterface<Weapon> local = new Normal(args[0].trim(), Integer.parseInt(args[1].trim()),
				Integer.parseInt(args[3].trim()), temp, args[2].trim());
		local.setRarity((Rarity) parsePathToGetEnum(fileName, true));
		local.setCategory((Category) parsePathToGetEnum(fileName, false));
		return local;

	}

	private static WeaponInterface<Weapon> parseExtremeWeapons(String fileName, String... args) {
		WeaponInterface<Weapon> local = new Extreme(args[0].trim(), Integer.parseInt(args[1].trim()),
				Integer.parseInt(args[3].trim()), Types.returnCorrectEnum(args[4].trim()),
				Affinity.returnCorrectEnum(args[2].trim()));
		local.setRarity((Rarity) parsePathToGetEnum(fileName, true));
		local.setCategory((Category) parsePathToGetEnum(fileName, false));
		return local;
	}

	private static DW8Enumeration<?> parsePathToGetEnum(String path, boolean isRarity) {
		String[] splitByPeriod = path.split(DW8Constants.Split.PERIOD.getValue());
		String[] splitByDash = splitByPeriod[0].split(DW8Constants.Split.HYPHEN.getValue());
		if (splitByDash[1].contains(DW8Constants.Split.UNDER_SCORE.getValue())) {
			splitByDash[1] = splitByDash[1].replace(DW8Constants.Split.UNDER_SCORE.getValue(),
					DW8Constants.Split.WHITE_SPACE.getValue());
		}
		return (isRarity) ? Rarity.returnCorrectEnum(splitByDash[0])
				: Category.returnCorrectEnum(splitByDash[1].trim());
	}

}
