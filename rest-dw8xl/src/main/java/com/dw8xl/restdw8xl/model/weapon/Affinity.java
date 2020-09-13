/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon;

/**
 * @author Haku Wei
 *
 */
public class Affinity {

	private String affinity;

	/**
	 * @param affinity
	 */
	public Affinity(String affinity) {
		super();
		this.affinity = affinity;
	}

	/**
	 * @return the affinity
	 */
	public String getAffinity() {
		return affinity;
	}

	/**
	 * @param affinity the affinity to set
	 */
	public void setAffinity(String affinity) {
		this.affinity = affinity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((affinity == null) ? 0 : affinity.hashCode());
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
		Affinity other = (Affinity) obj;
		if (affinity == null) {
			if (other.affinity != null)
				return false;
		} else if (!affinity.equals(other.affinity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Affinity [affinity=" + affinity + "]";
	}
	
	
}
