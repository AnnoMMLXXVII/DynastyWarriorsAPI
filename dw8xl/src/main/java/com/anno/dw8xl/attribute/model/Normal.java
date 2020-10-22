/**
 * 
 */
package com.anno.dw8xl.attribute.model;

import com.anno.dw8xl.rarity.model.Rarity;

/**
 * @author Haku Wei
 *
 */
public class Normal extends Attribute{

	public Normal() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param description
	 */
	public Normal(String name, String description) {
		super(name, description);
	}

	@Override
	public Rarity getType() {
		return Rarity.NORMAL;
	}
	
}
