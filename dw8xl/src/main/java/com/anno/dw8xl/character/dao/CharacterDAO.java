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
import org.springframework.stereotype.Repository;

import com.anno.dw8xl.character.model.CharacterI;
import com.anno.dw8xl.character.model.NullCharacter;
import com.anno.dw8xl.character.model.Officer;
import com.anno.dw8xl.character.model.SubOfficer;
import com.anno.dw8xl.character.model.Weapons;
import com.anno.dw8xl.dao.PATH;
import com.anno.dw8xl.kingdom.dao.KingdomDAO;
import com.anno.dw8xl.kingdom.model.Kingdom;
import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.type.model.Type;
import com.anno.dw8xl.weapon.dao.WeaponDAO;

/**
 * @author Haku Wei
 *
 */
@Repository
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

	protected CharacterDAO() {
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
		if (!CharacterDAOInterface.isValidToAdd(entity)) {
			return;
		}
		id = counter.incrementAndGet();
		log.info(String.format("Adding new Character : %s...", entity.getName()));
		characters.put(id, entity);
	}

	@Override
	public void remove(CharacterI entity) {
		if (!CharacterDAOInterface.isValidToRemove(entity)) {
			return;
		}
		log.info(String.format("Adding new Character : %s...", entity.getName()));
		characters.put(id, entity);
	}

	@Override
	public CharacterI executeCreateOfficer(CharacterI officer) {
		if (officer.getName().isEmpty() || officer.getName() == null) {
			return new NullCharacter();
		}
		List<CharacterI> temp = (List<CharacterI>) getAll();
		if (characters.containsValue(officer)) {

		}
		add(officer);
		return officer;
	}

	@Override
	public Collection<CharacterI> executeGetAllOfficers() {
		log.info("Filtering and Returning new List of All Officers...");
		return characters.values().stream().filter(o -> o instanceof Officer).collect(Collectors.toList());
	}

	@Override
	public Collection<CharacterI> executeGetOfficersByKingdom(String name) {
		log.info(String.format("Filtering and Returning list of Officers by Kingdom : %s...", name));
		return characters.values().stream().filter(o -> o instanceof Officer)
				.filter(e -> e.getKingdom().getName().equalsIgnoreCase(name)).collect(Collectors.toList());
	}

	@Override
	public CharacterI executeGetOfficerByName(String name) {
		log.info(String.format("Filtering and Returning new Officer : %s...", name));
		List<CharacterI> temp = (List<CharacterI>) executeGetAllOfficers();
		Optional<CharacterI> res = temp.stream().filter(e -> e.getName().equalsIgnoreCase(name)).findFirst();
		return (res.isPresent()) ? res.get() : new NullCharacter();
	}

	@Override
	public CharacterI executeGetOfficerByType(String type) {
		log.info(String.format("Filtering and Returning Officer by Type : %s...", type));
		Optional<CharacterI> res = executeGetAllOfficers().stream()
				.filter(e -> e.getType().getName().equalsIgnoreCase(type)).findFirst();
		return (res.isPresent()) ? res.get() : new NullCharacter();
	}

	@Override
	public Collection<CharacterI> executeGetOfficersByCategory(String category) {
		log.info(String.format("Filtering and Returning List of Officers by Category : %s...", category));
		return executeGetAllOfficers().stream()
				.filter(e -> e.getType().getCategory().getName().equalsIgnoreCase(category))
				.collect(Collectors.toList());
	}

	@Override
	public Collection<CharacterI> executeGetOfficersByStar(Integer star) {
		log.info(String.format("Filtering and returning List of Officers by Star value : %d", star));
//		Collection<WeaponI> stars = WeaponDAO.getInstance().getWeaponsByStar(star);
//		Collection<CharacterI> officersByStar = executeGetAllOfficers();
//		return executeGetAllOfficers().stream().filter(e -> e.getWeapons().getWeapons().stream()
//				.filter(s -> s.getStar().equals(star).collect(Collectors.toList()).collect(Collectors.toList())));
		return null;
	}

	@Override
	public Collection<CharacterI> executeGetOfficersByWeaponNames(String weaponName) {
		log.info(String.format("Filtering and Returning Officer by Weapon name : %s...", weaponName));
		return new ArrayList<>();
	}

	@Override
	public Collection<CharacterI> executeGetAllSubOfficers() {
		log.info("Filtering and Returning new List of All SubOfficers...");
		return characters.values().stream().filter(o -> o instanceof SubOfficer).collect(Collectors.toList());
	}

	@Override
	public Collection<CharacterI> executeGetSubOfficersByKingdom(String name) {
		log.info(String.format("Filtering and Returning new List of SubOfficers by kingdom : %s...", name));
		return characters.values().stream().filter(o -> o instanceof SubOfficer)
				.filter(e -> e.getKingdom().getName().equalsIgnoreCase(name)).collect(Collectors.toList());
	}

	@Override
	public Collection<CharacterI> executeGetSubOfficersByName(String name) {
		log.info(String.format("Filtering and Returning new List of SubOfficers by name: %s...", name));
		return executeGetAllSubOfficers().stream().filter(e -> e.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
	}

	public Map<String, Integer> getDuplicates() {
		Map<String, Integer> dupTracker = new HashMap<>();
		Map<String, List<CharacterI>> listTracker = new HashMap<>();
		Collection<CharacterI> database = characters.values();

		String key = "";
		for (CharacterI c : database) {
			key = c.getName();
			if (listTracker.containsKey(key)) {
//				System.out.println(c.getName());
				List<CharacterI> dupList = listTracker.get(key);
				dupList.add(c);
				listTracker.put(key, dupList);
			} else {
				List<CharacterI> newList = new ArrayList<>();
				newList.add(c);
				listTracker.put(key, newList);
			}
		}
//		listTracker.forEach((c, v) -> {
//			if(v.size() > 1) {
//				System.out.printf("%s -> [", c);
//				v.forEach(e -> {
//					System.out.printf("%s (%s), ", e.getKingdom(), e.getClass().getSimpleName());
//				});	
//				System.out.print("]\n");
//			}
//		}); 

//		linkCharAndWeapon();
		return dupTracker;
	}

	private void updateOfficerWeapons() {
		Map<String, Weapons> temp = WeaponDAO.getInstance().getTypeHash();
		Collection<CharacterI> officers = executeGetAllOfficers();
		for (CharacterI c : officers) {
			c.setWeapons(temp.get(c.getType().getName()));
		}
	}

	private void initialize() {
		log.info("Calling method that will parse through Characters...");
		log.info("Parsing through Officer files...");
		parseThroughMultipleCharactersTextFiles(true);
		updateOfficerWeapons();
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
				if (isOfficer) {
					CharacterI temp = characters.get(id);
					temp.setWeapons(new Weapons(new ArrayList<>()));
					characters.put(id, temp);
				}
				id = counter.incrementAndGet();
			}
		} catch (FileNotFoundException e) {
			log.info(String.format("Error: %s...", e.getMessage()));
		}
	}

}
