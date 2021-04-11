package com.anno.warriors.dw8.manager;

import com.anno.warriors.dw8.manager.files.ParsingFiles;
import com.anno.warriors.dw8.manager.images.ParsingImages;

/*
 * DW8Manager class is responsible for organizing Start up and Shutdown of the Dw8 App
 * 		--> Manage calls to read all files on load
 * 		--> 
 * Dependent classes
 * 	--> DW8Constants
 * 	--> DW8ParsingFiles
 * 	--> DW8Structures (will track various statistics or data structures for each type of objects)
 */

public class DW8Manager implements DynastyWarriors8Object<DW8Manager> {

	private static DynastyWarriors8Object<DW8Manager> instance;

	public static DynastyWarriors8Object<DW8Manager> getInstance() {
		if (instance == null) {
			synchronized (DW8Manager.class) {
				if (instance == null) {
					return new DW8Manager();
				}
			}
		}
		return instance;
	}

	private DW8Manager() {
		ParsingImages.getInstance();
		ParsingFiles.getInstance();
	}

	@Override
	public DW8Manager getObjectType() {
		return this;
	}

}
