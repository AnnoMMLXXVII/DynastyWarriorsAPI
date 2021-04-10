/**
 * 
 */
package com.anno.dw8xl.weapon.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anno.dw8xl.affinity.dao.AffinityDAO;
import com.anno.dw8xl.affinity.model.Affinity;
import com.anno.dw8xl.affinity.model.AffinityI;
import com.anno.dw8xl.category.model.Category;
import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.character.model.Weapons;
import com.anno.dw8xl.dao.PATH;
import com.anno.dw8xl.kingdom.dao.KingdomDAO;
import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.length.model.Length;
import com.anno.dw8xl.rarity.model.Rarity;
import com.anno.dw8xl.rarity.model.RarityI;
import com.anno.dw8xl.type.model.Type;
import com.anno.dw8xl.type.model.TypeI;
import com.anno.dw8xl.weapon.model.AbNormalWeapon;
import com.anno.dw8xl.weapon.model.NormalWeapon;
import com.anno.dw8xl.weapon.model.WeaponI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Repository
public class WeaponDAO implements WeaponDAOInterface {

	private static final Logger log = LoggerFactory.getLogger(WeaponDAO.class);
	private static WeaponDAOInterface instance;
	private Map<String, WeaponI> weapons;
	private Map<String, WeaponI> postman;
	private Map<TypeI, List<WeaponI>> typeWeapons;

	public static WeaponDAOInterface getInstance() {
		log.info("WeaponDAO Singleton instantiation...");
		if (instance == null) {
			synchronized (WeaponDAOInterface.class) {
				if (instance == null) {
					return new WeaponDAO();
				}
			}
		}
		return instance;
	}

	protected WeaponDAO() {
		weapons = new HashMap<>();
		postman = new HashMap<>();
		typeWeapons = new HashMap<>();
		initialize();
	}

	@Override
	public Collection<WeaponI> getAll() {
		return new ArrayList<>(weapons.values());
	}

	@Override
	public Optional<WeaponI> getBy(Object criteria) {
		if (weapons.containsKey(criteria)) {
			return Optional.of(weapons.get(criteria));
		}
		return Optional.ofNullable(weapons.get(criteria));
	}

	@Override
	public void add(WeaponI entity) {

		if (!WeaponDAOInterface.isValidToAdd(entity)) {
			return;
		}
		WeaponKey key = new WeaponKey(entity.getName(), entity.getType());
		if (weapons.containsKey(key.toString())) {
			log.info("Cannot add Weapon due to duplicate...");
			return;
		}
		weapons.put(key.toString(), entity);
	}

	@Override
	public void remove(WeaponI entity) {
		if (!WeaponDAOInterface.isValidToRemove(entity)) {
			return;
		}
		WeaponKey key = new WeaponKey(entity.getName(), entity.getType());
		if (!weapons.containsKey(key.toString())) {
			log.info("Cannot find Weapon to remove...");
			return;
		}
		weapons.remove(key.toString(), entity);
	}

	public Collection<WeaponI> deserializeWeaponsList(String json) {
		ObjectMapper mapper = new ObjectMapper();
		WeaponI[] weaponsAsArray = null;
		try {
			weaponsAsArray = mapper.readValue(json, WeaponI[].class);
		} catch (JsonProcessingException e) {
			log.debug("Could not Parse!");
		}
		mapArrayToMap(weaponsAsArray);
		return Arrays.asList(weaponsAsArray);
	}

	private void mapArrayToMap(WeaponI[] weapons) {
		WeaponKey key = null;
		for (WeaponI w : weapons) {
			key = new WeaponKey(w.getName(), w.getType());
			postman.put(key.toString(), w);
		}
	}

	public Map<String, WeaponI> getWeapons() {
		return weapons;
	}

	public Map<String, WeaponI> getPostman() {
		return postman;
	}

	public Map<String, Weapons> getTypeHash() {
		Map<String, Weapons> temp = new HashMap<>();
		Collection<WeaponI> database = this.getAll();
		String key = "";
		for(WeaponI w : database) {
			key = w.getType().getName();
			Weapons list;
			if(temp.containsKey(key)) {
				list = temp.get(key);
				list.getWeapons().add(w);
				temp.put(key, list);
			}
			else {
				list = new Weapons(new ArrayList<>());
				list.getWeapons().add(w);
				temp.put(key, list);
			}
		}
//		temp.forEach((k,v) -> {
//			System.out.printf("%s [\n\t\t", k);
//			v.getWeapons().stream().forEach(e -> {
//				System.out.printf("%s, ", e.getName());
//			});
//			System.out.printf("]\n");
//		});
		return temp;
	}

	public WeaponI deserializeWeapon(String json) {
		ObjectMapper mapper = new ObjectMapper();
		WeaponI weapon = null;
		try {
			weapon = mapper.readValue(json, WeaponI.class);
		} catch (JsonProcessingException e) {
			log.debug(String.format("%s", e.getMessage()));
		}
		return weapon;
	}

	@Override
	public Collection<WeaponI> getWeaponsByCategory(String category) {
		return weapons.values().stream().filter(e -> e.getType().getCategory().getName().equalsIgnoreCase(category))
				.collect(Collectors.toList());
	}

	@Override
	public Collection<WeaponI> getWeaponsByStar(Integer star) {
		return weapons.values().stream().filter(e -> e.getStar().equals(star)).collect(Collectors.toList());
	}

	@Override
	public Collection<WeaponI> getWeaponsByAffinity(String affinity) {
		Optional<AffinityI> affinities = AffinityDAO.getInstance().getBy(affinity);
		if (!affinities.isPresent()) {
			log.debug(String.format("Error: Cannot filter by %s. Does not Exist!", affinity));
			return new ArrayList<>();
		}
		return weapons.values().stream()
				.filter(e -> e.getAffinity().getName().equalsIgnoreCase(affinities.get().getName()))
				.collect(Collectors.toList());
	}

	@Override
	public Collection<WeaponI> getWeaponsByType(String type) {
		return weapons.values().stream().filter(e -> e.getType().getName().equalsIgnoreCase(type))
				.collect(Collectors.toList());
	}

	@Override
	public Collection<WeaponI> getWeaponsByState(String state) {
		if (state.equalsIgnoreCase("normal")) {
			return weapons.values().stream().filter(e -> e instanceof NormalWeapon).collect(Collectors.toList());
		} 
		else if (state.equalsIgnoreCase("abnormal")) {
			return weapons.values().stream().filter(e -> e instanceof AbNormalWeapon).collect(Collectors.toList());
		}
		else {
			return new ArrayList<>();
		}
	}

	@Override
	public Collection<WeaponI> getWeaponsWithBaseAttack(Integer baseAttack) {
		return weapons.values().stream().filter(e -> e.getBaseAttack().equals(baseAttack)).collect(Collectors.toList());
	}

	@Override
	public Collection<WeaponI> getWeaponsWithBaseAttackGreaterThan(Integer baseAttack, boolean inclusive) {
		return (inclusive)
				? weapons.values().stream().filter(e -> e.getBaseAttack() >= baseAttack).collect(Collectors.toList())
				: weapons.values().stream().filter(e -> e.getBaseAttack() > baseAttack).collect(Collectors.toList());
	}

	@Override
	public Collection<WeaponI> getWeaponsWithBaseAttackLessThan(Integer baseAttack, boolean inclusive) {
		return (inclusive)
				? weapons.values().stream().filter(e -> e.getBaseAttack() <= baseAttack).collect(Collectors.toList())
				: weapons.values().stream().filter(e -> e.getBaseAttack() < baseAttack).collect(Collectors.toList());
	}
	

	private void initialize() {
		log.info("Calling method that will parse through Weapons Files...");
		parseThroughMultipleWeaponsTextFiles();

	}

	private void parseThroughMultipleWeaponsTextFiles() {
		log.info("Getting all kingdoms...");
		List<KingdomI> kingdoms = (List<KingdomI>) KingdomDAO.getInstance().getAll();
		if (kingdoms.isEmpty()) {
			log.debug("KingdomI List size is empty");
		}
		log.info("Assigning the characterPaths based on flag...");
		PATH[][] categoriesPaths = { PATH.getDasherWeaponsPaths(), PATH.getWhirlwindWeaponsPaths(),
//				PATH.getDiverWeaponsPaths(),
//				PATH.getShadowWeaponsPaths(),
		};
		CategoryI[] categories = { new Category("Dasher"), new Category("Whirlwind") };
		RarityI[] rarities = { new Rarity("Rare"), new Rarity("Unique"), new Rarity("Xtreme") };
		log.info("Parsing throgh character files (Officer or SubOfficer)...");
		boolean isNormal = true;
		int k = 0;
		for (int i = 0; i < categoriesPaths.length; i++) {
			for (int j = 0; j < categoriesPaths[i].length; j++) {
				try {
					if (j > 0) {
						isNormal = false;
						k = j - 1;
					}
					parseThroughWeaponTextFile(categoriesPaths[i][j].getStringUrl(), weapons, typeWeapons,
							categories[i], rarities[k], isNormal);
				} catch (Exception e) {
					log.debug(String.format("%s :: Error: %s...%n", categoriesPaths[i][j].getStringUrl(),
							e.getMessage()));
				}
			}
		}
	}

	private void parseThroughWeaponTextFile(String path, Map<String, WeaponI> weapons,
			Map<TypeI, List<WeaponI>> typeWeapons, CategoryI category, RarityI rarity, boolean isNormal) {
		WeaponI weapon = null;
		WeaponKey key = null;
		File file = new File(path);
		try (Scanner z = new Scanner(new FileReader(file))) {
			String[] weaponLine = null;
			log.debug(String.format("%s...", file.getPath()));
			while (z.hasNextLine()) {
				String line = z.nextLine().trim();
				weaponLine = line.split(",");
				weapon = (isNormal) ? setNormal(weaponLine, category) : setAbNormal(weaponLine, rarity, category);
				key = new WeaponKey(weapon.getName(), weapon.getType());
				weapons.put(key.toString(), weapon);
			}
			
		} catch (FileNotFoundException e) {
			log.info(String.format("FNFE Error: %s...", e.getMessage()));
		}
	}

	private WeaponI setNormal(String[] weaponLine, CategoryI category) {
		return new NormalWeapon(weaponLine[0].trim(), // Name
				new Integer(weaponLine[1].trim()), // BaseAttack
				new Length(weaponLine[2].trim()), // Length
				new Integer(weaponLine[3].trim()), // Star
				new Type(weaponLine[4].trim(), category)); // Type -- Category
	}

	private WeaponI setAbNormal(String[] weaponLine, RarityI rarity, CategoryI category) {
		return new AbNormalWeapon(weaponLine[0].trim(), // Name
				new Integer(weaponLine[1].trim()), // BaseAttack
				new Affinity(weaponLine[2].trim()), // Affinity
				new Integer(weaponLine[3].trim()), // Star
				new Type(weaponLine[4].trim(), category), // Type -- Category
				rarity // Rarity
		);
	}

}
