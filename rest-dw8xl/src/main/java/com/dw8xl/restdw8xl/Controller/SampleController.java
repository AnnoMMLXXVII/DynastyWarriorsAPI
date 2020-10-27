/**
 * 
 */
package com.dw8xl.restdw8xl.Controller;

import java.util.ArrayList;
import java.util.List;

import com.dw8xl.restdw8xl.model.character.CharacterI;
import com.dw8xl.restdw8xl.model.character.Officer;
import com.dw8xl.restdw8xl.model.kingdom.Kingdom;
import com.dw8xl.restdw8xl.model.kingdom.KingdomI;
import com.dw8xl.restdw8xl.model.weapon.WeaponI;
import com.dw8xl.restdw8xl.model.weapon.affinity.Affinity;
import com.dw8xl.restdw8xl.model.weapon.affinity.AffinityI;
import com.dw8xl.restdw8xl.model.weapon.attribute.Attribute;
import com.dw8xl.restdw8xl.model.weapon.attribute.AttributeI;
import com.dw8xl.restdw8xl.model.weapon.attribute.level.Level;
import com.dw8xl.restdw8xl.model.weapon.category.Category;
import com.dw8xl.restdw8xl.model.weapon.category.CategoryDNE;
import com.dw8xl.restdw8xl.model.weapon.classifications.Legend;
import com.dw8xl.restdw8xl.model.weapon.type.Type;

/**
 * @author Haku Wei
 *
 */
public class SampleController {

	private CharacterI officer;
	private KingdomI kingdom;
	private WeaponI weapon;
	private AffinityI affinity;
	private Type type;
	private List<AttributeI> attribute;
	
	public SampleController() {
		attribute = new ArrayList<AttributeI>(6);
		initializeCharacters();
	}
	
	private void initializeCharacters() {
		initializeAttributes();
		affinity = new Affinity("Heaven");
		kingdom = new Kingdom("Shu");
		type = new Type("Dragon Spear", new Category("Diver"));
		weapon = new Legend("Dark Dragon Spear", 52, affinity, 6, type, attribute);
		officer = new Officer("Zhao Yun", kingdom, new Type("Dragon Spear", new CategoryDNE()));
	}
	
	private void initializeAttributes() {
		attribute.add(new Attribute("Thunder", new Level(10)));
		attribute.add(new Attribute("Frost", new Level(10)));
		attribute.add(new Attribute("Slash", new Level(10)));
		attribute.add(new Attribute("Cyclone", new Level(10)));
		attribute.add(new Attribute("Velocity", new Level(10)));
	}
	
	public CharacterI getOfficer() {
		return officer;
	}
}
