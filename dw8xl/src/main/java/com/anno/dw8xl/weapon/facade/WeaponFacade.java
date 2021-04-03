/**
 * 
 */
package com.anno.dw8xl.weapon.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.dw8xl.weapon.dao.WeaponDAOInterface;
import com.anno.dw8xl.weapon.model.WeaponFilter;
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
	public Collection<WeaponI> getFilteredWeapons(String filter, String value, String... option) {
		String formatedFilter = filter.trim().toLowerCase();
		if (formatedFilter.equals("")) {
			return new ArrayList<>();
		}
		return getWeaponBy(formatedFilter, value);
	}

	private Collection<WeaponI> getWeaponBy(String formatedFilter, String value) {
		String formatedValue = value.trim().toLowerCase();
		if (formatedFilter.equalsIgnoreCase(WeaponFilter.STAR.toString())) {
			Integer star = Integer.parseInt(formatedValue);
			return dao.getWeaponsByStar(star);
		} else if (formatedFilter.equalsIgnoreCase(WeaponFilter.STATE.toString())) {
			return dao.getWeaponsByState(formatedValue);
		} else if (formatedFilter.equalsIgnoreCase(WeaponFilter.TYPE.toString())) {
			return dao.getWeaponsByType(formatedValue);
		} else if (formatedFilter.equalsIgnoreCase(WeaponFilter.BASEATTACK.toString())) {
			Integer baseAttack = Integer.parseInt(formatedValue);
			return dao.getWeaponsWithBaseAttack(baseAttack);
		} else if (formatedFilter.equalsIgnoreCase(WeaponFilter.AFFINITY.toString())) {
			return dao.getWeaponsByAffinity(formatedValue);
		} else if (formatedFilter.equalsIgnoreCase(WeaponFilter.CATEGORY.toString())) {
			return dao.getWeaponsByCategory(formatedValue);
		}
		return new ArrayList<>();
	}

}
