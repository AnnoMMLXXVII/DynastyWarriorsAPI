package com.anno.warriors.dw8.characters.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.warriors.dw8.characters.dao.CharacterDAOInterface;
import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.characters.model.Officer;
import com.anno.warriors.dw8.manager.DW8Structures;
import com.anno.warriors.dw8.requests.pojos.CharacterPojo;
import com.anno.warriors.shared.WarriorSorter;

@Service("CharacterFacade")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CharacterFacade implements CharacterFacadeInterface {

	@Autowired
	private CharacterDAOInterface dao;

	@Override
	public List<CharacterInterface<Character>> callingGetAllCharacters() {
		return new WarriorSorter(dao.getAllCharacters()).getSortedList();
	}

	@Override
	public List<CharacterInterface<Character>> callingGetAllOfficers() {
		return new WarriorSorter(dao.getAllOfficers()).getSortedList();
	}

	@Override
	public List<CharacterInterface<Character>> callingGetAllSubOfficers() {
		return new WarriorSorter(dao.getAllSubOfficers()).getSortedList();
	}

	@Override
	public List<CharacterInterface<Character>> callingGetCharactersByNames(String[] name) {
		List<CharacterInterface<Character>> returnedList = dao.getCharactersByName(DW8Structures.getCharacters(), name);
		return new WarriorSorter(returnedList).getSortedList();
	}

	@Override
	public List<CharacterInterface<Character>> callingGetOfficersByNames(String[] name) {
		List<CharacterInterface<Character>> returnedList = dao.getCharactersByName(DW8Structures.getOfficers(), name);
		return new WarriorSorter(returnedList).getSortedList();
	}

	@Override
	public List<CharacterInterface<Character>> callingGetSubOfficersByNames(String[] name) {
		List<CharacterInterface<Character>> returnedList = dao.getCharactersByName(DW8Structures.getSubOfficers(),
				name);
		return new WarriorSorter(returnedList).getSortedList();
	}

	@Override
	public List<CharacterInterface<Character>> callingGetOfficerByWeaponType(String... type) {
		List<CharacterInterface<Character>> returnedList = dao.getOfficerByWeaponType(DW8Structures.getOfficers(),
				type);
		return new WarriorSorter(returnedList).getSortedList();
	}

	@Override
	public List<CharacterInterface<Character>> callingGetAllOfficerByKingdom(String... kingdom) {
		List<CharacterInterface<Character>> returnedList = dao.getAllOfficersByKingdom(DW8Structures.getOfficers(),
				kingdom);
		return new WarriorSorter(returnedList).getSortedList();
	}

	@Override
	public List<CharacterInterface<Character>> callingGetAllOfficerByWeaponName(String... weaponNames) {
		List<CharacterInterface<Character>> returnedList = dao.getAllOfficersByWeaponName(DW8Structures.getOfficers(),
				weaponNames);
		return new WarriorSorter(returnedList).getSortedList();
	}

	@Override
	public List<CharacterInterface<Character>> callingGetAllOfficerByWeaponPower(int... weaponPower) {
		List<CharacterInterface<Character>> returnedList = dao.getAllOfficersByWeaponPower(DW8Structures.getOfficers(),
				weaponPower);
		return new WarriorSorter(returnedList).getSortedList();
	}

	@Override
	public CharacterInterface<Character> callingCreateOfficer(CharacterPojo officer) {
		if (officer == null) {
			return new Officer();
		}
		CharacterInterface<Character> newOfficer = dao.createOfficer(officer);
		if (newOfficer == null) {
			return new Officer();
		}
		return newOfficer;
	}

}
