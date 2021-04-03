/**
 * 
 */
package com.anno.dw8xl.type.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.category.model.NullCategory;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Component
@JsonDeserialize(as = NullType.class)
public class NullType implements TypeI {
	@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "state")
	private String state = "null";
	/**
	 * 
	 */
	public NullType() {
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
	
	@Override
	public void setCategory(CategoryI category) {
		/*
		 * Empty due to Null Type. If Type is Null then Category cannot exist. 
		 * Thus getCategory() returns NullCategory instance
		 */
	}

	@Override
	public CategoryI getCategory() {
		return new NullCategory();
	}
	
	@Override
	public String toString() {
		return this.getName() + ", " + this.getCategory();
	}

	

}
