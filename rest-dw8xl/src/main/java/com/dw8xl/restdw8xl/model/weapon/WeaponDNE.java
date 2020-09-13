/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon;

import java.util.ArrayList;
import java.util.List;

import com.dw8xl.restdw8xl.model.weapon.attribute.AttributeI;

/**
 * @author Haku Wei
 *
 */
public class WeaponDNE implements WeaponI {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public List<AttributeI> getAttributes() {
		return new ArrayList<>();
	}

	@Override
	public Integer getStar() {
		return 0;
	}
	
	

	
	
}
