package com.dw8xl.restdw8xl.dao;

import java.util.List;

import com.dw8xl.restdw8xl.model.character.CharacterI;

/**
 * @author Haku Wei
 *
 */
public interface SubOfficerDaoI {
	public List<CharacterI> getAllSubOfficers();
	public CharacterI getSubOfficer(String name);
	public void updateSubOfficer(CharacterI SubOfficer);
	public void deleteSubOfficer(CharacterI SubOfficer);
}
