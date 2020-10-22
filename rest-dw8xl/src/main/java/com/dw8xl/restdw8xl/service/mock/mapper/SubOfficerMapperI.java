/**
 * 
 */
package com.dw8xl.restdw8xl.service.mock.mapper;

import java.util.List;

import com.dw8xl.restdw8xl.model.character.CharacterI;

/**
 * @author Haku Wei
 *
 */
public interface SubOfficerMapperI {

	public List<CharacterI> queryAllSubOfficers();
	public List<CharacterI> queryShuSubOfficers();
	public List<CharacterI> queryWuSubOfficers();
	public List<CharacterI> queryWeiSubOfficers();
	public List<CharacterI> queryJinSubOfficers();
	public List<CharacterI> queryOtherSubOfficers();
	
}
