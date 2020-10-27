/**
 * 
 */
package com.anno.dw8xl.weapon.dao;

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

import com.anno.dw8xl.affinity.model.Affinity;
import com.anno.dw8xl.category.model.Category;
import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.character.dao.CharacterDAOInterface;
import com.anno.dw8xl.dao.PATH;
import com.anno.dw8xl.kingdom.dao.KingdomDAO;
import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.length.model.Length;
import com.anno.dw8xl.rarity.model.RarityI;
import com.anno.dw8xl.type.model.Type;
import com.anno.dw8xl.type.model.TypeI;
import com.anno.dw8xl.weapon.model.AbNormal;
import com.anno.dw8xl.weapon.model.Normal;
import com.anno.dw8xl.weapon.model.WeaponI;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Service("weaponDAO")
public class WeaponDAO implements WeaponDAOInterface {

	private static final Logger log = LoggerFactory.getLogger(WeaponDAO.class);
	private static WeaponDAOInterface instance;
	private Map<String, WeaponI> weapons;
	private Map<TypeI, List<WeaponI>> typeWeapons;
	
	public static WeaponDAOInterface getInstance() {
		log.info("CharacterDAO Singleton instantiation...");
		if (instance == null) {
			synchronized (CharacterDAOInterface.class) {
				if (instance == null) {
					return new WeaponDAO();
				}
			}
		}
		return instance;
	}
	
	private WeaponDAO() {
		weapons = new HashMap<>();
		typeWeapons = new HashMap<>();
		initialize();
	}

	@Override
	public Collection<WeaponI> getAll() {
		System.out.println(weapons.size());
		return new ArrayList<>(weapons.values());
	}

	@Override
	public Optional<WeaponI> getBy(Object criteria) {
		return null;
	}

	@Override
	public void add(WeaponI entity) {
		
	}

	@Override
	public void remove(WeaponI entity) {
		
	}
	
	private void initialize() {
		log.info("Calling method that will parse through Weapons Files...");
		log.info("Parsing through Officer files...");
		parseThroughMultipleWeaponsTextFiles(true);
		log.info("Parsing through Sub-Officer files...");
		parseThroughMultipleWeaponsTextFiles(false);
	}

	private void parseThroughMultipleWeaponsTextFiles(boolean flag) {
		log.info("Getting all kingdoms...");
		List<KingdomI> kingdoms = (List<KingdomI>) KingdomDAO.getInstance().getAll();
		if (kingdoms.isEmpty()) {
			log.debug("KingdomI List size is empty");
		}
		log.info("Assigning the characterPaths based on flag...");
		PATH[][] categoriesPaths = {
				PATH.getDasherWeaponsPaths(),
//				PATH.getWhirlwindWeaponsPaths(),
//				PATH.getDiverWeaponsPaths(),
//				PATH.getShadowWeaponsPaths(),
		};
		CategoryI[] categories = {new Category("Dasher"), new Category("Whirlwind")};
		log.info("Parsing throgh character files (Officer or SubOfficer)...");
		int i = 0, j = 0;
//		for (int i = 0; i < categoriesPaths.length; i++) {
//			for (int j = 0; j < categoriesPaths[i].length-3; j++) {
				try {
					parseThroughWeaponTextFile(categoriesPaths[i][j].getStringUrl(), weapons, typeWeapons, categories[i]);
				} catch (Exception e) {
					log.info(String.format("Error: %s...", e.getMessage()));
				}
//			}
//		}
	}

	private void parseThroughWeaponTextFile(String path, Map<String, WeaponI> weapons, Map<TypeI, List<WeaponI>> typeWeapons, CategoryI category ) {
		WeaponI weapon = null;
		File file = new File(path);
		try (Scanner z = new Scanner(new FileReader(file))) {
			String[] weaponLine = null;
			List<WeaponI> temp;
			while (z.hasNextLine()) {
				temp = new ArrayList<>();
				String line = z.nextLine();
				weaponLine = line.split(",");
				weapon = setNormal(weaponLine,category);
				weapons.put(weapon.getName(), weapon);
				typeWeapons.put(weapon.getType(), temp);
			}
		} catch (FileNotFoundException e) {
			log.info(String.format("Error: %s...", e.getMessage()));
		}
	}
	
	private WeaponI setNormal(String[] weaponLine, CategoryI category) {
		return new Normal(
				weaponLine[0].trim(), 						// Name
				new Integer(weaponLine[1].trim()), 			// BaseAttack
				new Length(weaponLine[2].trim()), 			// Length
				new Integer(weaponLine[3].trim()), 							// Star
				new Type(weaponLine[4].trim(), category));	// Type
	}
	
	private WeaponI setAbNormal(String[] weaponLine, RarityI rarity, CategoryI category) {
		return new AbNormal (
				weaponLine[0].trim(), 					// Name
				new Integer(weaponLine[1].trim()), 		// BaseAttack
				new Affinity(weaponLine[2].trim()), 	// Affinity
				new Integer(weaponLine[3].trim()), 		// Star
				new Type(weaponLine[4].trim(), category),			// Type
				rarity
				);		
	}

}
