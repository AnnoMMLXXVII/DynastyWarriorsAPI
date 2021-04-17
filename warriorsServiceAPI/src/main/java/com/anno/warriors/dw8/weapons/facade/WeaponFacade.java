package com.anno.warriors.dw8.weapons.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.warriors.dw8.manager.DW8Structures;
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

}
