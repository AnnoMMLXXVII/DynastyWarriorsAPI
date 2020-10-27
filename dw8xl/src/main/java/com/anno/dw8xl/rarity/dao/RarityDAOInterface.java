/**
 * 
 */
package com.anno.dw8xl.rarity.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.dw8xl.dao.DataAccessObjectInterface;
import com.anno.dw8xl.rarity.model.NullRarity;
import com.anno.dw8xl.rarity.model.RarityI;

/**
 * @author venividivicihofneondeion010101
 *
 */
public interface RarityDAOInterface extends DataAccessObjectInterface<RarityI, Object> {

	static final Logger log = LoggerFactory.getLogger(RarityDAO.class);

	static boolean isValidToAdd(RarityI entity) {
		if (entity == null) {
			log.info("Cannot add Rarity due to Null Exception...");
			throw new NullPointerException("Rarity cannot be added due to Null!");
		}
		if (entity instanceof NullRarity || entity.getType().equals("")) {
			log.info("Cannot add Rarity due to Null Or Empty Rarity...");
			return false;
		}
		return true;
	}

	static boolean isValidToRemove(RarityI entity) {
		if (entity == null) {
			log.info("Cannot remove Rarity due to Null Exception...");
			throw new NullPointerException("Rarity cannot be removed due to Null!");
		}
		if (entity instanceof NullRarity || entity.getType().equals("")) {
			log.info("Cannot remove Rarity due to Null Or Empty Rarity...");
			return false;
		}
		return true;
	}

}
