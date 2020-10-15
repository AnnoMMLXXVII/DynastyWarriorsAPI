/**
 * 
 */
package com.anno.dw8xl.kingdom.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anno.dw8xl.kingdom.model.KingdomI;

/**
 * @author Haku Wei
 *
 */
@Repository
public class KingdomDao implements KingdomDaoI{
	
	@Autowired
	private KingdomDaoImpl impl;
	
	@Override
	public List<KingdomI> getAllKingdoms() {
		List<KingdomI> temp = new ArrayList<>();
		temp = impl.getAllKingdoms();
		if(temp.isEmpty() || temp == null) {
			throw new IllegalArgumentException("Null or Empty Response");
		}
		return temp;
	}

	@Override
	public KingdomI getKingdomByName(String kingdom) {
		return impl.getKingdomByName(kingdom);
	}

	@Override
	public void updateKingdomNameByName(KingdomI kingdom) {
		
	}

}
