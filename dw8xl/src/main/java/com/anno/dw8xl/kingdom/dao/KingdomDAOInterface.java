/**
 * 
 */
package com.anno.dw8xl.kingdom.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anno.dw8xl.dao.DataAccessObjectInterface;
import com.anno.dw8xl.kingdom.model.KingdomI;

/**
 * @author Haku Wei
 *
 */
public interface KingdomDAOInterface extends DataAccessObjectInterface<KingdomI, Object> {

	static final Logger log = LoggerFactory.getLogger(KingdomDAO.class);

	static boolean isValidToRemove(KingdomI entity) {
		if (entity == null) {
			log.debug("Cannot remove Kingdom due to Null Exception...");
			throw new NullPointerException("Kngdom cannot be removed due to Null!");
		}
		if (entity.getName().equals("")) {
			log.debug("Cannot add Kingdom due to Empty Kingdom...");
			return false;
		}
		return true;
	}

	static boolean isValidToAdd(KingdomI entity) {
		if (entity == null) {
			log.debug("Cannot add Kingdom due to Null Exception...");
			throw new NullPointerException("Kngdom cannot be added due to Null!");
		}
		if (entity.getName().equals("")) {
			log.debug("Cannot add Kingdom due to Empty Kingdom...");
			return false;
		}
		return true;
	}

}
