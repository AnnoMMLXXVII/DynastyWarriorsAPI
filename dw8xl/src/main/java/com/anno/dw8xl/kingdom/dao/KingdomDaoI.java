/**
 * 
 */
package com.anno.dw8xl.kingdom.dao;

import java.util.List;

import com.anno.dw8xl.kingdom.model.KingdomI;

/**
 * @author Haku Wei
 *
 */
public interface KingdomDaoI {

	public List<KingdomI> getAllKingdoms();
	public KingdomI getKingdomByName(String kingdom);
//	public void addKingdom(KingdomI kingdom);
//	public int removeKingdomByName(String kingdom);
	public void updateKingdomNameByName(KingdomI kingdom);
	
}
