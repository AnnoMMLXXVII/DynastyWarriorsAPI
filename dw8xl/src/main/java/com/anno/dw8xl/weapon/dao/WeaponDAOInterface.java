package com.anno.dw8xl.weapon.dao;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.dw8xl.character.model.Weapons;
import com.anno.dw8xl.dao.DataAccessObjectInterface;
import com.anno.dw8xl.type.model.NullType;
import com.anno.dw8xl.weapon.model.AbNormalWeapon;
import com.anno.dw8xl.weapon.model.WeaponI;

/**
 * @author venividivicihofneondeion010101
 *
 */
public interface WeaponDAOInterface extends DataAccessObjectInterface<WeaponI, Object> {

	static final Logger log = LoggerFactory.getLogger(WeaponDAO.class);

	public WeaponI deserializeWeapon(String json);

	public Collection<WeaponI> deserializeWeaponsList(String weapons);

	public Map<String, WeaponI> getWeapons();
	public Map<String, Weapons> getTypeHash();
	public Map<String, WeaponI> getPostman();
	
	public Collection<WeaponI> getWeaponsByCategory(String category);
	public Collection<WeaponI> getWeaponsByStar(Integer star);
	public Collection<WeaponI> getWeaponsByAffinity(String affinity);
	public Collection<WeaponI> getWeaponsByType(String type);
	public Collection<WeaponI> getWeaponsByState(String state);
	public Collection<WeaponI> getWeaponsWithBaseAttack(Integer baseAttack);
	public Collection<WeaponI> getWeaponsWithBaseAttackGreaterThan(Integer baseAttack, boolean inclusive);
	public Collection<WeaponI> getWeaponsWithBaseAttackLessThan(Integer baseAttack, boolean inclusive);

	static boolean isValidToAdd(WeaponI entity) {
		if (entity == null) {
			log.info("Cannot add Weapon due to Null Exception...");
			throw new NullPointerException("Weapon cannot be added due to Null!");
		}
		if (entity.getName().equals("")) {
			log.info("Cannot add Weapon due to empty name...");
			return false;
		}
		if (entity.getType() == null || entity.getType() instanceof NullType || entity.getType().getName() == null) {
			log.info("Cannot add due to Weapon's Type being null...");
			throw new NullPointerException("Weapon cannot be added due to type being null!");
		}
		if (entity.getType().getName() != null
				&& (entity.getType().getCategory() == null || entity.getType().getCategory().getName() == null)) {
			log.info("Cannot add due to Weapon's Category being null...");
			throw new NullPointerException("Weapon cannot be added due to category being null!");
		}
		if (entity.getAffinity() == null || entity.getAffinity().getName() == null) {
			log.info("Cannot add due to Weapon's Affinity being null...");
			throw new NullPointerException("Weapon cannot be added due to affinity being null!");
		}
		if (entity instanceof AbNormalWeapon && (entity.getRarity() == null || entity.getRarity().getType() == null)) {
			log.info("Cannot add due to Weapon's Rarity being null...");
			throw new NullPointerException("Weapon cannot be added due to rarity being null!");
		}
		return true;
	}

	static boolean isValidToRemove(WeaponI entity) {
		if (entity == null) {
			log.info("Cannot remove Weapon due to Null Exception...");
			throw new NullPointerException("Weapon cannot be removed due to Null!");
		}
		if (entity.getName().equals("")) {
			log.info("Cannot remove Weapon due to Empty request [name]...");
			return false;
		}
		return true;
	}
}
