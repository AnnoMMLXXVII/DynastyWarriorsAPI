/**
 * 
 */
package com.anno.dw8xl.kingdom.dao;

import java.util.List;
import java.util.Optional;

/**
 * @author Haku Wei
 *
 */
public interface KingdomDAO_I<KingdomI> {

	public Optional<List<KingdomI>> executeGetAllKingdoms();
	public List<KingdomI> executeGetKingdomByName(String...kingdom);
	public List<KingdomI> executeGetKingdomByWildCard(String name);
	
	public Boolean executeAddKingdom(KingdomI kingdom);
	public int executeRemoveKingdom(String kingdom);
	public KingdomI executeUpdateKingdom(KingdomI old, KingdomI kingdom);
	
}
