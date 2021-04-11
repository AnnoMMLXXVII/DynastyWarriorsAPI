package com.anno.warriors.dw8.characters.facade;

import java.util.List;

import com.anno.warriors.dw8.characters.model.CharacterInterface;

public interface CharacterFacadeInterface {

	public List<CharacterInterface> callingGetAllCharacters();

	public List<CharacterInterface> callingGetAllOfficers();

	public List<CharacterInterface> callingGetAllSubOfficers();

}
