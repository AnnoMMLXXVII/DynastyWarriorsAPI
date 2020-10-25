package com.anno.dw8xl.character.facade;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.dw8xl.character.model.CharacterI;
import com.anno.dw8xl.dao.DAO;

@Service("characterFacade")
public class CharacterFacade implements CharacterFacade_I {

	@Autowired
	private DAO<CharacterI, Object> dao;

	@Override
	public Collection<CharacterI> getAllCharacters() {
		return dao.getAll();
	}
	
	

}
