/**
 * 
 */
package com.anno.dw8xl.kingdom.facade;

import java.util.Collection;
import java.util.Optional;

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
	
	@Override
	public Collection<KingdomI> getAllKingdoms() {
		return dao.getAll();
	}

	@Override
	public KingdomI getKingdomsByName(String name) {
		Optional<KingdomI> res = dao.getBy(name.toUpperCase());
		return (res.isPresent()) ? res.get() : res.orElse(new NullKingdom());
	}

	@Override
	public void addKingdom(KingdomI kingdom) {
		dao.add(kingdom);
	}

	@Override
	public void removeKingdom(KingdomI kingdom) {
		dao.remove(kingdom); 
	}

//	@Override
//	public KingdomI updateKingdom(String name, KingdomI kingdom) {
//		List<KingdomI> temp = getKingdomsByName(name);
//		return dao.executeUpdateKingdom(temp.get(0), kingdom);
//		
//	}

	

}
