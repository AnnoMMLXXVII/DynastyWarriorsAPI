package com.anno.warriors.dw8.characters.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.characters.model.Officer;
import com.anno.warriors.dw8.enums.kingdom.Kingdom;
import com.anno.warriors.dw8.enums.types.Types;
import com.anno.warriors.dw8.manager.DW8Structures;
import com.anno.warriors.dw8.requests.pojos.CharacterPojo;
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
		Map<String, CharacterInterface<Character>> charactersMapped = new HashMap<>();
		List<WeaponInterface<Weapon>> allWeaponsTemp = new ArrayList<>();
		tempOfficers.forEach(e -> {
			allWeaponsTemp.addAll(e.getWeapons());
			WeaponSorter weapSorter = new WeaponSorter(allWeaponsTemp, DW8Constants.SortBy.NAME,
					DW8Constants.OrderBy.ASCENDING);
			WeaponSearcher weapSearcher = new WeaponSearcher(weapSorter.getSortedList());

			for (String s : weaponNames) {
				List<WeaponInterface<Weapon>> temp = weapSearcher.search(s);
				if (!temp.isEmpty()) {
					charactersMapped.put(e.getName(), e);
				}
			}
			allWeaponsTemp.clear();
		});

		return new ArrayList<>(charactersMapped.values());
	}

	@Override
	public List<CharacterInterface<Character>> getAllOfficersByWeaponPower(List<CharacterInterface<Character>> officers,
			int... weaponPower) {
		List<CharacterInterface<Character>> tempOfficers = officers;
		Map<String, CharacterInterface<Character>> charactersMapped = new HashMap<>();
		List<WeaponInterface<Weapon>> allWeaponsTemp = new ArrayList<>();

		tempOfficers.forEach(e -> {
			allWeaponsTemp.addAll(e.getWeapons());
			WeaponSorter weapSorter = new WeaponSorter(allWeaponsTemp, DW8Constants.SortBy.NAME,
					DW8Constants.OrderBy.ASCENDING);
			WeaponSearcher weapSearcher = new WeaponSearcher(weapSorter.getSortedList());

			for (int p : weaponPower) {
				List<WeaponInterface<Weapon>> temp = weapSearcher.searchByAttackPower(p);
				if (!temp.isEmpty()) {
					charactersMapped.put(e.getName(), e);
				}
			}
			allWeaponsTemp.clear();
		});

		return new ArrayList<>(charactersMapped.values());
	}

	@Override
	public CharacterInterface<Character> createOfficer(CharacterPojo officer) {
		if (officer == null) {
			logger.info("Officer Record is not valid");
			return null;
		}
		List<CharacterInterface<Character>> duplicate = getCharactersByName(DW8Structures.getOfficers(),
				officer.getName());
		if (!duplicate.isEmpty()) {
			logger.info("Duplicate Record: {}", officer.getName());
			return null;
		}
		CharacterInterface<Character> temp = new Officer();
//		@formatter:off
		temp.setId(UUID.randomUUID())
		.setName(officer.getName())
		.setKingdom(officer.getKingdom())
		.setWeaponType(officer.getWeaponType())
		.setImage(new ArrayList<>())
		.setWeapons(new ArrayList());
//		@formatter:on		
		return temp;
	}

}
