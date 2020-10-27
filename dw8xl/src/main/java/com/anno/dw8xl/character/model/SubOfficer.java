/**
 * 
 */
package com.anno.dw8xl.character.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author Haku Wei
 *
 */
@Component
@JsonView(CharacterView.SubOfficer.class)
public class SubOfficer extends Character {
	
	public SubOfficer() {
		/*
		 * Empty On purpose
		 * Must Be empty
		 * Commenting to resolve sonar
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
