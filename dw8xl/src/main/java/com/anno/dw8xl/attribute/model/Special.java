/**
 * 
 */
package com.anno.dw8xl.attribute.model;

import com.anno.dw8xl.rarity.model.Rarity;
import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author Haku Wei
 *
 */
@JsonTypeName("Special")
@JsonView({CharacterView.Officer.class, CharacterView.Attribute.class, CharacterView.Weapon.Attribute.class})
public class Special extends Attribute {	

	/**
	 * @param name
	 * @param description
	 */
	public Special(String name, String description) {
		super(name, description);
	}

	@Override
	public String getRarity() {
		return new Rarity("SPECIAL").getType();
	}
}
