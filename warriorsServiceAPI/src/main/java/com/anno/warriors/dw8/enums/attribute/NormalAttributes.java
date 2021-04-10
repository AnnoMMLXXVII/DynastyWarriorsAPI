package com.anno.warriors.dw8.enums.attribute;

import com.anno.warriors.dw8.enums.DW8Enumeration;

public enum NormalAttributes implements AttributeInterface {

	THORNS("Thorns", "Inflicts a portion of damage received against the enemy"),
	SURVIVAL("Survival", "Raises attack power while lowering overall health"),
	FRENZY("Frenzy", "Raises attack power while lowering overall defense"),
	BARRICADE("Barricade", "Raises defense power while lowering overall defense"),
	AGGRESSION("Aggression", "Raises damage done by Musou attacks"),
	VELOCITY("Velocity", "Raises overall attack speed"), FLURRY("Flurry", "Raises damange as combos go up"),
	CHAIN("Chain", "Increases time period for maintaing combo count"), INFERNO("Inferno", "Burns enemies"),
	FROST("Frost", "Freezes enemies"), THUNDER("Thunder", "Electrocutes enemies"),
	CYCLONE("Cyclone", "Inflicts chip damage against blocking enemies"),
	SLASH("Slash", "May instantly defeat any enemies while also greatly damage enemy officers out of chance"),
	VENOM("Venom", "Poisons Enemies"), FLASH("Flash", "Causes affected foes to explode"),
	SPURT("Spurt", "Raises the chances of enemies dropping the winged boots power-up"),
	RECOVERY("Recovery", "Heals the user with each attack"), UPLIFT("Uplift", "Attacks help fill up the Musou gauge"),
	ENLIGHTENMENT("Enlightenment", "Attacks helpl fil up with Awakening gauge"),
	EXPLOSIVE("Explosive", "Generates small explosinos while attacking"),
	INDUCTION("Induction", "Generates lightning bolts while attacking"),
	VIGOR("Vigor", "Releases a protective shockwave when attacked"),
	JOLT("Jolt", "Raises lightning bolts when attacked"),
	HARMONY("Harmony", "Raises attack power when equipping two weapons with the same affinity"),
	PROTECTION("Protection", "Raises defense power when equipping two weapons with the same affinity"),
	FEAR("Fear", "Attacks may cause enemies to flee in terror"),
	AWE("Awe", "Attacks may cause enemies to faint momentarily"),
	MORASS("Morass", "Attacks may inflict slow status on enemies"),
	JUBILATION("Jubilation", "Restores a small portion of health by defeating enemies"),
	ROAR("Roar", "Restores a small portion of Musou by defeating enemies"),
	TRIUMPH("Triumph", "Restores a small portion of the Awakening gauge by defeating enemies"),
	WHIRLWIND("Whirlwind", "Raises damage caused by knock back attacks"),
	GALE("Gale", "Raises attack power based on the number of enemies defeasted by the user"),
	COMET("Comet", "Raises the distance enemies are flung by certain attacks"),
	THUNDERCLAP("Thunderclap", "The user will not flinch from attacks while running"),
	EFFLORESCENCE("Efflorescence", "Raises duration of strength boost provided by switch counter"),
	CONFLAGRATION("Conflagration", "Causes eneimes sent flying to explode when colliding with others");

	private String name;
	private String description;

	private NormalAttributes() {

	}

	NormalAttributes(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String getValue() {
		return String.format("%s, %s", name, description);
	}

	@Override
	public String getName() {
		return name();
	}

	@Override
	public DW8Enumeration<AttributeInterface> getManagerType() {
		return this;
	}

	@Override
	public String getType() {
		return "Normal";
	}

	@Override
	public String getDescription() {
		return description;
	}

	public static AttributeInterface returnCorrectEnum(String str) {
		for (NormalAttributes a : values()) {
			if (a.name().equalsIgnoreCase(str)) {
				return a;
			}
		}
		return null;
	}

}
