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

	@Override
	public LevelI getInstance() {
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((level == null) ? 0 : level.hashCode());
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
		Level other = (Level) obj;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Level [level=" + level + "]";
	}
	
	

}
