package com.anno.warriors.dw8.manager;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.characters.model.Officer;
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

	private static void mapWeaponImageToWeapons() {
		List<String> weaponNames = DW8Structures.getWeaponNames();
		Map<String, String> weaponImages = DW8Structures.getMappedWeaponImagesPathMap();
		Map<String, List<WeaponInterface<Weapon>>> weaponsMapped = DW8Structures.getWeaponNameWeaponsMap();
		List<WeaponInterface<Weapon>> weapons;

		for (String s : weaponNames) {
			weapons = weaponsMapped.get(s);
			for (WeaponInterface<Weapon> w : weapons) {
				if (w.getName().equalsIgnoreCase(s)) {
					w.setImage(weaponImages.get(s));
				}
			}
		}
	}

	private static void mapDependenciesToOfficers() {
		List<CharacterInterface<Character>> officers = DW8Structures.getOfficers();
		Map<String, List<String>> officerImages = DW8Structures.getOfficerImages();
		Map<Types, List<WeaponInterface<Weapon>>> weaponsMapped = DW8Structures.getTypeWeaponKeyKeyMap();

		for (CharacterInterface<Character> c : officers) {
			if (c.getWeaponType() != null && c instanceof Officer) {
				c.setWeapons(weaponsMapped.get(c.getWeaponType()));
				c.setImage(officerImages.get(c.getName()));
			}
		}

	}

}
