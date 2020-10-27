package com.anno.dw8xl.weapon.model;

import com.anno.dw8xl.affinity.model.AffinityI;
import com.anno.dw8xl.length.model.LengthI;
import com.anno.dw8xl.rarity.model.RarityI;
import com.anno.dw8xl.type.model.TypeI;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface WeaponI {

	public String getName();

	public Integer getBaseAttack();

	public TypeI getType();

	public Integer getStar();

	@JsonProperty("rarity")
	public abstract RarityI getRarity();
	
	@JsonProperty("length")
	public abstract String getLength();

	@Override
	int hashCode();

	@Override
	boolean equals(Object obj);

	@JsonProperty("affinity")
	public abstract AffinityI getAffinity();
}
