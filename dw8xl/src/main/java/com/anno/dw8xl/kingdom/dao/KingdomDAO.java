/**
 * 
 */
package com.anno.dw8xl.kingdom.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
	private Map<String, KingdomI> kingdoms;
	
	public DAO<KingdomI, Object> getInstance() {
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
		kingdoms = initializeKingdoms();
	}
	

	@Override
	public Collection<KingdomI> getAll() {
		log.info("Returning new ArrayList of Kingdoms...");
		return new ArrayList<>(kingdoms.values());
	}

	@Override
	public Optional<KingdomI> getBy(Object criteria) {
		log.info("Searching and Returning for Mapped Value...");
		KingdomI temp = kingdoms.get(criteria);
		log.info("Returning Optional instance of Kingdom...");
		return Optional.of(temp);
	}

	@Override
	public void add(KingdomI entity) {
		log.info("Checking if new Kingdom already exists...");
		if(kingdoms.get(entity.getKingdom().toUpperCase()) == null) {
			log.info("Adding new Kingdom into mapped key-values...");
			kingdoms.put(entity.getKingdom().toUpperCase(), entity);
		}
	}

	@Override
	public void remove(KingdomI entity) {
		log.info("Checking if kingdom exists...");
		if(kingdoms.get(entity.getKingdom().toUpperCase()) != null) {
			log.info("Removing kingdom from mapped key-values...");
			kingdoms.remove(entity.getKingdom().toUpperCase(), entity);
		}
		
	}

	private Map<String, KingdomI> initializeKingdoms() {
		log.info("New instance of Map with String, KingdomI key-value pairs...");
		Map<String, KingdomI> temp = new HashMap<>();
		log.info("Adding SHU...");
		temp.put("SHU", Kingdom.SHU);
		log.info("Adding WU...");
		temp.put("WU", Kingdom.WU);
		log.info("Adding Wei...");
		temp.put("WEI", Kingdom.WEI);
		log.info("Adding Jin...");
		temp.put("JIN", Kingdom.JIN);
		log.info("Adding Other...");
		temp.put("OTHER", Kingdom.OTHER);
		return temp;
	}

}
