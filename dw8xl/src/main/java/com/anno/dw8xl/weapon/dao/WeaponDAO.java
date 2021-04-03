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
import org.springframework.stereotype.Service;

import com.anno.dw8xl.affinity.dao.AffinityDAO;
import com.anno.dw8xl.affinity.model.Affinity;
import com.anno.dw8xl.affinity.model.AffinityI;
import com.anno.dw8xl.attribute.model.AttributeI;
import com.anno.dw8xl.attribute.model.Special;
import com.anno.dw8xl.category.model.Category;
import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.character.model.Weapons;
import com.anno.dw8xl.dao.PATH;
import com.anno.dw8xl.kingdom.dao.KingdomDAO;
import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.length.model.Length;
import com.anno.dw8xl.level.model.Level;
import com.anno.dw8xl.rarity.model.Rarity;
import com.anno.dw8xl.rarity.model.RarityI;
import com.anno.dw8xl.type.model.Type;
import com.anno.dw8xl.weapon.model.AbNormal;
import com.anno.dw8xl.weapon.model.Normal;
import com.anno.dw8xl.weapon.model.WeaponI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Service("weaponDAO")
public class WeaponDAO implements WeaponDAOInterface {

	private static final Logger log = LoggerFactory.getLogger(WeaponDAO.class);
	private static WeaponDAOInterface instance;
	private Map<String, WeaponI> weapons;
	private Map<String, WeaponI> postman;
	private Map<WeaponKey, Attributes> weaponAttributes;

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

	private WeaponDAO() {
		weapons = new HashMap<>();
		postman = new HashMap<>();
		weaponAttributes = new HashMap<>();
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

	@Override
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

	@Override
	public Map<String, WeaponI> getWeapons() {
		return weapons;
	}

	@Override
	public Map<String, WeaponI> getPostman() {
		return postman;
	}

	@Override
	public Map<String, Weapons> getTypeHash() {
		Map<String, Weapons> temp = new HashMap<>();
		Collection<WeaponI> database = this.getAll();
		String key = "";
		for (WeaponI w : database) {
			key = w.getType().getName();
			Weapons list;
			if (temp.containsKey(key)) {
				list = temp.get(key);
				list.getWeapons().add(w);
				temp.put(key, list);
			} else {
				list = new Weapons(new ArrayList<>());
				list.getWeapons().add(w);
				temp.put(key, list);
			}
		}
		return temp;
	}

	@Override
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
			return weapons.values().stream().filter(e -> e instanceof Normal).collect(Collectors.toList());
		} else if (state.equalsIgnoreCase("abnormal")) {
			return weapons.values().stream().filter(e -> e instanceof AbNormal).collect(Collectors.toList());
		} else {
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

	@Override
	public Collection<WeaponI> getMappedWeaponsToAttributes() {
		Collection<WeaponI> abnormals = getWeaponsByState("abnormal");
		mapWeaponsToAttributes(abnormals);
		return abnormals;
	}

	@Override
	public Map<WeaponKey, Attributes> getWeaponAttributesMap() {
		return weaponAttributes;
	}

	private void initialize() {
		log.info("Calling method that will parse through Weapons Files...");
		parseThroughMultipleWeaponsTextFiles();
		parseThroughWeaponAttributesTextFiles();
		mapWeaponsToAttributes(getAll());
		System.out.printf("346->W-A is Empty : %s-->%s%n", getWeaponAttributesMap().isEmpty());
		System.out.println(getAll().isEmpty());

	}

	private void mapWeaponsToAttributes(Collection<WeaponI> weapons) {
		WeaponKey dummyKey = null;
		Map<WeaponKey, Attributes> dummyWeaponAttributes = getWeaponAttributesMap();
		if (dummyWeaponAttributes.isEmpty()) {
			parseThroughWeaponAttributesTextFiles();
			dummyWeaponAttributes = getWeaponAttributesMap();
		}
		for (WeaponI w : weapons) {
			if (w instanceof AbNormal) {
				dummyKey = new WeaponKey(w.getName(), w.getType());
				w.setAttributes(dummyWeaponAttributes.get(dummyKey));
			}
		}
	}

	private void setWeaponAttributes(Map<WeaponKey, Attributes> weaponAttributes) {
		this.weaponAttributes = weaponAttributes;
	}

	private void mapArrayToMap(WeaponI[] weapons) {
		WeaponKey key = null;
		for (WeaponI w : weapons) {
			key = new WeaponKey(w.getName(), w.getType());
			postman.put(key.toString(), w);
		}
	}

	private void parseThroughMultipleWeaponsTextFiles() {
		log.info("Getting all kingdoms...");
		List<KingdomI> kingdoms = (List<KingdomI>) KingdomDAO.getInstance().getAll();
		if (kingdoms.isEmpty()) {
			log.debug("KingdomI List size is empty");
		}
		log.info("Assigning the characterPaths based on flag...");
		PATH[][] categoriesPaths = { PATH.getDasherWeaponsPaths(), PATH.getWhirlwindWeaponsPaths(),
				PATH.getDiverWeaponsPaths(), PATH.getShadowWeaponsPaths() };
		CategoryI[] categories = { new Category("Dasher"), new Category("Whirlwind Master"), new Category("Diver"),
				new Category("Shadow Sprinter") };
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
					parseThrougSinglehWeaponTextFile(categoriesPaths[i][j].getStringUrl(), weapons, categories[i],
							rarities[k], isNormal);
				} catch (Exception e) {
					log.debug(String.format("%s :: Error: %s...%n", categoriesPaths[i][j].getStringUrl(),
							e.getMessage()));
				}
			}
		}
	}

	private void parseThrougSinglehWeaponTextFile(String path, Map<String, WeaponI> weapons, CategoryI category,
			RarityI rarity, boolean isNormal) {
		WeaponI weapon = null;
		WeaponKey key = null;
		String line = null;
		File file = new File(path);
		try (Scanner z = new Scanner(new FileReader(file))) {
			String[] weaponLine = null;
			log.debug(String.format("%s...", file.getPath()));
			while (z.hasNextLine()) {
				line = z.nextLine().trim();
				weaponLine = line.split(",");
				weapon = (isNormal) ? setNormal(weaponLine, category) : setAbNormal(weaponLine, rarity, category);
				key = new WeaponKey(weapon.getName(), weapon.getType());
				weapons.put(key.toString(), weapon);
			}

		} catch (FileNotFoundException e) {
			log.debug(String.format("FNFE Error: %s...", e.getMessage()));
		} catch (IllegalArgumentException iae) {
			log.debug(String.format("Argument Error: %s...", line));
		}
	}

	private void parseThroughWeaponAttributesTextFiles() {
		PATH[] weaponAttributesFiles = PATH.getWeaponsAttributesLevelsPaths();
		try {
			for (int i = 0; i < weaponAttributesFiles.length; i++) {
				parseThroughSingleWeaponAttributesTextFile(weaponAttributesFiles[i].getStringUrl());
			}
		} catch (NullPointerException e) {
			log.debug(String.format("NPE EXCEPTION Error: %s --> %s", e.getMessage(),
					weaponAttributes.get(new WeaponKey("Dark Dragon Spear", new Type("Dragon Spear")))));
		}
		setWeaponAttributes(weaponAttributes);
		System.out.printf("347->W-A is Empty : %s%n", getWeaponAttributesMap().isEmpty());
		System.out.printf("348->Coll : %s%n", getWeaponAttributesMap()
				.get(new WeaponKey("Dark Dragon Spear", new Type("Dragon Spear"))).toString());
	}

	private void parseThroughSingleWeaponAttributesTextFile(String path) {
		WeaponKey key = null;
		List<AttributeI> attributeList = null;
		final String delimiter = ",";
		File file = new File(path);
		try (Scanner z = new Scanner(new FileReader(file))) {
			String[] weaponAttributeLine = null;
			log.debug(String.format("%s...", file.getPath()));
			int j = 0;
			while (z.hasNextLine()) {
				attributeList = new ArrayList<>(6);
				String line = z.nextLine().trim();
				weaponAttributeLine = line.split(delimiter);
				key = new WeaponKey(weaponAttributeLine[0].trim(), new Type(weaponAttributeLine[1].trim()));
				AttributeI tempAttr = null;
				for (int i = 2; i < weaponAttributeLine.length; i++) {
					tempAttr = parseThroughSingleAttribute(j, weaponAttributeLine[i].trim());
					attributeList.add(tempAttr);
				}
//				System.out.printf("[%24s,%24s] : Size --> %d\n", key.getWeaponName(), key.getWeaponType().getName(),
//						(weaponAttributeLine.length - 2));
				j++;
				executePutToWeaponAttributesMap(key, new Attributes(attributeList));
			}
		} catch (FileNotFoundException e) {
			log.info(String.format("FNFE Error: %s...", e.getMessage()));
		}
//		return weaponAttributes;
	}

	private AttributeI parseThroughSingleAttribute(int lineNum, String weaponAttributeStr) {
		AttributeI temp = null;
		final String delimiter = ":";
		try {
			if (weaponAttributeStr.contains(delimiter)) {
				String[] attributeLine = weaponAttributeStr.split(delimiter);
//				System.out.printf(String.format("[%d] - [%24s, %24s]\tAssigning Normal Attribute \t[%s : %s]%n", lineNum,
//						key.getWeaponName(), key.getWeaponType().getName(), attributeLine[0], attributeLine[1]));
				temp = setNormalAttribute(attributeLine[0].trim(), Integer.parseInt(attributeLine[1].trim()));
			} else {
//				System.out.printf(String.format("[%d] - [%24s, %24s]\tAssigning Special Attribute \t[%s]%n", lineNum,
//						key.getWeaponName(), key.getWeaponType().getName(), weaponAttributeStr));
				temp = setSpecialAttribute(weaponAttributeStr.trim());
			}
			System.out.printf("391->W-A is Empty : %s-->%s%n", weaponAttributes.isEmpty(), weaponAttributeStr);
		} catch (IllegalArgumentException e) {
			log.debug(String.format("ERROR: Formatting issue [%s]...", weaponAttributeStr));
		}
		return temp;
	}

	private void executePutToWeaponAttributesMap(WeaponKey key, Attributes attributes) {
//		long start = System.nanoTime();

		try {
			weaponAttributes.put(key, attributes);
			System.out.println(key.toString());
			System.out.printf("405->W-A is Empty : %s-->%s%n", weaponAttributes.isEmpty(), weaponAttributes.get(key));
//			System.out.printf("[%24s,%24s] : [%d] -> [%5d] ==> %s%n", key.getWeaponName(),
//					key.getWeaponType().getName(), attributes.getAttribute().size(), (System.nanoTime() - start),
//					weaponAttributes.get(key));
		} catch (NullPointerException e) {
			log.debug(String.format("Error Putting to Map: NPE", e.getMessage()));
		}
//		System.out.print(weaponAttributes.get(key));
	}

	private com.anno.dw8xl.attribute.model.Normal setNormalAttribute(String str, Integer num) {
//		System.out.printf("Normal Instantiated : %s\n", temp.getName());
		return new com.anno.dw8xl.attribute.model.Normal(str, new Level(num));
	}

	private Special setSpecialAttribute(String str) {
//		System.out.printf("Special Instantiated : %s\n", str);
		return new Special(str);
	}

	private WeaponI setNormal(String[] weaponLine, CategoryI category) {
		return new Normal(weaponLine[0].trim(), // Name
				new Integer(weaponLine[1].trim()), // BaseAttack
				new Length(weaponLine[2].trim()), // Length
				new Integer(weaponLine[3].trim()), // Star
				new Type(weaponLine[4].trim(), category)); // Type -- Category
	}

	private WeaponI setAbNormal(String[] weaponLine, RarityI rarity, CategoryI category) {
		return new AbNormal(weaponLine[0].trim(), // Name
				new Integer(weaponLine[1].trim()), // BaseAttack
				new Affinity(weaponLine[2].trim()), // Affinity
				new Integer(weaponLine[3].trim()), // Star
				new Type(weaponLine[4].trim(), category), // Type -- Category
				rarity // Rarity
		);
	}

}
