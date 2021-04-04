package com.anno.warriors.dw8;

import com.anno.warriors.dw8.manager.DW8Manager;

public class DynastyWarriors8Application {

	private static DynastyWarriors8Application instance;

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

	private DynastyWarriors8Application() {
		/*
		 * Static Service that reads all files when app starts
		 */
		run();
		
	}
	
	private void run() {
		DW8Manager.getInstance();
	}

}
