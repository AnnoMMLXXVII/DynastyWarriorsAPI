package com.anno.warriors.dw8.manager;

import com.anno.warriors.dw8.DynastyWarriors8Application;

/*
 * Class is responsible to load and read all files
 * Will Most likely use the DW8Structures class to keep track of 
 * all statistics/metadata about the objects and files
 */
public class DW8ParsingFiles implements DynastyWarriors8Object<DW8ParsingFiles> {

	private static DynastyWarriors8Object<DW8ParsingFiles> instance;

	public static DynastyWarriors8Object<DW8ParsingFiles> getInstance() {
		if (instance == null) {
			synchronized (DynastyWarriors8Application.class) {
				if (instance == null) {
					return new DW8ParsingFiles();
				}
			}
		}
		return instance;
	}

	public DW8ParsingFiles() {
		
	}
	
	

}
