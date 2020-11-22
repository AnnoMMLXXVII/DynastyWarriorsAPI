/**
 * 
 */
package com.anno.dw8xl.character.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.type.model.NullType;
import com.anno.dw8xl.type.model.TypeI;
import com.anno.dw8xl.view.CharacterView;
import com.anno.dw8xl.weapon.model.WeaponI;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Haku Wei
 *
 */
@Component
@JsonView(CharacterView.SubOfficer.class)
@JsonDeserialize(as = SubOfficer.class)
public class SubOfficer extends Character {
	
	@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "state")
	private String state = "subOfficer";
	
	@JsonIgnore
	private TypeI type;
	@JsonIgnore
	private WeaponI weapon;
	
	public SubOfficer() {
		/*
		 * Empty On purpose
		 * Must Be empty
		 * Commenting to resolve sonar
		 * For Jackson Purposes
		 */
	}

	/**
	 * @param name
	 * @param kingdom
	 */
	public SubOfficer(String name, KingdomI kingdom) {
		super(name, kingdom);
	}
	
	

	@Override
	public TypeI getType() {
		return new NullType();
	}

	@Override
	public List<WeaponI> getWeapons() {
		return new ArrayList<>();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
	
	

}
