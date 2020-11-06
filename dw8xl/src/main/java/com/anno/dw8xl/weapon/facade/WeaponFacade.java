/**
 * 
 */
package com.anno.dw8xl.weapon.facade;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.dw8xl.weapon.dao.WeaponDAOInterface;
import com.anno.dw8xl.weapon.model.WeaponI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("weaponFacade")
public class WeaponFacade implements WeaponFacadeInterface {

	@Autowired
	private WeaponDAOInterface dao;
	private static final Logger log = LoggerFactory.getLogger(WeaponFacade.class);

	@Override
	public Collection<WeaponI> getAllWeapons() {
		return dao.getAll();
	}

	@Override
	public WeaponI parseWeaponObject(String weapon) {
		return dao.deserializeWeapon(weapon);
	}

	public Collection<WeaponI> parseWeaponsList(List<WeaponI> weapons) {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(weapons);
		} catch (JsonProcessingException e) {
			log.debug("Could not parse incoming weapon list...");
		}
		return dao.deserializeWeaponsList(json);
	}

	@Override
	public Collection<WeaponI> getFilteredWeapons(String filter) {
		
		return null;
	}
	
	

}
