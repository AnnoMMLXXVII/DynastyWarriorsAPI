/**
 * 
 */
package com.anno.dw8xl.category.model;

import org.springframework.stereotype.Component;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Component
public class NullCategory implements CategoryI {

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
