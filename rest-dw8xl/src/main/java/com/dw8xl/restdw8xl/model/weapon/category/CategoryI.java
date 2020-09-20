/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon.category;

/**
 * @author Haku Wei
 *
 */
public interface CategoryI {

	public String getCategory();
	public abstract CategoryI getIntance();
	
	public int hashCode();
	public boolean equals(Object obj);
}
