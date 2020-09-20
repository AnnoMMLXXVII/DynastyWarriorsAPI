/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon;

import java.util.List;

import com.dw8xl.restdw8xl.model.weapon.affinity.AffinityI;
import com.dw8xl.restdw8xl.model.weapon.attribute.AttributeI;
import com.dw8xl.restdw8xl.model.weapon.category.CategoryI;
import com.dw8xl.restdw8xl.model.weapon.type.Type;

/**
 * @author Haku Wei
 *
 */
public interface WeaponI {
	
	public String getName();
	public Integer getBaseAttk();
	public Type getType();
	public Integer getStar();
	
	public abstract AffinityI getAffinity();
	public abstract List<AttributeI> getAttributes();
	public abstract CategoryI getCategory();
	public abstract WeaponI getInstance();
	
	public int hashCode();
	public boolean equals(Object obj);

}
