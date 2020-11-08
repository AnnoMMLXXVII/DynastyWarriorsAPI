/**
 * 
 */
package com.anno.dw8xl.kingdom.facade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.dw8xl.kingdom.dao.KingdomDAOInterface;
import com.anno.dw8xl.kingdom.model.KingdomI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Service("kingomFacade")
public class KingdomFacade implements KingdomFacadeInterface {

	@Autowired
	private KingdomDAOInterface dao;
	private static final Logger log = LoggerFactory.getLogger(KingdomFacade.class);
	private Collection<KingdomI> inValid;

	@Override
	public Collection<KingdomI> getAllKingdoms() {
		log.info("Returning new ArrayList of Kingdoms...");
		return dao.getAll();
	}

	@Override
	public Collection<KingdomI> getKingdomsBy(String... params) {
		List<String> names = removeDuplicates(params);
		Collection<KingdomI> kingdoms = new ArrayList<>(params.length);
		for (String s : names) {
			Optional<KingdomI> temp = dao.getBy(s);
			if (temp.isPresent()) {
				kingdoms.add(temp.get());
			}
		}
		return kingdoms;
	}

	@Override
	public void addKingdom(KingdomI kingdom) {
		log.info("Checking if new Kingdom already exists...");
		if (dao.getAll().contains(kingdom)) {
			log.info("Cannot add Kingdom due to already-existing kingdom...");
			return;
		}
		dao.add(kingdom);
	}

	@Override
	public Collection<KingdomI> removeKingdom(KingdomI... kingdoms) {
		inValid = isValid(kingdoms);
		System.out.println(!inValid.isEmpty());
		if (!inValid.isEmpty()) {
			return inValid;
		}

		String json = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(kingdoms);
		} catch (JsonProcessingException e) {
			logException(e);
		}
		return dao.executeRemoveKingdom(json);
	}

	private Collection<KingdomI> isValid(KingdomI... kingdoms) {
		inValid = new ArrayList<>();
		for (KingdomI k : kingdoms) {
			Optional<KingdomI> temp = dao.getBy(k.getName());
			if (!temp.isPresent()) {
				inValid.add(k);
			}
		}
		return inValid;
	}

	private List<String> removeDuplicates(String... names) {
		log.debug("Removing all possible duplicates from the Request Parameter");
		return Arrays.asList(names).stream().distinct().collect(Collectors.toList());
	}

	private void logException(Exception e) {
		log.debug(String.format("%s", e.getMessage()));
	}

}
