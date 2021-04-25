package com.anno.warriors.dw8.weapons.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anno.warriors.dw8.manager.DW8Structures;
import com.anno.warriors.dw8.shared.DW8Constants;
import com.anno.warriors.dw8.shared.WeaponSearcher;
import com.anno.warriors.dw8.shared.WeaponSorter;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;
import com.anno.warriors.shared.WarriorSearcher;
import com.anno.warriors.shared.WarriorSorter;

@Repository
@SuppressWarnings({ "unchecked", "rawtypes" })
public class WeaponDAO implements WeaponDAOInterface {

	private static Logger logger = LoggerFactory.getLogger(WeaponDAO.class);
	private List<WeaponInterface<Weapon>> list;

	@Override
	public List<WeaponInterface<Weapon>> getAllWeapons() {
		logger.info("Returning all Weapons");
		return DW8Structures.getWeapons();
	}

	@Override
	public List<String> getAllWeaponNames() {
		logger.info("Returning all weapon names");
		return DW8Structures.getWeaponNames();
	}

	@Override
	public List<WeaponInterface<Weapon>> getWeaponsByNames(List<WeaponInterface<Weapon>> paramList, String... name) {
		logger.info("Returning weapon by name : " + name);
		list = new ArrayList<>();
		WarriorSorter<Weapon> sorter = new WarriorSorter(paramList);
		WarriorSearcher<Weapon> searcher = new WarriorSearcher(sorter.getSortedList());
		for (String s : name) {
			List<Weapon> temp = searcher.search(s.trim());
			for (WeaponInterface<Weapon> w : temp) {
				list.add(w);
			}
		}
		return list;
	}

	@Override
	public List<WeaponInterface<Weapon>> getWeaponsByStarRank(List<WeaponInterface<Weapon>> paramList, int... star) {
		List<WeaponInterface<Weapon>> temp;
		list = new ArrayList<>();
		for (Integer i : star) {
			temp = paramList.stream().filter(e -> e.getStar().equals(i)).collect(Collectors.toList());
			if (!temp.isEmpty()) {
				list.addAll(temp);
			}
		}
		return list;
	}

	@Override
	public List<WeaponInterface<Weapon>> getWeaponsByAttackPower(List<WeaponInterface<Weapon>> paramList, Integer low,
			Integer high) {
		if ((high == null || high <= 0) || (high < low)) {
			return new ArrayList<>();
		}

		list = new ArrayList<>();
		List<WeaponInterface<Weapon>> temp;
		WeaponSorter sorter = new WeaponSorter(paramList, DW8Constants.SortBy.ATTACK_POWER,
				DW8Constants.OrderBy.ASCENDING);
		List<WeaponInterface<Weapon>> sorted = sorter.getSortedList();
		WeaponSearcher searcher = new WeaponSearcher(sorted);
//		System.out.println(searcher.searchByAttackPower(low).toString());
		for (int i = low; i <= high; i++) {
			temp = searcher.searchByAttackPower(i);
//			System.out.println(temp.toString());
			if (!temp.isEmpty()) {
				list.addAll(temp);
			}
		}
		return list;
	}

	@Override
	public List<WeaponInterface<Weapon>> getWeaponsByTypes(List<WeaponInterface<Weapon>> paramList, String... types) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WeaponInterface<Weapon>> getWeaponsByRarity(List<WeaponInterface<Weapon>> paramList,
			String... rarities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WeaponInterface<Weapon>> getWeaponsWithAttributeN(List<WeaponInterface<Weapon>> paramList,
			String... attributes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WeaponInterface<Weapon>> getWeaponsWithAttributeNAndLevelX(List<WeaponInterface<Weapon>> paramList,
			int level, String... attributes) {
		// TODO Auto-generated method stub
		return null;
	}

}
