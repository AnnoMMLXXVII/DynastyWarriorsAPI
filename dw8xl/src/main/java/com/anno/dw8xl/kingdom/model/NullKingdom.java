/**
 * 
 */
package com.anno.dw8xl.kingdom.model;

/**
 * @author venividivicihofneondeion010101
 *
 */
public class NullKingdom implements KingdomI{

	public NullKingdom() {}
	
	@Override
	public String getKingdom() {
		return "";
	}

	@Override
	public KingdomI getInstance() {
		return this;
	}

}
