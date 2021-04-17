package com.anno.warriors.dw8.weapons.facade;

import java.util.List;

import com.anno.warriors.dw8.weapons.model.Weapon;
import com.anno.warriors.dw8.weapons.model.WeaponInterface;

public interface WeaponFacadeInterface {

	public List<WeaponInterface<Weapon>> callingGetAllWeapons();

	public List<String> callingGetAllWeaponNames();

	public List<WeaponInterface<Weapon>> callingGetWeaponsByNames(String...name);

	public List<WeaponInterface<Weapon>> callingGetWeaponsByStarRank(int...star);
}
