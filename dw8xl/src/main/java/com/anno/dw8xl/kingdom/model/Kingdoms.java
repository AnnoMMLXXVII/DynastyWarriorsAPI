/**
 * 
 */
package com.anno.dw8xl.kingdom.model;

import org.springframework.stereotype.Component;

/**
 * @author Haku Wei
 *
 */
@Component
public enum Kingdoms implements KingdomI {
	
	SHU ("Shu"), 
	WU ("Wu"), 
	WEI ("Wei"), 
	JIN ("Jin"), 
	OTHER ("Other");

	private String kingdom;
	
	Kingdoms(String kingdom) {
		this.kingdom = kingdom;
	}
	
	@Override
	public String getKingdom() {
		return kingdom;
	}

	@Override
	public KingdomI getInstance() {
		return this;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}
