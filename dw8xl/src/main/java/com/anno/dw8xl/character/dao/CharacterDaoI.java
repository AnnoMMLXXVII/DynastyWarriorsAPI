/**
 * 
 */
package com.anno.dw8xl.character.dao;

import java.util.List;

import com.anno.dw8xl.character.model.CharacterI;

/**
 * @author Haku Wei
 *
 */
public interface CharacterDaoI {

	public List<CharacterI> queryAllSubOfficers();
	public List<CharacterI> queryShuSubOfficers();
	public List<CharacterI> queryWuSubOfficers();
	public List<CharacterI> queryWeiSubOfficers();
	public List<CharacterI> queryJinSubOfficers();
	public List<CharacterI> queryOtherSubOfficers();
}
