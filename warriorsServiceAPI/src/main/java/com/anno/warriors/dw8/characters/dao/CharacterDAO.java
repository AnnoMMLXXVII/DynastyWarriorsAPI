package com.anno.warriors.dw8.characters.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.manager.DW8Structures;
import com.anno.warriors.dw8.shared.CharacterSearcher;
import com.anno.warriors.dw8.shared.CharacterSorter;
import com.anno.warriors.dw8.shared.DW8Constants;
import com.anno.warriors.dw8.shared.WeaponSearcher;
import com.anno.warriors.dw8.shared.WeaponSorter;
import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;
import com.anno.warriors.shared.WarriorSearcher;
import com.anno.warriors.shared.WarriorSorter;

@Repository
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CharacterDAO implements CharacterDAOInterface {

//			Dependency Classes --> DW8Structures
	private static Logger logger = LoggerFactory.getLogger(CharacterDAO.class);
	private List<CharacterInterface<Character>> list;

	@Override
	public List<CharacterInterface<Character>> getAllCharacters() {
		logger.debug("GET - All Characters");
		return DW8Structures.getCharacters();
	}

	@Override
	public List<CharacterInterface<Character>> getAllOfficers() {
		logger.debug("GET - All Officers");
		return DW8Structures.getOfficers();
	}

	@Override
	public List<CharacterInterface<Character>> getAllSubOfficers() {
		logger.debug("GET - All SubOfficers");
		return DW8Structures.getSubOfficers();
	}

	@Override
	public List<CharacterInterface<Character>> getCharactersByName(List<CharacterInterface<Character>> paramList,
			String... name) {
		list = new ArrayList<>();
		WarriorSorter<Character> sorter = new WarriorSorter(paramList);
		WarriorSearcher<Character> searcher = new WarriorSearcher(sorter.getSortedList());
		for (String s : name) {
			List<Character> temp = searcher.search(s);
			for (CharacterInterface<Character> c : temp) {
				if (c != null) {
					list.add(c);
				}
			}
		}
		return list;
	}

	@Override
	public List<CharacterInterface<Character>> getOfficerByWeaponType(List<CharacterInterface<Character>> paramList,
			String... type) {
		list = new ArrayList<>();
		CharacterSorter sorter = new CharacterSorter(paramList, DW8Constants.SortBy.TYPES);
		CharacterSearcher searcher = new CharacterSearcher(sorter.getSortedList());
		for (String s : type) {
			Types t = Types.returnCorrectEnum(s);
			CharacterInterface<Character> temp = searcher.search(t);
			if (temp != null) {
				list.add(temp);
			}
		}
		return list;
	}

	@Override
	public List<CharacterInterface<Character>> getAllOfficersByKingdom(List<CharacterInterface<Character>> officers,
			String... kingdom) {
		list = new ArrayList<>();
		for (String s : kingdom) {
			Kingdom k = Kingdom.returnCorrectEnum(s);
			officers.forEach(e -> {
				if (e.getKingdom().equals(k)) {
					list.add(e);
				}
			});
		}
		return list;
	}

	@Override
	public List<CharacterInterface<Character>> getAllOfficersByWeaponName(List<CharacterInterface<Character>> officers,
			String... weaponNames) {
		List<CharacterInterface<Character>> tempOfficers = officers;
		list = new ArrayList<>();
		List<WeaponInterface<Weapon>> allWeaponsTemp = new ArrayList<>();
		tempOfficers.forEach(e -> {
			allWeaponsTemp.addAll(e.getWeapons());
//			logger.info("{} Weapon Size : {} ", e.getName(), allWeaponsTemp.size());
			WeaponSorter weapSorter = new WeaponSorter(allWeaponsTemp, DW8Constants.SortBy.NAME,
					DW8Constants.OrderBy.ASCENDING);
			WeaponSearcher weapSearcher = new WeaponSearcher(weapSorter.getSortedList());

			for (String s : weaponNames) {
				List<WeaponInterface<Weapon>> temp = weapSearcher.search(s);
				if (!temp.isEmpty()) {
					logger.info("{} Weapon Size : {} ", e.getName(), temp.size());
					logger.info("Found Weapon -> {} for {}", s, e.getName());
					e.getWeapons().clear();
					logger.info("Cleared Weapon Size : {} for {}", e.getWeapons().size(), e.getName());
					temp.forEach(z -> {
						logger.info("Temp : {}, {}", z.getName(), z.getType());
					});
					e.getWeapons().addAll(temp);
					list.add(e);
				}
			}
			allWeaponsTemp.clear();
		});

		return list;
	}

	@Override
	public List<CharacterInterface<Character>> getAllOfficersByWeaponPower(List<CharacterInterface<Character>> officers,
			int... weaponPower) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CharacterInterface<Character>> getAllOfficersByWeaponStar(List<CharacterInterface<Character>> officers,
			int... weaponStar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CharacterInterface<Character>> getAllOfficersByWeaponRarity(
			List<CharacterInterface<Character>> officers, String... weaponRarity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CharacterInterface<Character>> getAllOfficersByWeaponCategory(
			List<CharacterInterface<Character>> officers, String... weaponCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CharacterInterface<Character>> getAllOfficersByWeaponAffinity(
			List<CharacterInterface<Character>> officers, String... weaponAffinity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CharacterInterface<Character>> getAllOfficersByWeaponLength(
			List<CharacterInterface<Character>> officers, String... weaponLength) {
		// TODO Auto-generated method stub
		return null;
	}

}
