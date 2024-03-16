package com.anno.warriors.dw8.keys;

import com.anno.warriors.dw8.enums.kingdom.Kingdom;

public class OfficerKingdomKey {

	private String name;
	private Kingdom kingdom;

	protected OfficerKingdomKey() {
		super();
	}

	public OfficerKingdomKey(String name, Kingdom kingdom) {
		this.name = name;
		this.kingdom = kingdom;
	}

	public String getName() {
		return name;
	}

	public String getKingdom() {
		return kingdom.getValue();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kingdom == null) ? 0 : kingdom.hashCode());
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
		OfficerKingdomKey other = (OfficerKingdomKey) obj;
		if (kingdom != other.kingdom)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s-%s", name, kingdom.getValue());
	}

}
