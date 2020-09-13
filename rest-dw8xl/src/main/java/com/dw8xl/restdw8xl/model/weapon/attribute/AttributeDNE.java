/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon.attribute;

import com.dw8xl.restdw8xl.model.weapon.attribute.level.LevelDNE;
import com.dw8xl.restdw8xl.model.weapon.attribute.level.LevelI;

/**
 * @author Haku Wei
 *
 */
public class AttributeDNE implements AttributeI {

	/**
	 * @param name
	 * @param description
	 */
	public AttributeDNE(String attribute, String description, LevelI level) {
		super();
		setAttribute(attribute);
		setDescription(description);
		setLevel(level);
	}

	@Override
	public void setAttribute(String attribute) {}

	@Override
	public String getAttribute() {
		return "";
	}

	@Override
	public void setDescription(String description) {
	}

	@Override
	public String getDescription() {
		return "";
	}

	@Override
	public void setLevel(LevelI level) {
	}

	@Override
	public LevelI getLevel() {
		return new LevelDNE();
	}



}
