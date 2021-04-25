package com.anno.warriors.dw8.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private DynastyWarriors8Object<ParsingImages> parsingImages;
	private DynastyWarriors8Object<ParsingFiles> parsingFiles;
	private DynastyWarriors8Object<DW8Structures> dw8Structures;
	private static Logger logger = LoggerFactory.getLogger(DW8Manager.class);

	public static DynastyWarriors8Object<DW8Manager> getInstance() {
		if (instance == null) {
			synchronized (DW8Manager.class) {
				if (instance == null) {
					logger.info("DW8Manager instantiated");
					return new DW8Manager();
				}
			}
		}
		return instance;
	}

	private DW8Manager() {
		parsingImages = ParsingImages.getInstance();
		parsingFiles = ParsingFiles.getInstance();
		// Logic Class that handles mapping dependent objects
//			--> ie Weapon class has images 
//			--> Character needs to have officer images
		dw8Structures = DW8Structures.getInstance();
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
	}

	public static void invokeMapingOfObjects() {
		MapDependencyManager.getInstance();
	}

	public DynastyWarriors8Object<ParsingImages> getParsingImagesInstance() {
		return parsingImages;
	}

	public DynastyWarriors8Object<ParsingFiles> getParsingFilesInstance() {
		return parsingFiles;
	}

	public DynastyWarriors8Object<DW8Structures> getDW8StructuresInstance() {
		return dw8Structures;
	}

}
