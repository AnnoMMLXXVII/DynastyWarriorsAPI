/**
 * 
 */
package com.anno.dw8xl.attribute.model;

import com.anno.dw8xl.rarity.model.Rarity;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @author Haku Wei
 *
 */
@JsonTypeName("N")
public class Normal extends Attribute{

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
	
//	/**
//	 * @return the id
//	 */
//	public int getId() {
//		return super.id;
//	}
	
}
