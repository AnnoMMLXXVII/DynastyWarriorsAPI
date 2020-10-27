/**
 * 
 */
package com.anno.dw8xl.attribute.model;

import com.anno.dw8xl.level.model.LevelI;
import com.anno.dw8xl.rarity.model.Rarity;
import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author Haku Wei
 *
 */
@JsonTypeName("Normal")
public class Normal extends Attribute {
	
	@JsonView({CharacterView.Weapon.Attribute.class})
	private LevelI level;
	/**
	 * @param name
	 * @param description
	 */
	public Normal(String name, String description) {
		super(name, description);
	}
	
	/**
	 * @param level
	 */
	public void setLevel(LevelI level) {
		this.level = level;
	}
	
	/**
	 * @return
	 */
	public LevelI getLevel() {
		return level;
	}
	
	@Override
	public String getRarity() {
		return new Rarity("NORMAL").getType();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Normal other = (Normal) obj;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		return true;
	}
	
	
	

}
