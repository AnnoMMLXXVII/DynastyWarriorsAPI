/**
 * 
 */
package com.anno.dw8xl.kingdom.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Haku Wei
 *
 */
public enum Kingdom implements KingdomI {
	
	@JsonProperty SHU ("Shu"), 
	@JsonProperty WU ("Wu"), 
	@JsonProperty WEI ("Wei"), 
	@JsonProperty JIN ("Jin"), 
	@JsonProperty OTHER ("Other");

	private String kingdom;
	
	Kingdom(String kingdom) {
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
