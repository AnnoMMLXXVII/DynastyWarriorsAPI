/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon.attribute.level;

/**
 * @author Haku Wei
 *
 */
public interface LevelI {
	
	public Integer getLevel();
	public void setLevel(Integer level);
	
	public abstract LevelI getInstance();
	
	public int hashCode();
	public boolean equals(Object obj);
	
}
