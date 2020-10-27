/**
 * 
 */
package com.anno.dw8xl.rarity.model;

import org.springframework.stereotype.Component;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Component
public class NullRarity implements RarityI {

	
	
	public NullRarity() {
		/*
		 * 
		 */
	}
	
	@Override
	public String getType() {
		return "-";
	}
	
}
