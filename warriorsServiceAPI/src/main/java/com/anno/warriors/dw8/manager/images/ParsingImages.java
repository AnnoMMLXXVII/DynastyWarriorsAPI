package com.anno.warriors.dw8.manager.images;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.images.model.CharacterImage;
import com.anno.warriors.dw8.images.model.DynastyWarriors8Image;
import com.anno.warriors.dw8.images.model.WeaponImage;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.manager.files.ParsingFiles;
import com.anno.warriors.dw8.shared.DW8Constants;

public class ParsingImages implements DynastyWarriors8Object<ParsingImages> {

	private static Logger logger = LoggerFactory.getLogger(ParsingImages.class);
	private static DynastyWarriors8Object<ParsingImages> instance;
	private static Map<String, List<DynastyWarriors8Image>> officerImages = new HashMap<>();
	private static Map<String, String> weaponNamePathMap = new HashMap<>();
	private static Map<Types, List<DynastyWarriors8Image>> weaponImages = new HashMap<>();

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

	private ParsingImages() {
		initializeWeaponImageMapWithTypes();
		initializeOfficerImageMapWithNames();
		readOfficerImageFolder();
		readWeaponImagesFolder();
	}

	private void initializeWeaponImageMapWithTypes() {
		List<Types> types = Arrays.asList(Types.values());
		for (Types t : types) {
			weaponImages.put(t, new ArrayList<>());
		}
	}

	private void initializeOfficerImageMapWithNames() {
		for (CharacterInterface<Character> c : ParsingFiles.getAllOfficers()) {
			officerImages.put(c.getName().trim(), new ArrayList<>());
		}
	}

	public static Map<String, List<DynastyWarriors8Image>> getOfficerImages() {
		return officerImages;
	}

	public static Map<Types, List<DynastyWarriors8Image>> getWeaponImages() {
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
		File file = new File(DW8Constants.OFFICER_IMAGE_CSV);
		file.setWritable(true, true);
		file.setReadable(true, true);
		file.setExecutable(true, true);
		try (Scanner z = new Scanner(new FileReader(file))) {
			while (z.hasNextLine()) {
				String[] line = z.nextLine().split(DW8Constants.Split.COMMA.getValue());
				try {
					officerImages.get(line[0].trim()).add(new CharacterImage(line[0].trim(), line[1].trim()));
				} catch (NullPointerException n) {
					System.err.println("COULD NOT FIND : " + line[0].trim());
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("Attempted to read from CharacterImages.csv but FILE NOT FOUND!");
		}
		file.setWritable(false, true);
		file.setReadable(false, true);
		file.setExecutable(false, true);

		logger.info("Officer CSV Image mapped");
	}

	private void readWeaponImagesFolder() {
		readWeaponsImagesByPath(DW8Constants.WEAPON_IMAGE_CSV);
	}

	private void readWeaponsImagesByPath(String path) {
		File file = new File(path);
		file.setWritable(true, true);
		file.setReadable(true, true);
		file.setExecutable(true, true);
		try (Scanner z = new Scanner(new FileReader(file))) {
			while (z.hasNextLine()) {
				String[] line = z.nextLine().split(DW8Constants.Split.COMMA.getValue());
				weaponImages.get(Types.returnCorrectEnum(line[1].trim()))
						.add(new WeaponImage(line[0].trim(), line[2].trim()));
			}

		} catch (FileNotFoundException e) {
			logger.error("Attempted to read from WeaponImagesMap.csv but FILE NOT FOUND!");
		}
		file.setWritable(false, true);
		file.setReadable(false, true);
		file.setExecutable(false, true);
//		printImage(weaponImages);
		logger.info("Weapon CSV Image mapped");
	}

	private void printImage(Map<?, List<DynastyWarriors8Image>> images) {
		images.forEach((e, v) -> {
			System.out.printf("%s -> {\n\t", e);
			v.stream().forEach(i -> {
				System.out.printf("\"%s\":\"%s\",\n\t", i.getName(), i.getImage());
			});
			System.out.printf("%s\n", "}");
		});
	}

}
