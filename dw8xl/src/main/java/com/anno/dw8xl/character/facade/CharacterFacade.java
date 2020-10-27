package com.anno.dw8xl.character.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anno.dw8xl.character.dao.CharacterDAOInterface;
import com.anno.dw8xl.character.model.CharacterI;
import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("characterFacade")
public class CharacterFacade implements CharacterFacadeInterface {

	@Autowired
	private CharacterDAOInterface dao;
	private ObjectMapper mapper = new ObjectMapper();
	private static Logger log = LoggerFactory.getLogger(CharacterFacade.class);
	@Override
	public Collection<CharacterI> getAllCharacters() {
		return dao.getAll();
	}

	@Override
	public String getAllOfficers() {
		String json = "";
		try {
			mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
			json = mapper
			.writerWithDefaultPrettyPrinter()
			.withView(CharacterView.Officer.class)
			.writeValueAsString(dao.getAllOfficers());
		} catch (JsonProcessingException e) {
			log.debug(String.format("Error Mapping to String : %s", e.getMessage()));
		} 
		return json;
	}

	@Override
	public String getAllSubOfficers() {
		String json = "";
		try {
			mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
			json = mapper
			.writerWithDefaultPrettyPrinter()
			.withView(CharacterView.SubOfficer.class)
			.writeValueAsString(dao.getAllSubOfficers());
		} catch (JsonProcessingException e) {
			log.debug(String.format("Error Mapping to String : %s", e.getMessage()));
		} 
		return json;
	}

	@Override
	public Collection<CharacterI> getOfficerByKingdom(String kingdom) {
		if (kingdom.equalsIgnoreCase("Shu")) {
			return dao.getAllShuOfficers();
		} else if (kingdom.equalsIgnoreCase("Wu")) {
			return dao.getAllWuOfficers();
		} else if (kingdom.equalsIgnoreCase("Wei")) {
			return dao.getAllWeiOfficers();
		} else if (kingdom.equalsIgnoreCase("Jin")) {
			return dao.getAllJinOfficers();
		} else if (kingdom.equalsIgnoreCase("Other")) {
			return dao.getAllOtherOfficers();
		}
		return new ArrayList<>();
	}

	@Override
	public Collection<CharacterI> getSubOfficerByKingdom(String kingdom) {
		if (kingdom.equalsIgnoreCase("Shu")) {
			return dao.getAllShuSubOfficers();
		} else if (kingdom.equalsIgnoreCase("Wu")) {
			return dao.getAllWuSubOfficers();
		} else if (kingdom.equalsIgnoreCase("Wei")) {
			return dao.getAllWeiSubOfficers();
		} else if (kingdom.equalsIgnoreCase("Jin")) {
			return dao.getAllJinSubOfficers();
		} else if (kingdom.equalsIgnoreCase("Other")) {
			return dao.getAllOtherSubOfficers();
		} else {
			return new ArrayList<>();
		}
	}

}
