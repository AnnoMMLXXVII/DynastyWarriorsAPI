/**
 * 
 */
package com.anno.dw8xl.type.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.category.model.NullCategory;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Component
public class NullType implements TypeI {

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
	public String getCategory() {
		return new NullCategory().getName();
	}
	
	@Override
	public String toString() {
		return this.getName() + ", " + this.getCategory();
	}

	

}
