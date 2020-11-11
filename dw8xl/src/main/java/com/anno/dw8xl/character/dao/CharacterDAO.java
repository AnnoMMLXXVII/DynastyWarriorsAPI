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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.anno.dw8xl.character.model.CharacterI;
import com.anno.dw8xl.character.model.NullCharacter;
import com.anno.dw8xl.character.model.Officer;
import com.anno.dw8xl.character.model.SubOfficer;
import com.anno.dw8xl.dao.PATH;
import com.anno.dw8xl.kingdom.dao.KingdomDAO;
import com.anno.dw8xl.kingdom.model.Kingdom;
import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.type.model.Type;

/**
 * @author Haku Wei
 *
 */
@Service("characterDAO")
public class CharacterDAO implements CharacterDAOInterface {

	private static final Logger log = LoggerFactory.getLogger(CharacterDAO.class);

	private Map<Integer, CharacterI> characters;
	private static CharacterDAOInterface instance = null;
	private int id;
	private AtomicInteger counter;

	public static CharacterDAOInterface getInstance() {
		log.info("CharacterDAO Singleton instantiation...");
		if (instance == null) {
			synchronized (CharacterDAOInterface.class) {
				if (instance == null) {
					return new CharacterDAO();
				}
			}
		}
		return instance;
	}

	private CharacterDAO() {
		characters = new HashMap<>();
		log.info("Initializing all characters...");
		counter = new AtomicInteger();
		initialize();
	}

	@Override
	public Collection<CharacterI> getAll() {
		log.info("Returning all mapped values...");
		return new ArrayList<>(characters.values());
	}

	@Override
	public Optional<CharacterI> getBy(Object criteria) {
		if (characters.containsValue(criteria)) {
			return Optional.of(characters.get(criteria));
		}
		return Optional.empty();
	}

	@Override
	public void add(CharacterI entity) {

	}

	@Override
	public void remove(CharacterI entity) {

	}

	@Override
	public Collection<CharacterI> getAllOfficers() {
		log.info("Filtering and Returning new List of All Officers...");
		return characters.values().stream().filter(o -> o instanceof Officer).collect(Collectors.toList());
	}

	@Override
	public Collection<CharacterI> getOfficersByKingdom(String name) {
		log.info(String.format("Filtering and Returning list of Officers by Kingdom : %s...", name));
		return characters.values().stream().filter(o -> o instanceof Officer)
				.filter(e -> e.getKingdom().getName().equalsIgnoreCase(name)).collect(Collectors.toList());
	}

	@Override
	public CharacterI getOfficerByName(String name) {
		log.info(String.format("Filtering and Returning new Officer : %s...", name));
		List<CharacterI> temp = (List<CharacterI>) getAllOfficers();
		Optional<CharacterI> res = temp.stream().filter(e -> e.getName().equalsIgnoreCase(name)).findFirst();
		return (res.isPresent()) ? res.get() : new NullCharacter();
	}

	@Override
	public CharacterI getOfficerByType(String type) {
		log.info(String.format("Filtering and Returning Officer by Type : %s...", type));
		Optional<CharacterI> res = getAllOfficers().stream().filter(e -> e.getType().getName().equalsIgnoreCase(type))
				.findFirst();
		return (res.isPresent()) ? res.get() : new NullCharacter();
	}

	@Override
	public Collection<CharacterI> getOfficersByCategory(String category) {
		log.info(String.format("Filtering and Returning List of Officers by Category : %s...", category));
		return getAllOfficers().stream().filter(e -> e.getType().getCategory().getName().equalsIgnoreCase(category))
				.collect(Collectors.toList());
	}

	@Override
	public CharacterI getOfficerByWeaponNames(String weaponName) {
		log.info(String.format("Filtering and Returning Officer by Weapon name : %s...", weaponName));
		Optional<CharacterI> res = getAllOfficers().stream()
				.filter(e -> e.getWeapon().getName().equalsIgnoreCase(weaponName)).findFirst();
		return res.isPresent() ? res.get() : new NullCharacter();
	}

	@Override
	public Collection<CharacterI> getAllSubOfficers() {
		log.info("Filtering and Returning new List of All SubOfficers...");
		return characters.values().stream().filter(o -> o instanceof SubOfficer).collect(Collectors.toList());
	}

	@Override
	public Collection<CharacterI> getSubOfficersByKingdom(String name) {
		log.info(String.format("Filtering and Returning new List of SubOfficers by kingdom : %s...", name));
		return characters.values().stream().filter(o -> o instanceof SubOfficer)
				.filter(e -> e.getKingdom().getName().equalsIgnoreCase(name)).collect(Collectors.toList());
	}

	@Override
	public Collection<CharacterI> getSubOfficersByName(String name) {
		log.info(String.format("Filtering and Returning new List of SubOfficers by name: %s...", name));
		return getAllSubOfficers().stream().filter(e -> e.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
	}

	private void initialize() {
		log.info("Calling method that will parse through Characters...");
		log.info("Parsing through Officer files...");
		parseThroughMultipleCharactersTextFiles(true);
		log.info("Parsing through Sub-Officer files...");
		parseThroughMultipleCharactersTextFiles(false);
	}

	private void parseThroughMultipleCharactersTextFiles(boolean flag) {
		log.info("Getting all kingdoms...");
		List<KingdomI> kingdoms = (List<KingdomI>) KingdomDAO.getInstance().getAll();
		if (kingdoms.isEmpty()) {
			log.debug("KingdomI List size is empty");
		}
		log.info("Assigning the characterPaths based on flag...");
		PATH[] characterPaths = (flag) ? PATH.getAllOfficersPath() : PATH.getSubOfficerPaths();
		log.info("Parsing throgh character files (Officer or SubOfficer)...");
		for (int i = 0; i < characterPaths.length; i++) {
			try {
				parseThroughCharacterTextFile(characterPaths[i].getStringUrl(), kingdoms.get(i), characters, flag);
			} catch (Exception e) {
				log.info(String.format("Error: %s...", e.getMessage()));
			}
		}
	}

	private void parseThroughCharacterTextFile(String path, KingdomI kingdom, Map<Integer, CharacterI> characters,
			boolean isOfficer) {
		CharacterI character;
		File file = new File(path);
		try (Scanner z = new Scanner(new FileReader(file))) {
			String[] officerLine = null;
			while (z.hasNextLine()) {
				String line = z.nextLine();
				officerLine = line.split(",");
				character = (isOfficer)
						? new Officer(officerLine[0].trim(), new Kingdom(officerLine[1].trim()),
								new Type(officerLine[2].trim()))
						: new SubOfficer(officerLine[0], kingdom);
				characters.put(id, character);
				id = counter.incrementAndGet();

			}
		} catch (FileNotFoundException e) {
			log.info(String.format("Error: %s...", e.getMessage()));
		}
	}

}
