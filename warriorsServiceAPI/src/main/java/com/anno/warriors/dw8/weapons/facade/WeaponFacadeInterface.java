package com.anno.warriors.dw8.weapons.facade;

import java.util.List;

import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;

//	implemented by WeaponFacade
public interface WeaponFacadeInterface {

	public List<WeaponInterface<Weapon>> callingGetAllWeapons();

	public List<String> callingGetAllWeaponNames();

	public List<WeaponInterface<Weapon>> callingGetWeaponsByNames(String... name);

	public List<WeaponInterface<Weapon>> callingGetWeaponsByStarRank(int... star);

	public List<WeaponInterface<Weapon>> callingGetWeaponsByAttackPower(Integer low, Integer high);

	public List<WeaponInterface<Weapon>> calingGetWeaponsByTypes(String types);

	public List<WeaponInterface<Weapon>> calingGetWeaponsByRarity(String rarities);

	public List<WeaponInterface<Weapon>> calingGetWeaponsWithAttributeN(String... attributes);

	public List<WeaponInterface<Weapon>> calingGetWeaponsWithAttributeNAndLevelX(int level, String... attributes);
}
