package com.anno.warriors.dw8.manager;

/*
 * Class is responsible to load and read all files
 * Will Most likely use the DW8Structures class to keep track of 
 * all statistics/metadata about the objects and files
 */
public class DW8ParsingFiles implements DynastyWarriors8Object<DW8ParsingFiles> {

	private static DynastyWarriors8Object<DW8ParsingFiles> instance;
	private static DynastyWarriors8Object<DW8Structures> structure;

	public static DynastyWarriors8Object<DW8ParsingFiles> getInstance() {
		if (instance == null) {
			synchronized (DW8ParsingFiles.class) {
				if (instance == null) {
					return new DW8ParsingFiles();
				}
			}
		}
		return instance;
	}

	private DW8ParsingFiles() {
		
	}

	@Override
	public DW8ParsingFiles getManagerType() {
		return this;
	}
	
	
	
}
