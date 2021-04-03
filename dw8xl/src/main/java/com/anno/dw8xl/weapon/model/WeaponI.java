package com.anno.dw8xl.weapon.model;

import com.anno.dw8xl.affinity.model.AffinityI;
import com.anno.dw8xl.rarity.model.RarityI;
import com.anno.dw8xl.shared.WeaponDeserializer;
import com.anno.dw8xl.type.model.TypeI;
import com.anno.dw8xl.view.CharacterView;
import com.anno.dw8xl.weapon.dao.Attributes;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonView({ CharacterView.Officer.class, CharacterView.Weapon.class })
@JsonDeserialize(using = WeaponDeserializer.class)
@JsonSubTypes({ 
	@Type(value = Normal.class, name = "Normal"),
	@Type(value = AbNormal.class, name = "AbNormal")
})
public interface WeaponI {

	public String getName();

	public Integer getBaseAttack();

	public TypeI getType();

	public Integer getStar();

	public RarityI getRarity();
	
	public AffinityI getAffinity();
	
	public Attributes getAttributes();
	public void setAttributes(Attributes attributes);

	@Override
	int hashCode();

	@Override
	boolean equals(Object obj);
}
