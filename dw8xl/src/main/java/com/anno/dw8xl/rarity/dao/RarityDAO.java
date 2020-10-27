package com.anno.dw8xl.rarity.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.dw8xl.dao.PATH;
import com.anno.dw8xl.rarity.model.NullRarity;
import com.anno.dw8xl.rarity.model.Rarity;
import com.anno.dw8xl.rarity.model.RarityI;

/**
 * @author venividivicihofneondeion010101
 *
 */
public class RarityDAO implements RarityDAOInterface {

	private static RarityDAOInterface instance = null;
	private Map<String, RarityI> rarities;
	public static final Logger log = LoggerFactory.getLogger(RarityDAO.class)
			;
	public static RarityDAOInterface getInstance() {
		if(instance == null) {
			synchronized(RarityDAOInterface.class) {
				if(instance == null) {
					log.info("RarityDAO_I singleton instantiation");
					return new RarityDAO();
				}
			}
		}
		return instance;
	}
	
	private RarityDAO() {
		rarities = new HashMap<>();
		log.info("Initializing rarities map...");
		initialize();
	}

	@Override
	public Collection<RarityI> getAll() {
		log.info("Returning all Rarities...");
		return new ArrayList<>(rarities.values());
	}

	@Override
	public Optional<RarityI> getBy(Object criteria) {
		RarityI temp;
		if(criteria instanceof RarityI) {
			log.info("Criteria is instance of RarityI...");
			temp = (RarityI)criteria;
			temp = rarities.get(temp.getType());
			return (temp != null) ? Optional.of(temp) : Optional.of(new NullRarity());
		}
		else if((temp = rarities.get(criteria)) != null){
			return Optional.of(temp);
		}
		else {
			return Optional.of(new NullRarity());
		}
	}

	@Override
	public void add(RarityI entity) {
		if(!RarityDAOInterface.isValidToAdd(entity)) {
			return;
		}
		if(rarities.containsValue(entity)) {
			log.info("Cannot add Rarity due to duplicate...");
			return;
		}
		rarities.put(entity.getType(), entity);
		log.debug("Rarities added to Rarity Map...");
	}

	@Override
	public void remove(RarityI entity) {
		if(!RarityDAOInterface.isValidToRemove(entity)) {
			return;
		}
		if(!rarities.containsValue(entity)) {
			log.info("Cannot find Rarity to remove...");
			return;
		}
		log.info("Removing Rarity from Rarities Map...");
		rarities.remove(entity.getType(), entity);
	}
	
	private void initialize() {
		RarityI temp;
		File file = new File(PATH.RARITY_PATH.getStringUrl());			
		try (Scanner z = new Scanner(new FileReader(file))){
			String[] rarityLine = null;
			while (z.hasNextLine()) {
				String line = z.nextLine();
				rarityLine = line.split(",");
				temp= new Rarity(rarityLine[0]);
				rarities.put(temp.getType(), temp);
			}
		}
		catch(FileNotFoundException e) {
			log.info(String.format("Error: %s...", e.getMessage()));
			
		}
	}	
}