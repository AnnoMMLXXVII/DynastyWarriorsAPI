/**
 * 
 */
package com.anno.dw8xl.character.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.kingdom.model.KingdomI;
import com.anno.dw8xl.type.model.TypeI;

/**
 * @author Haku Wei
 *
 */
@Component
public class SubOfficer extends Character {
	
	public SubOfficer() {}

	/**
	 * @param name
	 * @param kingdom
	 */
	public SubOfficer(String name, KingdomI kingdom) {
		super(name, kingdom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TypeI getType() {
		return null;
	}
	
	

}
