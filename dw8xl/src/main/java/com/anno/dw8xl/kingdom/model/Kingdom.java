/**
 * 
 */
package com.anno.dw8xl.kingdom.model;

/**
 * @author Haku Wei
 *
 */
public class Kingdom implements KingdomI {

	private String name;
	
	public Kingdom() {}
	
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
			if (other.name!= null)
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
