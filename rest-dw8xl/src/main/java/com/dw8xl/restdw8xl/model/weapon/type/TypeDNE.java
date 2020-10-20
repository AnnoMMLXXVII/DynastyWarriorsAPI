/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon.type;

import com.dw8xl.restdw8xl.model.weapon.category.CategoryDNE;
import com.dw8xl.restdw8xl.model.weapon.category.CategoryI;

/**
 * @author Haku Wei
 *
 */
public class TypeDNE implements TypeI {

	public TypeDNE() {}

	@Override
	public String getType() {
		return "";
	}

	@Override
	public CategoryI getCategory() {
		return new CategoryDNE();
	}

	@Override
	public String toString() {
		return "";
	}
	
	

}
