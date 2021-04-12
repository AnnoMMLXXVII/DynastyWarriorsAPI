package com.anno.warriors.dw8.characters.facade;

import java.util.List;

import com.anno.warriors.dw8.characters.model.CharacterInterface;

public interface CharacterFacadeInterface {

	public List<CharacterInterface<com.anno.warriors.dw8.characters.model.Character>> callingGetAllCharacters();

	public List<CharacterInterface<com.anno.warriors.dw8.characters.model.Character>> callingGetAllOfficers();

	public List<CharacterInterface<com.anno.warriors.dw8.characters.model.Character>> callingGetAllSubOfficers();

}
