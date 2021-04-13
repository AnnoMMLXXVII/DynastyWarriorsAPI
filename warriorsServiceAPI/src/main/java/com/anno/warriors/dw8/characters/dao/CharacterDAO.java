package com.anno.warriors.dw8.characters.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.anno.warriors.dw8.characters.model.Character;
import com.anno.warriors.dw8.characters.model.CharacterInterface;
import com.anno.warriors.dw8.manager.DW8Structures;
import com.anno.warriors.shared.WarriorSearcher;
import com.anno.warriors.shared.WarriorSorter;

@Repository
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CharacterDAO implements CharacterDAOInterface {

//			Dependency Classes --> DW8Structures
	private static Logger logger = LoggerFactory.getLogger(CharacterDAO.class);
	private List<CharacterInterface<Character>> list;

	@Override
	public List<CharacterInterface<Character>> getAllCharacters() {
		logger.debug("GET - All Characters");
		return DW8Structures.getCharacters();
	}

	@Override
	public List<CharacterInterface<Character>> getAllOfficers() {
		logger.debug("GET - All Officers");
		return DW8Structures.getOfficers();
	}

	@Override
	public List<CharacterInterface<Character>> getAllSubOfficers() {
		logger.debug("GET - All SubOfficers");
		return DW8Structures.getSubOfficers();
	}

	@Override
	public List<CharacterInterface<Character>> getCharactersByName(List<CharacterInterface<Character>> paramList,
			String... name) {
		list = new ArrayList<>();
		WarriorSorter<Character> sorter = new WarriorSorter(paramList);
		WarriorSearcher<Character> searcher = new WarriorSearcher(sorter.getSortedList());
		for (String s : name) {
			List<CharacterInterface<Character>> temp = searcher.search(s);
			for (CharacterInterface<Character> c : temp)
				list.add(c);
		}
		return list;
	}

}
