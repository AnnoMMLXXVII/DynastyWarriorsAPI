/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon.type;

import com.dw8xl.restdw8xl.model.weapon.category.CategoryI;

/**
 * @author Haku Wei
 *
 */
public interface TypeI {

	public String getType();
	public CategoryI getCategory();
	public boolean equals(Object obj);
	public int hashCode();
	public String toString();
}
