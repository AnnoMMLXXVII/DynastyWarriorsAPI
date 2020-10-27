/**
 * 
 */
package com.anno.dw8xl.length.model;

import org.springframework.stereotype.Component;

import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author venividivicihofneondeion010101
 *
 */
@Component

public class Length implements LengthI {
	
	@JsonView(CharacterView.Weapon.class)
	private String size;
	
	public Length() {
		super();
	}

	public Length(String size) {
		this.size = size;
	}

	@Override
	public String getSize() {
		return size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		Length other = (Length) obj;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

}
