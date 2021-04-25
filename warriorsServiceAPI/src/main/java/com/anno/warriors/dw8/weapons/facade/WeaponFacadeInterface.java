package com.anno.warriors.dw8.weapons.facade;

import java.util.List;

import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;

public interface WeaponFacadeInterface {

	public List<WeaponInterface<Weapon>> callingGetAllWeapons();

	public List<String> callingGetAllWeaponNames();

	public List<WeaponInterface<Weapon>> callingGetWeaponsByNames(String... name);

	public List<WeaponInterface<Weapon>> callingGetWeaponsByStarRank(int... star);

	public List<WeaponInterface<Weapon>> callingGetWeaponsByAttackPower(Integer low, Integer high);

	public List<WeaponInterface<Weapon>> calingGetWeaponsByTypes(List<WeaponInterface<Weapon>> paramList,
			String... types);

	public List<WeaponInterface<Weapon>> calingGetWeaponsByRarity(List<WeaponInterface<Weapon>> paramList,
			String... rarities);

	public List<WeaponInterface<Weapon>> calingGetWeaponsWithAttributeN(List<WeaponInterface<Weapon>> paramList,
			String... attributes);

	public List<WeaponInterface<Weapon>> calingGetWeaponsWithAttributeNAndLevelX(
			List<WeaponInterface<Weapon>> paramList, int level, String... attributes);
}
