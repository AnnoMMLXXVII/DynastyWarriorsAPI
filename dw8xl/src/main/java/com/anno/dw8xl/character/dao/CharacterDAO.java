/**
 * 
 */
package com.anno.dw8xl.character.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.anno.dw8xl.character.model.CharacterI;
import com.anno.dw8xl.character.model.Officer;
import com.anno.dw8xl.character.model.SubOfficer;
import com.anno.dw8xl.dao.DAO;
import com.anno.dw8xl.kingdom.dao.KingdomDAO;
import com.anno.dw8xl.kingdom.model.Kingdom;
import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.type.model.Type;

/**
 * @author Haku Wei
 *
 */
@Service("characterDAO")
public class CharacterDAO implements DAO<CharacterI, Object>{

	private static final Logger log = LoggerFactory.getLogger(CharacterDAO.class);
	private Map<String, CharacterI> characters;
	private static DAO<CharacterI, Object> instance = null;
	
	
	public static DAO<CharacterI, Object> getInstance() {
		log.debug("Singleton instantiation...");
		if(instance == null) {
			synchronized (DAO.class) {
				if(instance == null) {
					return new CharacterDAO();
				}
			}
		}
		return instance;
	}
	
	private CharacterDAO() {
		characters = new HashMap<>();
		log.debug("Initializing all characters...");
		initialize();
	}
	
	@Override
	public Collection<CharacterI> getAll() {
		log.debug("Returning all mapped values...");
		return new ArrayList<>(characters.values());
	}
	@Override
	public Optional<CharacterI> getBy(Object criteria) {
		return null;
	}
	@Override
	public void add(CharacterI entity) {
		
	}
	@Override
	public void remove(CharacterI entity) {
		
	}
	
	private void initialize() {
		log.debug("Calling method that will parse through Characters...");
		log.debug("Parsing through Officer files...");
		parseThroughMultipleCharactersTextFiles(true);
		log.debug("Parsing through Sub-Officer files...");
		parseThroughMultipleCharactersTextFiles(false);
	}
	
	private String[] getAllSubOfficerTextFiles() {
		return new String[] {
				"Text-Files/characters/sub-officer/SubOfficer-List-Shu.txt",
				"Text-Files/characters/sub-officer/SubOfficer-List-Wu.txt",
				"Text-Files/characters/sub-officer/SubOfficer-List-Wei.txt",
				"Text-Files/characters/sub-officer/SubOfficer-List-Jin.txt",
				"Text-Files/characters/sub-officer/SubOfficer-List-Other.txt",
				
		};
	}
	
	private String[] getAllOfficerTextFiles() {
		return new String[] {
				"Text-Files/characters/officer/Officer-List-Shu.txt",
				"Text-Files/characters/officer/Officer-List-Wu.txt",
				"Text-Files/characters/officer/Officer-List-Wei.txt",
				"Text-Files/characters/officer/Officer-List-Jin.txt",
				"Text-Files/characters/officer/Officer-List-Other.txt",
		};
	}
	
	// Outer Loop for each file
		// Character uses : Kingdom, Type --> Category
	// Inner Loop that parse list
	
	private void parseThroughMultipleCharactersTextFiles(boolean flag) {
		log.debug("Getting all kingdoms...");
		List<KingdomI> kingdoms = (List<KingdomI>) KingdomDAO.getInstance().getAll();
		log.debug("Assigning the characterPaths based on flag...");
		String[] characterPaths = (flag) ? getAllOfficerTextFiles() : getAllSubOfficerTextFiles();
		log.debug("Parsing throgh character files (Officer or SubOfficer)...");
		for (int i = 0; i < characterPaths.length; i++) {
			try {
				parseThroughCharacterTextFile(URL_ROOT+characterPaths[i], kingdoms.get(i), characters, flag);
			}
			catch(Exception e) {
				e.getStackTrace();
			}
		}
	}
	
	private void parseThroughCharacterTextFile(String path, KingdomI kingdom,  Map<String, CharacterI> characters, boolean isOfficer) {
		CharacterI character;
		File file = new File(path);
		try (Scanner z = new Scanner(new FileReader(file))){
			String[] officerLine = null;
			while (z.hasNextLine()) {
				String line = z.nextLine();
				officerLine = line.split(",");
				character = (isOfficer) 
						? new Officer(officerLine[0].trim(), new Kingdom(officerLine[1].trim()), new Type(officerLine[2].trim()))
						: new SubOfficer(officerLine[0], kingdom);
				characters.put(character.getName(), character);
			}
		}
		catch(FileNotFoundException e) {
			e.getMessage();
		}
	}
	

}
