/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon.affinity;

/**
 * @author Haku Wei
 *
 */
public interface AffinityI {
	public String getAffinity();
	public abstract AffinityI getInstance();
	
	public int hashCode();
	public boolean equals(Object obj);
}
