package com.anno.warriors.dw8.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.images.model.DynastyWarriors8Image;
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
		Map<Types, List<DynastyWarriors8Image>> weaponImages = DW8Structures.getWeaponImages();
		List<WeaponInterface<Weapon>> weapons = DW8Structures.getWeapons();

		weapons.forEach(w -> {
			String name = w.getName();
			Types type = w.getType();
			weaponImages.forEach((e, v) -> {
				if (e.equals(type)) {
					v.forEach(s -> {
						if (s.getName().equals(name)) {
							w.setImage(s);
						}
					});
				}
			});
		});

	}

	private static void mapDependenciesToOfficers() {
		Map<String, List<DynastyWarriors8Image>> officerImages = DW8Structures.getOfficerImages();
		Map<Types, List<WeaponInterface<Weapon>>> weaponsMapped = DW8Structures.getTypeWeaponKeyKeyMap();

		for (CharacterInterface<Character> c : DW8Structures.getOfficers()) {
			c.setWeapons(weaponsMapped.get(c.getWeaponType()));
			c.setImage(officerImages.get(c.getName()));
		}
	}

}
