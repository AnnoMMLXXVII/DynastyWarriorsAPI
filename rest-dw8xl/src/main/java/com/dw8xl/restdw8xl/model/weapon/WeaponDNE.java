/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon;

import java.util.ArrayList;
import java.util.List;

import com.dw8xl.restdw8xl.model.weapon.affinity.AffinityDNE;
import com.dw8xl.restdw8xl.model.weapon.affinity.AffinityI;
import com.dw8xl.restdw8xl.model.weapon.attribute.AttributeI;
import com.dw8xl.restdw8xl.model.weapon.category.CategoryDNE;
import com.dw8xl.restdw8xl.model.weapon.category.CategoryI;
import com.dw8xl.restdw8xl.model.weapon.type.Type;

/**
 * @author Haku Wei
 *
 */
public class WeaponDNE implements WeaponI {

	
	
	/**
	 * 
	 */
	public WeaponDNE() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public Integer getBaseAttk() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return new Type("", new CategoryDNE());
	}

	@Override
	public Integer getStar() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AffinityI getAffinity() {
		// TODO Auto-generated method stub
		return new AffinityDNE();
	}

	@Override
	public List<AttributeI> getAttributes() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public CategoryI getCategory() {
		// TODO Auto-generated method stub
		return new CategoryDNE();
	}

	@Override
	public WeaponI getInstance() {
		return this;
	}
	
	

}
