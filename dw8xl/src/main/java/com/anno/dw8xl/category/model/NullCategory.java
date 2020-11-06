/**
 * 
 */
package com.anno.dw8xl.category.model;

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
@JsonDeserialize(as = NullCategory.class)
public class NullCategory implements CategoryI {
	@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "state")
	private String state;
	public NullCategory() {
		/*
		 * Empty Contructor
		 * Security Reasons
		 * Sonar Compilation Resolution
		 */
	}

	@Override
	public String getName() {
		return "-";
	}
	
	@Override
	public String toString() {
		return this.getName();
	}

}
