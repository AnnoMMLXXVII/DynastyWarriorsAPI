package com.anno.dw8xl.weapon.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.type.model.TypeI;
import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author venividivicihofneondeion010101
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE, include = As.PROPERTY)
@JsonSubTypes({ 
	@Type(value = Normal.class, name = "Normal"),
	@Type(value = AbNormal.class, name = "AbNormal")

})
@JsonView({ CharacterView.Officer.class, CharacterView.Weapon.class })
@Component
public abstract class Weapon implements WeaponI {

	private String name;
	private Integer baseAttack;
	private TypeI type;
	private Integer star;

	protected Weapon() {
		/*
		 * Empty Contrucutor Security Reasons Sonar Resolve Compilation
		 */
	}

	/**
	 * @param name
	 * @param baseAttack
	 * @param type
	 * @param star
	 */
	public Weapon(String name, Integer baseAttack, Integer star, TypeI type) {
		super();
		this.name = name;
		this.baseAttack = baseAttack;
		this.type = type;
		this.star = star;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Integer getBaseAttack() {
		return baseAttack;
	}

	@Override
	public TypeI getType() {
		return type;
	}

	@Override
	public Integer getStar() {
		return star;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseAttack == null) ? 0 : baseAttack.hashCode());
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
		if (baseAttack == null) {
			if (other.baseAttack != null)
				return false;
		} else if (!baseAttack.equals(other.baseAttack))
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
		return String.format("%24s, %2d, %d, %s", name, baseAttack, star, type.getName());
	}

}
