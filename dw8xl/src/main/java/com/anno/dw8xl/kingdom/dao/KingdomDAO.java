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

import com.anno.dw8xl.dao.DAO;
import com.anno.dw8xl.kingdom.model.Kingdom;
import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.kingdom.model.NullKingdom;

/**
 * @author Haku Wei
 *
 */
@Service("kingdomDAO")
public class KingdomDAO implements DAO<KingdomI, Object>{
	
	
	private static final Logger log = LoggerFactory.getLogger(KingdomDAO.class);
	private static DAO<KingdomI, Object> instance = null;
	private static Map<String, KingdomI> kingdoms;
	
	public static DAO<KingdomI, Object> getInstance() {
		if(instance == null) {
			synchronized (DAO.class) {
				if(instance == null) {
					return new KingdomDAO();
				}
			}
		}
		return instance;
	}
	
	private KingdomDAO() {
		log.info("Initializing Kingdom HashMap...");
		kingdoms = new HashMap<>(); 
		initializeKingdoms();
	}
	

	@Override
	public Collection<KingdomI> getAll() {
		return new ArrayList<>(kingdoms.values());
	}

	@Override
	public Optional<KingdomI> getBy(Object criteria) {
		KingdomI temp = new NullKingdom();
		log.info("Checking criteria type...");
		if(criteria instanceof KingdomI) {
			log.info("Criteria checking by KingdomI...");
			temp = (KingdomI)criteria;
		}
		else if(criteria instanceof String) {
			log.info("Criteria checking by String...");
			temp = new Kingdom(DAO.formatName((String)criteria));
		}
		log.info("Returning Optional instance of Kingdom...");
		return kingdoms.containsValue(temp) ? Optional.of(temp) : Optional.ofNullable(new NullKingdom());
	}

	@Override
	public void add(KingdomI entity) {
		log.info("Adding new Kingdom into mapped key-values...");
		kingdoms.put(entity.getName(), entity);

	}

	@Override
	public void remove(KingdomI entity) {	
		log.info("Removing kingdom from mapped key-values...");
		kingdoms.remove(DAO.getKey(kingdoms, entity), entity);
	}
	
	
	
	private void initializeKingdoms() {
		log.info("New instance of Map with String, KingdomI key-value pairs...");
		String path = "Text-Files/kingdoms/kingdom.txt";
		KingdomI kingdom = null;
		File file = new File(URL_ROOT+path);
		try (Scanner z = new Scanner(new FileReader(file))) {
			String[] kingdomLine = null;
			while (z.hasNextLine()) {
				String line = z.nextLine();
				kingdomLine = line.split(",");
				kingdom = new Kingdom(kingdomLine[0].trim());  
				kingdoms.put(kingdom.getName(), kingdom);
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
