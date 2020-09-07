/**
 * 
 */
package com.dw8xl.restdw8xl.model.character;

import com.dw8xl.restdw8xl.model.kingdom.Kingdom;
import com.dw8xl.restdw8xl.model.kingdom.KingdomI;
import com.dw8xl.restdw8xl.model.weapon.Weapon;

/**
 * @author Haku Wei
 *
 */
public class Officer implements CharacterI{

	private String name;
	private KingdomI dynasty;
	private Weapon weapon;
	
	public Officer() {}

	/**
	 * @param name
	 * @param dynasty
	 * @param weapon
	 */
	public Officer(String name, KingdomI dynasty, Weapon weapon) {
		super();
		this.name = name;
		setDynasty(dynasty);
		this.weapon = weapon;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setDynasty(KingdomI dynasty) {
		this.dynasty = new Kingdom(dynasty.getName());
		
	}

	@Override
	public KingdomI getDynasty() {
		return dynasty;
	}

	@Override
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	@Override
	public Weapon getWeapon() {
		return weapon;
	}

	
	
	
}
