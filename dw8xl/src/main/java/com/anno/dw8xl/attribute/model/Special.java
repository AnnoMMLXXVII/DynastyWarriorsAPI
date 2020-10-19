/**
 * 
 */
package com.anno.dw8xl.attribute.model;

import com.anno.dw8xl.rarity.model.Rarity;

/**
 * @author Haku Wei
 *
 */
public class Special extends Attribute {	
	/**
	 * 
	 */
	public Special() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param description
	 */
	public Special(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Rarity getType() {
		// TODO Auto-generated method stub
		return Rarity.SPECIAL;
	}

}
