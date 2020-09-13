/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon;

import java.util.List;

import com.dw8xl.restdw8xl.model.weapon.attribute.AttributeI;

/**
 * @author Haku Wei
 *
 */
public interface WeaponI {
	
	public String getName();
	
	public List<AttributeI> getAttributes();
	
	public Integer getStar();

}
