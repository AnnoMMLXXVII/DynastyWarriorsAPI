/**
 * 
 */
package com.anno.dw8xl.kingdom.dao;

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
import org.springframework.stereotype.Service;

import com.anno.dw8xl.dao.DataAccessObjectInterface;
import com.anno.dw8xl.dao.PATH;
import com.anno.dw8xl.kingdom.model.Kingdom;
import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.kingdom.model.NullKingdom;

/**
 * @author Haku Wei
 *
 */
@Service("kingdomDAO")
public class KingdomDAO implements KingdomDAOInterface {

	private static final Logger log = LoggerFactory.getLogger(KingdomDAO.class);
	private Map<String, KingdomI> kingdoms;
	private static KingdomDAOInterface instance = null;

	public static KingdomDAOInterface getInstance() {
		if (instance == null) {
			synchronized (KingdomDAOInterface.class) {
				if (instance == null) {
					log.info("KingdomDAO singleton instantiation...");
					return new KingdomDAO();
				}
			}
		}
		return instance;
	}

	private KingdomDAO() {
		log.info("Initializing Kingdom HashMap...");
		initializeKingdoms();
	}

	@Override
	public Collection<KingdomI> getAll() {
		log.info("Returning kingdom collections...");
		return new ArrayList<>(kingdoms.values());
	}

	@Override
	public Optional<KingdomI> getBy(Object criteria) {
		KingdomI temp;
		log.info("Checking criteria type...");
		if (criteria instanceof KingdomI) {
			log.info("Criteria checking by KingdomI...");
			temp = (KingdomI) criteria;
			temp = kingdoms.get(DataAccessObjectInterface.formatName(temp.getName()));
			return (temp != null) ? Optional.of(temp) : Optional.of(new NullKingdom());
		} else if ((temp = kingdoms.get(criteria)) != null) {
			log.info("Returning Optional instance of Kingdom...");
			return Optional.of(temp);
		} else {
			log.info("Returning Optional instance of NullKingdom...");
			return Optional.of(new NullKingdom());
		}
	}

	@Override
	public void add(KingdomI entity) {
		if (!KingdomDAOInterface.isValidToAdd(entity)) {
			return;
		}
		if (kingdoms.containsValue(entity)) {
			log.info("Cannot add Kingdom due to duplicate...");
			return;
		}
		log.info("Adding Kingdom...");
		kingdoms.put(entity.getName(), entity);
	}

	@Override
	public void remove(KingdomI entity) {
		if (!KingdomDAOInterface.isValidToRemove(entity)) {
			return;
		}
		if (kingdoms.containsKey(entity.getName())) {
			log.debug("Could not find Kingdom to remove...");
			return;
		}
		log.info("Removing Kingdom...");
		kingdoms.remove(DataAccessObjectInterface.getKey(kingdoms, entity), entity);
	}

	private void initializeKingdoms() {
		KingdomI kingdom = null;
		kingdoms = new HashMap<>();
		File file = new File(PATH.KINGDOM_PATH.getStringUrl());
		try (Scanner z = new Scanner(new FileReader(file))) {
			String[] kingdomLine = null;
			while (z.hasNextLine()) {
				String line = z.nextLine();
				kingdomLine = line.split(",");
				kingdom = new Kingdom(kingdomLine[0].trim());
				kingdoms.put(kingdom.getName(), kingdom);
			}
		} catch (FileNotFoundException e) {
			log.debug(String.format("Error: %s", e.getMessage()));
		}
	}

}
