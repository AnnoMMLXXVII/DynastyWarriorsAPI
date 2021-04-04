package com.anno.warriors.dw8;

import com.anno.warriors.dw8.manager.DW8Manager;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;

public class DynastyWarriors8Application {

	private static DynastyWarriors8Application instance;
	private static DynastyWarriors8Object<DW8Manager> manager;

	public static DynastyWarriors8Application getInstance() {
		if (instance == null) {
			synchronized (DynastyWarriors8Application.class) {
				if (instance == null) {
					new DynastyWarriors8Application();
				}
			}
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	private DynastyWarriors8Application() {
		/*
		 * Static Service that reads all files when app starts
		 */

	}

}
