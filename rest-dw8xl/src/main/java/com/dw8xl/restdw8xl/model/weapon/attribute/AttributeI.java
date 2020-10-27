package com.dw8xl.restdw8xl.model.weapon.attribute;

import com.dw8xl.restdw8xl.model.weapon.attribute.level.LevelI;

public interface AttributeI {

	public void setAttribute(String name);

	public String getAttribute();

	public void setDescription(String description);

	public String getDescription();

	public void setLevel(LevelI level);
	public LevelI getLevel();
	
	public int hashCode();
	public boolean equals(Object obj);
}
