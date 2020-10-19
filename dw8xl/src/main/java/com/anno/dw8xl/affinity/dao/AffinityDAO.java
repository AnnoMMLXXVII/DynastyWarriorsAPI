/**
 * 
 */
package com.anno.dw8xl.affinity.dao;

import java.util.ArrayList;
import java.util.List;

import com.anno.dw8xl.affinity.model.Affinity;
import com.anno.dw8xl.affinity.model.AffinityI;

/**
 * @author Haku Wei
 *
 */
public class AffinityDAO implements AffinityDAO_I{

	private List<AffinityI> affinities;
	private static AffinityDAO_I instance = null;
	
	public static AffinityDAO_I getInstance() {
		if(instance == null) {
			synchronized(AffinityDAO_I.class) {
				if(instance == null) {
					return new AffinityDAO();
				}
			}
		}
		return instance;
	}
	
	private AffinityDAO() {
		affinities = new ArrayList<>();
		initializeAffinities();
	}
	
	@Override
	public List<AffinityI> getAllAffinities() {
		return affinities;
	}

	@Override
	public AffinityI getAffinityByName(String affinity) {
		return affinities.get(findIndex(affinity));
	}

	@Override
	public void createAffinity(String affinity) {
		if(affinities == null) {
			return;
		}
		AffinityI temp = new Affinity(affinity);
		affinities.add(temp);
	}

	@Override
	public void updateAffinity(String before, String after) {
		int idx = findIndex(before);
		if(idx < 0) {
			return;
		}
		AffinityI temp = new Affinity(after);
		removeAffinity(before);
		affinities.add(idx, temp);
		
	}

	@Override
	public void removeAffinity(String affinity) {
		affinities.remove(findIndex(affinity));
	}
	
	private int findIndex(String affinity) {
		int idx = -1;
		if(affinity.isEmpty()) {
			return idx;
		}
		idx++;
		for (AffinityI a : affinities) {
			if(a.getAffinity().equals(affinity)) {
				return idx; 
			}
			idx++;
		}
		return -1;
	}

	private void initializeAffinities() {
		affinities.add(new Affinity("Heaven"));
		affinities.add(new Affinity("Earth"));
		affinities.add(new Affinity("Man"));
	}
}
