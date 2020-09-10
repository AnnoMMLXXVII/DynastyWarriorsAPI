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
import com.dw8xl.restdw8xl.model.weapon.Affinity;
import com.dw8xl.restdw8xl.model.weapon.Type;
import com.dw8xl.restdw8xl.model.weapon.Weapon;
import com.dw8xl.restdw8xl.model.weapon.attribute.Attribute;
import com.dw8xl.restdw8xl.model.weapon.attribute.AttributeI;
import com.dw8xl.restdw8xl.model.weapon.attribute.level.Level;

/**
 * @author Haku Wei
 *
 */
public class SampleController {

	private CharacterI officer;
	private KingdomI kingdom;
	private Weapon weapon;
	private Affinity affinity;
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
		type = new Type("Diver", "Dragon Spear");
		weapon = new Weapon("Dark Dragon Spear", 52, 6, type, affinity, attribute);
		officer = new Officer("Zhao Yun", kingdom, weapon);
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
