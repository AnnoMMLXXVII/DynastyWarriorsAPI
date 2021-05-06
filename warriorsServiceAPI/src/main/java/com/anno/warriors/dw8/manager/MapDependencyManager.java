package com.anno.warriors.dw8.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;

public class MapDependencyManager implements DynastyWarriors8Object<MapDependencyManager> {

	private static Logger logger = LoggerFactory.getLogger(MapDependencyManager.class);
	private static DynastyWarriors8Object<MapDependencyManager> instance;

	public static DynastyWarriors8Object<MapDependencyManager> getInstance() {
		if (instance == null) {
			synchronized (MapDependencyManager.class) {
				if (instance == null) {
					return new MapDependencyManager();
				}
			}
		}
		return instance;
	}

	private MapDependencyManager() {
		mapWeaponImageToWeapons();
		logger.info("Mapped Weapon Images to Weapon Object");
		mapDependenciesToOfficers();
		logger.info("Mapped Image and Weapon to Character Object");
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
	}

	@SuppressWarnings("null")
	private static void mapWeaponImageToWeapons() {
		List<String> weaponNames = DW8Structures.getWeaponNames();
		Map<String, String> weaponImages = DW8Structures.getMappedWeaponImagesPathMap();
		Map<String, List<WeaponInterface<Weapon>>> weaponsMapped = DW8Structures.getWeaponNameWeaponsMap();
		List<WeaponInterface<Weapon>> weapons = new ArrayList<>();

//		weaponImages.keySet().forEach(e -> System.out.print(e + " "));

		for (String s : weaponImages.keySet()) {
			System.out.printf("Mapping for --> %s ", s);
			weapons = weaponsMapped.get(s);
			if (weapons != null) {
				if (weapons.get(0).getImage().isEmpty() || weapons.get(0).getImage() == null) {
					System.err.printf(":: ![%s] NOT FOUND\n", s);
				} else {
					for (WeaponInterface<Weapon> w : weapons) {
						if (w.getName().equals(s)) {
							w.setImage(weaponImages.get(s));
						}
					}
				}
				System.out.println();
			} else {
				System.err.printf(":: ![%s] NOT FOUND\n", s);
			}
		}
	}

	private static void mapDependenciesToOfficers() {
		Map<String, List<String>> officerImages = DW8Structures.getOfficerImages();
		Map<Types, List<WeaponInterface<Weapon>>> weaponsMapped = DW8Structures.getTypeWeaponKeyKeyMap();

		for (CharacterInterface<Character> c : DW8Structures.getOfficers()) {
//			if (c.getWeaponType() != null) {
			c.setWeapons(weaponsMapped.get(c.getWeaponType()));
			c.setImage(officerImages.get(c.getName()));
//			}
		}
	}

}
