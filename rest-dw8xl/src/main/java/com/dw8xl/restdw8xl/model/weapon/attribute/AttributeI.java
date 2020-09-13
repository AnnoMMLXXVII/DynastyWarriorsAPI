package com.dw8xl.restdw8xl.model.weapon.attribute;

import com.dw8xl.restdw8xl.model.weapon.attribute.level.LevelI;

public interface AttributeI {

	public abstract void setAttribute(String name);

	public abstract String getAttribute();

	public abstract void setDescription(String description);

	public abstract String getDescription();

	public abstract void setLevel(LevelI level);
	public abstract LevelI getLevel();
}
