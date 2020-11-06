/**
 * 
 */
package com.anno.dw8xl.affinity.dao;

import java.util.List;

import com.anno.dw8xl.affinity.model.AffinityI;
import com.anno.dw8xl.dao.DataAccessObjectInterface;

/**
 * @author Haku Wei
 *
 */
public interface AffinityDAOInterface extends DataAccessObjectInterface<AffinityI, Object>{

	public List<AffinityI> getAllAffinities();

	public AffinityI getAffinityByName(String affinity);

	public void createAffinity(String affinity);

	public void updateAffinity(String before, String after);

	public void removeAffinity(String affinity);
}
