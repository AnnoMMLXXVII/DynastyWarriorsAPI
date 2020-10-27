/**
 * 
 */
package com.anno.dw8xl.kingdom.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author Haku Wei
 *
 */
@JsonView({CharacterView.Kingdom.class})
@Component
public class Kingdom implements KingdomI {
	@JsonView({CharacterView.Officer.class, CharacterView.SubOfficer.class})
	@JsonProperty("kingdom")
	private String name;

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
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

}
