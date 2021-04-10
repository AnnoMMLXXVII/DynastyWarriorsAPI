package com.anno.warriors.dw8.manager.weapons;

import com.anno.warriors.dw8.manager.DynastyWarriors8Object;

public class WeaponParseManager implements DynastyWarriors8Object<WeaponParseManager> {

	private static DynastyWarriors8Object<WeaponParseManager> instance;

	public static DynastyWarriors8Object<WeaponParseManager> getInstance() {
		if (instance == null) {
			synchronized (WeaponParseManager.class) {
				if (instance == null) {
					return new WeaponParseManager();
				}
			}
		}
		return instance;
	}

	private WeaponParseManager() {

	}

	@Override
	public WeaponParseManager getManagerType() {
		return this;
	}

}
