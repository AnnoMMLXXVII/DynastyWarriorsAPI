/**
 * 
 */
package com.anno.dw8xl.type.model;

import com.anno.dw8xl.category.model.CategoryI;
import com.anno.dw8xl.category.model.NullCategory;

/**
 * @author venividivicihofneondeion010101
 *
 */
public class NullType implements TypeI {

	/**
	 * 
	 */
	public NullType() {}
	
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
		return this.getName() + ", " + this.getCategory().toString();
	}

	

}
