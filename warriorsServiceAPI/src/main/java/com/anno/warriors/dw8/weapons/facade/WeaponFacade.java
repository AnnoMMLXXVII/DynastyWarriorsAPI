package com.anno.warriors.dw8.weapons.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.warriors.dw8.manager.DW8Structures;
import com.anno.warriors.dw8.shared.WeaponSorter;
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
		List<WeaponInterface<Weapon>> returnedList = dao.getWeaponsByAttackPower(DW8Structures.getWeapons(), low, high);
		return new WarriorSorter(returnedList).getSortedList();
	}

	@Override
	public List<WeaponInterface<Weapon>> calingGetWeaponsByTypes(List<WeaponInterface<Weapon>> paramList,
			String... types) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WeaponInterface<Weapon>> calingGetWeaponsByRarity(List<WeaponInterface<Weapon>> paramList,
			String... rarities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WeaponInterface<Weapon>> calingGetWeaponsWithAttributeN(List<WeaponInterface<Weapon>> paramList,
			String... attributes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WeaponInterface<Weapon>> calingGetWeaponsWithAttributeNAndLevelX(
			List<WeaponInterface<Weapon>> paramList, int level, String... attributes) {
		// TODO Auto-generated method stub
		return null;
	}

}
