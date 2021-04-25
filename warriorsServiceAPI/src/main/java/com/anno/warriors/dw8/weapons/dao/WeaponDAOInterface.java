package com.anno.warriors.dw8.weapons.dao;

import java.util.List;

import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;

public interface WeaponDAOInterface {

	public List<WeaponInterface<Weapon>> getAllWeapons();

	public List<String> getAllWeaponNames();

	public List<WeaponInterface<Weapon>> getWeaponsByNames(List<WeaponInterface<Weapon>> paramList, String... name);

	public List<WeaponInterface<Weapon>> getWeaponsByStarRank(List<WeaponInterface<Weapon>> paramList, int... star);

	public List<WeaponInterface<Weapon>> getWeaponsByAttackPower(List<WeaponInterface<Weapon>> paramList, Integer low,
			Integer high);

	public List<WeaponInterface<Weapon>> getWeaponsByTypes(List<WeaponInterface<Weapon>> paramList, String... types);

	public List<WeaponInterface<Weapon>> getWeaponsByRarity(List<WeaponInterface<Weapon>> paramList,
			String... rarities);

	public List<WeaponInterface<Weapon>> getWeaponsWithAttributeN(List<WeaponInterface<Weapon>> paramList,
			String... attributes);

	public List<WeaponInterface<Weapon>> getWeaponsWithAttributeNAndLevelX(List<WeaponInterface<Weapon>> paramList,
			int level, String... attributes);
}
