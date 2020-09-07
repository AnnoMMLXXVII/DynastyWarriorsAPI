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
public class Weapon {
	
	private String name;
	private Integer baseAttk, star;
	private Type type;
	private Affinity affinity;
	private List<AttributeI> attribute;
	
	/**
	 * @param name
	 * @param baseAttk
	 * @param star
	 * @param type
	 * @param affinity
	 */
	public Weapon(String name, Integer baseAttk, Integer star, Type type, Affinity affinity, List<AttributeI> attribute) {
		super();
		this.name = name;
		this.baseAttk = baseAttk;
		this.star = star;
		this.type = type;
		this.affinity = affinity;
		this.attribute = attribute;
	}
	
	public Weapon(String name, Integer baseAttk, Integer star, Type type, Affinity affinity) {
		super();
		this.name = name;
		this.baseAttk = baseAttk;
		this.star = star;
		this.type = type;
		this.affinity = affinity;
		setAttributes(attribute);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the baseAttk
	 */
	public Integer getBaseAttk() {
		return baseAttk;
	}
	/**
	 * @return the star
	 */
	public Integer getStar() {
		return star;
	}
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	/**
	 * @return the affinity
	 */
	public Affinity getAffinity() {
		return affinity;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param baseAttk the baseAttk to set
	 */
	public void setBaseAttk(Integer baseAttk) {
		this.baseAttk = baseAttk;
	}
	/**
	 * @param star the star to set
	 */
	public void setStar(Integer star) {
		this.star = star;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}
	/**
	 * @param affinity the affinity to set
	 */
	public void setAffinity(Affinity affinity) {
		this.affinity = affinity;
	}

	/**
	 * @return the attributes
	 */
	public List<AttributeI> getAttributes() {
		return (attribute == null) 
				? new ArrayList<AttributeI>() : attribute;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(List<AttributeI> attribute) {
		this.attribute = attribute;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((affinity == null) ? 0 : affinity.hashCode());
		result = prime * result + ((attribute == null) ? 0 : attribute.hashCode());
		result = prime * result + ((baseAttk == null) ? 0 : baseAttk.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((star == null) ? 0 : star.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weapon other = (Weapon) obj;
		if (affinity == null) {
			if (other.affinity != null)
				return false;
		} else if (!affinity.equals(other.affinity))
			return false;
		if (attribute == null) {
			if (other.attribute != null)
				return false;
		} else if (!attribute.equals(other.attribute))
			return false;
		if (baseAttk == null) {
			if (other.baseAttk != null)
				return false;
		} else if (!baseAttk.equals(other.baseAttk))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (star == null) {
			if (other.star != null)
				return false;
		} else if (!star.equals(other.star))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Weapon [name=" + name + ", baseAttk=" + baseAttk + ", star=" + star + ", type=" + type + ", affinity="
				+ affinity + ", attribute=" + attribute + "]";
	}
	
	
	
	
	
	
}
