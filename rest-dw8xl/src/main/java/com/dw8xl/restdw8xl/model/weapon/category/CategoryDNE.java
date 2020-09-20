/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon.category;

/**
 * @author Haku Wei
 *
 */
public class CategoryDNE implements CategoryI {

	/**
	 * 
	 */
	public CategoryDNE() {}

	@Override
	public String getCategory() {
		return "";
	}

	@Override
	public CategoryI getIntance() {
		return this;
	}
	
	

}
