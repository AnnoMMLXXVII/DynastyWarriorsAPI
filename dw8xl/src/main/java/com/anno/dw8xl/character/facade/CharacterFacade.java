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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("characterFacade")
public class CharacterFacade implements CharacterFacadeInterface {

	@Autowired
	private CharacterDAOInterface dao;
	private static Logger log = LoggerFactory.getLogger(CharacterFacade.class);

	@Override
	public Collection<CharacterI> getAllCharacters() {
		log.debug("Returning collection of characters...");
		return dao.getAll();
	}

	@Override
	public Collection<CharacterI> getAllOfficers() {
		log.debug("Returning collection of Officers...");
		return dao.executeGetAllOfficers();
	}

	@Override
	public Collection<CharacterI> getAllSubOfficers() {
		log.debug("Returning collection of SubOfficers...");
		return dao.executeGetAllSubOfficers();
	}

	@Override
	public CharacterI getOfficerByName(String name) {
		if (name.isEmpty()) {
			log.debug("Returning Empty Character due to empty Name...");
			return new NullCharacter();
		}
		log.debug("Returning Officer by Name...");
		return dao.executeGetOfficerByName(name);
	}

	@Override
	public Collection<CharacterI> getOfficerByKingdom(String kingdom) {
		if (kingdom.isEmpty()) {
			log.debug("Returning Empty Collection due to empty Kingdom...");
			return new ArrayList<>();
		}
		log.debug("Returning Collection of Officers by Kingdom...");
		return dao.executeGetOfficersByKingdom(kingdom);
	}

	@Override
	public CharacterI getOfficerByWeaponType(String type) {
		if (type.isEmpty()) {
			log.debug("Returning Empty Character due to empty type...");
			return new NullCharacter();
		}
		log.debug("Returning Officer by Type...");
		return dao.executeGetOfficerByType(type);
	}

	@Override
	public Collection<CharacterI> getOfficerByWeaponCategory(String category) {
		if (category.isEmpty()) {
			log.debug("Returning Empty Collection of Officers due to empty Category...");
			return new ArrayList<>();
		}
		log.debug("Returning collection of Officers by Category...");
		return dao.executeGetOfficersByCategory(category);
	}

	@Override
	public Collection<CharacterI> getOfficerByWeaponStar(String star) {
		if(star.isEmpty() || Integer.parseInt(star) < 0) {
			log.debug("Returning Empty Collection of Officers: Empty or Star value below ZERO...");
			return new ArrayList<>();
		}
		log.debug("Returning collection of Officers by Star value...");
		return dao.executeGetOfficersByWeaponStar(Integer.parseInt(star));
	}

	@Override
	public Collection<CharacterI> getOfficerByWeaponName(String weaponName) {
		if (weaponName.isEmpty()) {
			log.debug("Returning empty collection of Character due to empty Weapon Name...");
			return new ArrayList<>();
		}
		log.debug("Returning collection of Officers by Weapon Name...");
		return dao.executeGetOfficersByWeaponNames(weaponName);
	}

	@Override
	public CharacterI addOfficer(String json) {
		ObjectMapper mapper = new ObjectMapper();
		CharacterI temp = new NullCharacter();
		try {
			log.debug("Deseralizing incoming json string...");
			temp = mapper.readValue(json, CharacterI.class);
		} catch (JsonProcessingException e) {
			log.debug("Could not parse incoming weapon list...");
		}
//		System.out.println(temp.toString()); 
		return dao.executeCreateOfficer(temp);
	}

	@Override
	public Collection<CharacterI> getSubOfficerByKingdom(String kingdom) {
		if (kingdom.isEmpty()) {
			log.debug("Error: Returning empty collection of SubOfficers due to Empty Kingdom...");
			return new ArrayList<>();
		}
		return dao.executeGetSubOfficersByKingdom(kingdom);
	}

	@Override
	public Collection<CharacterI> getSubOfficerByName(String name) {
		if (name.isEmpty()) {
			log.debug("Returning empty collection of SubOfficers due to Empty Name...");
			return new ArrayList<>();
		}
		log.debug("Returning collection of SubOfficers by name...");
		return dao.executeGetSubOfficersByName(name);
	}
}
