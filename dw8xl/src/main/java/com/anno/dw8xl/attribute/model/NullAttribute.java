/**
 * 
 */
package com.anno.dw8xl.attribute.model;

import com.anno.dw8xl.rarity.model.NullRarity;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @author venividivicihofneondeion010101
 *
 */
@JsonTypeName("Null")
public class NullAttribute implements AttributeI {

	
	public NullAttribute() {
		/*
		 * Empty On purpose
		 * Must Be empty
		 * Commenting to resolve sonar
		 */
	}

	@Override
	public String getRarity() {
		return new NullRarity().getType();
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public String getDescription() {
		return "";
	}

}
