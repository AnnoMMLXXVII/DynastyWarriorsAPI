package com.anno.warriors.dw8.manager.images;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.images.model.CharacterImage;
import com.anno.warriors.dw8.images.model.DynastyWarriors8Image;
import com.anno.warriors.dw8.images.model.WeaponImage;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;
import com.anno.warriors.dw8.manager.files.ParsingFiles;
import com.anno.warriors.dw8.shared.DW8Constants;
import com.anno.warriors.dw8.utils.FileStreamHandler;
import com.anno.warriors.dw8.utils.WarriorsParingException;

public class ParsingImages implements DynastyWarriors8Object<ParsingImages> {

	private static Logger logger = LogManager.getLogger();
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
		try (BufferedReader br = new FileStreamHandler(DW8Constants.OFFICER_IMAGE_CSV).getBufferedReader()) {
			String raw = "";
			while ((raw = br.readLine()) != null) {
				String[] line = raw.split(DW8Constants.Split.COMMA.getValue());
				officerImages.get(line[0].trim()).add(new CharacterImage(line[0].trim(), line[1].trim()));
			}
		} catch (IOException ex) {
			logger.error("Attempted to read from CharacterImages.csv but FILE NOT FOUND!");
			throw new WarriorsParingException(ex.getMessage());
		} catch (NullPointerException ex) {
			throw new WarriorsParingException(ex.getMessage());
		}
		logger.info("Officer CSV Image mapped");
	}

	private void readWeaponImagesFolder() {
		readWeaponsImagesByPath();
	}

	private void readWeaponsImagesByPath() {
		try (BufferedReader br = new FileStreamHandler(DW8Constants.WEAPON_IMAGE_CSV).getBufferedReader()) {
			String raw = "";
			while ((raw = br.readLine()) != null) {
				String[] line = raw.split(DW8Constants.Split.COMMA.getValue());
				weaponImages.get(Types.returnCorrectEnum(line[1].trim()))
						.add(new WeaponImage(line[0].trim(), line[2].trim()));
			}
		} catch (IOException ex) {
			logger.error("Attempted to read from WeaponImagesMap.csv but FILE NOT FOUND!");
			throw new WarriorsParingException(ex.getMessage());
		} catch (NullPointerException ex) {
			throw new WarriorsParingException(ex.getMessage());
		}
//		printImage(weaponImages);
		logger.info("Weapon CSV Image mapped");
	}

	private void printImage(Map<?, List<DynastyWarriors8Image>> images) {
		images.forEach((e, v) -> {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("%s -> {\n\t", e));
			v.stream().forEach(i -> {
				sb.append(String.format("\"%s\":\"%s\",\n\t", i.getName(), i.getImage()));
			});
			sb.append(String.format("%s\n", "}"));
			logger.info("{}\n", sb.toString());

		});
	}

//	public static void main(String... args) {
//		temp();
//	}
//
//	public static void temp() {
//		final String assetPrefix = "assets/Weapons";
//		String imgTags = ("<img src=\"%s\" alt=\"%s\">");
//		final String star = "6-Star";
//		Kingdom[] kingdoms = Kingdom.values();
//		for (Kingdom k : kingdoms) {
//			final String kingdom = k.getValue().toLowerCase();
//			// Use try-with-resources to ensure the stream is closed automatically
//			try (Stream<Path> paths = Files.list(Paths.get(DW8Constants.WEAPON_IMAGES_6_STAR_PATH + kingdom + "/"))) {
//				paths.forEach(path -> {
//					// Print the file name
//					String src = String.format("%s/%s/%s/%s", assetPrefix, star, kingdom, path.getFileName());
//					String tagLine = String.format(imgTags, src, path.getFileName());
//					logger.info("{}\n", tagLine);
//				});
//			} catch (IOException e) {
//				System.err.println("Error reading directory: " + e.getMessage());
//			}
//		}
//	}

}
