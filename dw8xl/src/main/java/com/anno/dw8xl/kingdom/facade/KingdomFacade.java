/**
 * 
 */
package com.anno.dw8xl.kingdom.facade;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.dw8xl.dao.DAO;
import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.kingdom.model.NullKingdom;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Service("kingomFacade")
public class KingdomFacade implements KingdomFacade_I {

	@Autowired
	private DAO<KingdomI, Object> dao;
	private static final Logger log = LoggerFactory.getLogger(KingdomFacade.class);
	
	@Override
	public Collection<KingdomI> getAllKingdoms() {
		log.info("Returning new ArrayList of Kingdoms...");
		return dao.getAll();
	}

	@Override
	public <E> KingdomI getKingdomsBy(E criteria) {
//		KingdomI temp = new NullKingdom();
//		log.info("Checking criteria type...");
//		if(criteria instanceof KingdomI) {
//			log.info("Criteria checking by KingdomI...");
//			temp = (KingdomI)criteria;
//		}
//		else if(criteria instanceof String) {
//			log.info("Criteria checking by String...");
//			temp = new Kingdom(DAO.formatName((String)criteria));
//		}
		Optional<KingdomI> res = dao.getBy(criteria);
		return (res.isPresent()) ? res.get() : res.orElse(new NullKingdom());
	}

	@Override
	public void addKingdom(KingdomI kingdom) {
		log.info("Checking if new Kingdom already exists...");
		if(dao.getAll().contains(kingdom)) {
			log.info("Cannot add Kingdom due to already-existing kingdom...");
			return;
		}
		dao.add(kingdom);
	}

	@Override
	public void removeKingdom(KingdomI kingdom) {
		log.info("Checking if kingdom exists...");
		if(!dao.getAll().contains(kingdom)) {
			log.info("Throwing Error due to non-existent kingdom...");
			throw new IllegalArgumentException("Unable to Remove Kingdom: Does not Exist...");
		}
		dao.remove(kingdom); 
	}	

}
