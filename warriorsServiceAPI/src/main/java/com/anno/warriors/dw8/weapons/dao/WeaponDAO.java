package com.anno.warriors.dw8.weapons.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.anno.warriors.dw8.enums.rarity.Rarity;
import com.anno.warriors.dw8.manager.DW8Structures;
import com.anno.warriors.dw8.shared.AttributeSlotSearcher;
import com.anno.warriors.dw8.shared.AttributeSlotSorter;
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

	private Logger logger = LogManager.getLogger();
	private List<WeaponInterface<Weapon>> list;

	@Override
	public List<WeaponInterface<Weapon>> getAllWeapons() {
		return DW8Structures.getWeapons();
	}

	@Override
	public List<String> getAllWeaponNames() {
		return DW8Structures.getWeaponNames();
	}

	@Override
	public List<WeaponInterface<Weapon>> getWeaponsByNames(List<WeaponInterface<Weapon>> paramList, String... name) {
		logger.info(name);
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
		list = new ArrayList<>();
		List<WeaponInterface<Weapon>> temp;
		WeaponSorter sorter = new WeaponSorter(paramList, DW8Constants.SortBy.ATTACK_POWER,
				DW8Constants.OrderBy.ASCENDING);
		List<WeaponInterface<Weapon>> sorted = sorter.getSortedList();
		WeaponSearcher searcher = new WeaponSearcher(sorted);
		while (low <= high) {
			temp = searcher.searchByAttackPower(low);
			if (!temp.isEmpty()) {
				list.addAll(temp);
			}
			low++;
		}
		return list;
	}

	@Override
	public List<WeaponInterface<Weapon>> getWeaponsByTypes(List<WeaponInterface<Weapon>> paramList) {
		list = new ArrayList<>();
		return new WarriorSorter(paramList).getSortedList();
	}

	@Override
	public List<WeaponInterface<Weapon>> getWeaponsByRarity(List<WeaponInterface<Weapon>> paramList, String rarity) {
		list = new ArrayList<>();
		return paramList.stream().filter(e -> e.getRarity().equals(Rarity.returnCorrectEnum(rarity)))
				.collect(Collectors.toList());
	}

	@Override
	public List<WeaponInterface<Weapon>> getWeaponsWithAttributeN(List<WeaponInterface<Weapon>> paramList,
			String... attributes) {
		// Logic that goes through to check if weapon has AttributeSlot
		list = new ArrayList<>();
		// If !empty
		// stream collect : temp
		List<WeaponInterface<Weapon>> temp = paramList.stream().filter(e -> !e.getAttributeSlots().isEmpty())
				.collect(Collectors.toList());
		// Check each slot for the name
		for (WeaponInterface<Weapon> w : temp) {
			AttributeSlotSorter sorter = new AttributeSlotSorter(w.getAttributeSlots());
			for (String s : attributes) {
				AttributeSlotSearcher searcher = new AttributeSlotSearcher(sorter.getSortedList());
				if ((searcher.search(s)) > -1) {
					list.add(w);
				}
			}
		}
		return list;
	}

	@Override
	public List<WeaponInterface<Weapon>> getWeaponsWithAttributeNAndLevelX(List<WeaponInterface<Weapon>> paramList,
			int level, String... attributes) {
		// Logic that goes through to check if weapon has AttributeSlot
		list = new ArrayList<>();
		// If !empty
		// stream collect : temp
		List<WeaponInterface<Weapon>> temp = paramList.stream().filter(e -> !e.getAttributeSlots().isEmpty())
				.collect(Collectors.toList());
		// Check each slot for the name
		for (WeaponInterface<Weapon> w : temp) {
			AttributeSlotSorter sorter = new AttributeSlotSorter(w.getAttributeSlots());
			for (String s : attributes) {
				AttributeSlotSearcher searcher = new AttributeSlotSearcher(sorter.getSortedList());
				if (searcher.search(s, level)) {
					list.add(w);
				}
			}
		}
		return list;
	}

}
