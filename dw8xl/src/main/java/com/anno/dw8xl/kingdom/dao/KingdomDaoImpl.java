/**
 * 
 */
package com.anno.dw8xl.kingdom.dao;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.kingdom.model.Kingdoms;

/**
 * @author Haku Wei
 *
 */
@Service("kingdomDaoImpl")
public class KingdomDaoImpl {

	private List<KingdomI> kingdoms;
//	private Map<KingdomI, String> mappedKingdoms;
	
	public KingdomDaoImpl() {
		kingdoms = new ArrayList<KingdomI>(getKingdoms());
//		mappedKingdoms = new HashMap<Integer, KingdomI>();
	}
	
	private EnumSet<Kingdoms> getKingdoms() {
		return EnumSet.allOf(Kingdoms.class);
	}
	
	public List<KingdomI> getAllKingdoms() {
		return (kingdoms == null || kingdoms.isEmpty()) ? new ArrayList<>() : kingdoms;
	}
	
	public KingdomI getKingdomByName(String name) {
		kingdoms = getAllKingdoms();
		return kingdoms.stream()
				.filter(k -> k.getKingdom().equalsIgnoreCase(name))
				.findFirst().get();
	}
	
	private void addKingdom(KingdomI kingdom) {
		if(kingdom == null) {
			return;
		}
		if(kingdomMatchesExisting(kingdom)) {
			return;
		}
//		kingdoms.add(kingdom);
//		Enumeration<KingdomI> k = Collections.enumeration(kingdoms);
	}
	
	private boolean kingdomMatchesExisting(KingdomI kingdom) {
		return kingdoms.stream().anyMatch(k -> k.getKingdom().toLowerCase().equals(kingdom.getKingdom().toLowerCase()));
	}
	
	
	
	

}
