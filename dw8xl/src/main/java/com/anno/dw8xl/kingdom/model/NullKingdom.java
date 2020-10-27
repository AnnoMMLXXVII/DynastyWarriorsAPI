/**
 * 
 */
package com.anno.dw8xl.kingdom.model;

import org.springframework.stereotype.Component;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Component
public class NullKingdom implements KingdomI{

	public NullKingdom() {
		/*
		 * Empty On purpose
		 * Must Be empty
		 * Commenting to resolve sonar
		 */
	}
	
	@Override
	public String getName() {
		return "-";
	}

}
