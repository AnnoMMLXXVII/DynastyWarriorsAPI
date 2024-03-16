package com.anno.warriors.dw8.weapons.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.manager.DW8Structures;
import com.anno.warriors.dw8.shared.DW8Constants;
import com.anno.warriors.dw8.weapons.dao.WeaponDAOInterface;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;
import com.anno.warriors.shared.WarriorSorter;

@Service("WeaponFacade")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class WeaponFacade implements WeaponFacadeInterface {

	@Autowired
	private WeaponDAOInterface dao;

	@Override
	public List<WeaponInterface<Weapon>> callingGetAllWeapons() {
		return new WarriorSorter(dao.getAllWeapons()).getSortedList();
	}

	@Override
	public List<String> callingGetAllWeaponNames() {
		return new WarriorSorter(dao.getAllWeaponNames()).getSortedList();
	}

	@Override
	public List<WeaponInterface<Weapon>> callingGetWeaponsByNames(String... name) {
		List<WeaponInterface<Weapon>> returnedList = dao.getWeaponsByNames(DW8Structures.getWeapons(), name);
		return new WarriorSorter(returnedList).getSortedList();
	}

	@Override
	public List<WeaponInterface<Weapon>> callingGetWeaponsByStarRank(int... star) {
		List<WeaponInterface<Weapon>> returnedList = dao.getWeaponsByStarRank(DW8Structures.getWeapons(), star);
		return new WarriorSorter(returnedList).getSortedList();
	}

	@Override
	public List<WeaponInterface<Weapon>> callingGetWeaponsByAttackPower(Integer low, Integer high) {
		if ((high == null || high <= 0) || (high < low)) {
			return new ArrayList<>();
		}
		List<WeaponInterface<Weapon>> returnedList = dao.getWeaponsByAttackPower(DW8Structures.getWeapons(), low, high);
		return new WarriorSorter(returnedList).getSortedList();
	}

	@Override
	public List<WeaponInterface<Weapon>> calingGetWeaponsByTypes(String type) {
		if (type == null || type.isEmpty()) {
			return new ArrayList<>();
		}
		for(Types t : Types.values()) {
			for(WeaponInterface<Weapon> w :DW8Structures.getTypeWeaponKeyKeyMap().get(t)) {
				System.out.printf("%s,%s,\n", t.getValue(), w.getName());
			}
		}
		return dao.getWeaponsByTypes(DW8Structures.getTypeWeaponKeyKeyMap().get(Types.returnCorrectEnum(type)));
	}

	@Override
	public List<WeaponInterface<Weapon>> calingGetWeaponsByRarity(String rarity) {
		if (rarity.isEmpty()) {
			return new ArrayList<>();
		}
		return new WarriorSorter(dao.getWeaponsByRarity(DW8Structures.getWeapons(), rarity)).getSortedList();
	}

	@Override
	public List<WeaponInterface<Weapon>> calingGetWeaponsWithAttributeN(String... attributes) {
		if (attributes.length < 1) {
			return new ArrayList<>();
		}
		return new WarriorSorter(dao.getWeaponsWithAttributeN(DW8Structures.getWeapons(), attributes)).getSortedList();
	}

	@Override
	public List<WeaponInterface<Weapon>> calingGetWeaponsWithAttributeNAndLevelX(int level, String... attributes) {
		return ((level > -1 && level <= DW8Constants.MAX_ATTRIBUTE_LEVEL) || attributes.length == 0) ? new ArrayList<>()
				: new WarriorSorter(
						dao.getWeaponsWithAttributeNAndLevelX(DW8Structures.getWeapons(), level, attributes))
								.getSortedList();
	}

}
