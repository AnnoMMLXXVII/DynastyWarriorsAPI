/**
 * 
 */
package com.anno.dw8xl.rarity.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Component
@JsonDeserialize(as = NullRarity.class)
public class NullRarity implements RarityI {
	
	@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "state")
	private String state = "null";
	
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
