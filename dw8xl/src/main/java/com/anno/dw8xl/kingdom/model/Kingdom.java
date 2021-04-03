/**
 * 
 */
package com.anno.dw8xl.kingdom.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Haku Wei
 *
 */
@Component
@JsonView({CharacterView.Kingdom.class})
@JsonDeserialize(as = Kingdom.class)
public class Kingdom implements KingdomI {
	
	@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "state")
	private String state = "kingdom";
	
	@JsonView({CharacterView.Officer.class, CharacterView.SubOfficer.class})
	private String name;

	
	
	/**
	 * 
	 */
	public Kingdom() {
		/*
		 * 
		 */
	}

	/**
	 * @param name
	 */
	public Kingdom(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Kingdom other = (Kingdom) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

}
