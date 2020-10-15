/**
 * 
 */
package com.anno.dw8xl.character.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anno.dw8xl.character.model.CharacterI;

/**
 * @author Haku Wei
 *
 */
@Repository
public class CharacterDao implements CharacterDaoI {

	@Autowired
	CharacterDaoImpl impl;

	@Override
	public List<CharacterI> queryAllSubOfficers() {
		List<CharacterI> temp = new ArrayList<>();
		temp = impl.executeAllSubOfficers();
		if(temp.isEmpty() || temp == null) {
			throw new IllegalArgumentException("Null or Empty Response");
		}
		return temp;
	}

	@Override
	public List<CharacterI> queryShuSubOfficers() {
		return impl.executeShuSubOfficers();
	}

	@Override
	public List<CharacterI> queryWuSubOfficers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CharacterI> queryWeiSubOfficers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CharacterI> queryJinSubOfficers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CharacterI> queryOtherSubOfficers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
