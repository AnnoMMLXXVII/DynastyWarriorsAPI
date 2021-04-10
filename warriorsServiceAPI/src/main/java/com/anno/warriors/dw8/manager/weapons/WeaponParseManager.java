package com.anno.warriors.dw8.manager.weapons;

import com.anno.warriors.dw8.manager.DynastyWarriors8Object;

public class DW8WeaponParseManager implements DynastyWarriors8Object<DW8WeaponParseManager> {

	private static DynastyWarriors8Object<DW8WeaponParseManager> instance;

	public static DynastyWarriors8Object<DW8WeaponParseManager> getInstance() {
		if (instance == null) {
			synchronized (DW8WeaponParseManager.class) {
				if (instance == null) {
					return new DW8WeaponParseManager();
				}
			}
		}
		return instance;
	}

	private DW8WeaponParseManager() {

	}

	@Override
	public DW8WeaponParseManager getManagerType() {
		return this;
	}

}
