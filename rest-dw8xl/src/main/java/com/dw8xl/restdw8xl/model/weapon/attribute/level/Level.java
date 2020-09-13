/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon.attribute.level;

/**
 * @author Haku Wei
 *
 */
public class Level implements LevelI {

	private Integer level;
	
	public Level(Integer level) {
		this.level = level;
	}
	
	@Override
	public Integer getLevel() {
		return level;
	}

	@Override
	public void setLevel(Integer level) {
		this.level = level;
	}

}
