package com.anno.dw8xl.character.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.dw8xl.character.dao.CharacterDAOInterface;
import com.anno.dw8xl.character.model.CharacterI;
import com.anno.dw8xl.character.model.NullCharacter;
import com.anno.dw8xl.dao.DataAccessObjectInterface;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("characterFacade")
@SuppressWarnings("unchecked")
public class CharacterFacade implements CharacterFacadeInterface {

	@Autowired
	private CharacterDAOInterface dao;
	private ObjectMapper mapper;
	private static Logger log = LoggerFactory.getLogger(CharacterFacade.class);

	@Override
	public Collection<CharacterI> getAllCharacters() {
		return dao.getAll();
	}

	@Override
	public Collection<CharacterI> getAllOfficers() {
		return dao.getAllOfficers();
	}

	@Override
	public Collection<CharacterI> getAllSubOfficers() {
		return dao.getAllSubOfficers();
	}

	@Override
	public CharacterI getOfficerByName(String name) {
		String format = format(name);
		if (format.isEmpty()) {
			return new NullCharacter();
		}
		return dao.getOfficerByName(format);
	}

	@Override
	public Collection<CharacterI> getOfficerByKingdom(String kingdom) {
		String format = format(kingdom);
		if (!format.isEmpty()) {
			return dao.getOfficersByKingdom(format);
		} else {
			return new ArrayList<>();
		}
	}

	@Override
	public Collection<CharacterI> getOfficerByWeaponType(String type) {
		String format = format(type);
		return (!format.isEmpty()) ? new ArrayList<>() : new ArrayList<>();
				
	}

	@Override
	public Collection<CharacterI> getOfficerByWeaponCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<CharacterI> getOfficerByWeaponName(String weaponName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<CharacterI> getSubOfficerByKingdom(String kingdom) {
		String formated = DataAccessObjectInterface.formatName(kingdom);
		if (!kingdom.equalsIgnoreCase("")) {
			return dao.getSubOfficersByKingdom(formated);
		} else {
			return new ArrayList<>();
		}
	}

	@Override
	public Collection<CharacterI> getSubOfficerByName(String name) {
		String format = format(name);
		if (format.isEmpty()) {
			return new ArrayList<>();
		}
		return dao.getSubOfficersByName(format);
	}

	private String format(String string) {
		return DataAccessObjectInterface.formatName(string);
	}

}
