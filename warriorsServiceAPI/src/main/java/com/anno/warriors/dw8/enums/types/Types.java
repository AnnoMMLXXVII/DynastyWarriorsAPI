package com.anno.warriors.dw8.enums.types;

import com.anno.warriors.dw8.enums.DW8Enumeration;

public enum Types implements DW8Enumeration<Types> {
	SPEAR("Spear"), PIKE("Pike"), DOUBLE_VOULGE("Double Voulge"), GREAT_SWORD("Great Sword"), CLUB("Club"),
	GLOVES("Gloves"), HALBERD("Halberd"), TWIN_AXES("Twin Axes"), LANCE("Lance"), TWIN_RODS("Twin Rods"), AXE("Axe"),
	TONFA("Tonfa"), CROSSBOW("Crossbow"), ARM_CANNON("Arm Cannon"), BRUSH("Brush"), DAGGER_AXE("Dagger Axe"),
	BOMB("Bomb"), SHORT_PIKE("Short Pike"), GREAT_AXE("Great Axe"), MACE("Mace"), SPIKED_SHIELD("Spiked Shield"),
	ARM_BLADE("Arm Blade"), CIRCLE_BLADE("Circle Blade"), SIEGE_SPEAR("Siege Spear"), BOW_ROD("Bow & Rod"),
	WHEELED_HALBERD("Wheeled Halberd"), RAKE("Rake"), DUAL_HEADED_MACE("Dual-Headed Mace"),
	REVOLVING_CROSSBOW("Revolving Crossbow"), WAR_TRIDENT("War Trident"), STELE("Stele"), SWORD("Sword"),
	RAPIER("Rapier"), WAR_FAN("War Fan"), TWIN_SWORDS("Twin Swords"), THROWING_KNIVES("Throwing Knives"),
	CHAIN_SICKLE("Chain & Sickle"), NUNCHAKU("Nunchaku"), STAFF("Staff"), BOW("Bow"), SHAMAN_ROD("Shaman Rod"),
	IRON_FAN("Iron Fan"), SWORD_SHIELD("Sword & Shield"), FLYING_SWORDS("Flying Swords"), CURVED_SWORD("Curved Sword"),
	CLAWS("Claws"), WHEELS("Wheels"), CHAIN_WHIP("Chain Whip"), SPINNER("Spinner"), FLUTE("Flute"), HARP("Harp"),
	ORB_SCEPTER("Orb & Scepter"), TRISHULA("Trishula"), PUGIL_STICK("Pugil Stick"), LIGHTNING_SWORD("Lightning Sword"),
	BOOMERANG("Boomerang"), SWORD_HOOK("Sword & Hook"), SWALLOW_SWORDS("Swallow Swords"),
	THREE_SECTIONAL_STAFF("Three Sectional Staff"), SHADOW_FAN("Shadow Fan"), EXTENSION_BLADE("Extension Blade"),
	DUAL_HOOKBLADES("Dual Hookblades"), WINGBLADES("Wingblades"), THROWING_AXES("Throwing Axes"),
	WIRED_GLOVES("Wired Gloves"), FLAME_BOW("Flame Bow"), ART_OF_WAR_SCROLL("Art of War Scroll"),
	FORMATION_WAND("Formation Wand"), FLAIL("Flail"), PODAO("Podao"), DOUBLE_PIKE("Double Pike"),
	GENERALS_SWORD("General's Sword"), NINE_RINGS_BLADE("Nine Rings Blade"), DOUBLE_EDGE_TRIDENT("Double-Edge Trident"),
	SHORT_ROD("Short Rod"), JAVELIN("Javelin"), CROSSED_PIKE("Crossed Pike"), DRAGON_SPEAR("Dragon Spear"),
	CRESCENT_BLADE("Crescent Blade"), DUAL_BLADE("Dual Blade"), HORSEHAIR_WHIP("Horsehair Whip"),
	STRIKING_SWORD("Striking Sword"), TALISMAN_CARDS("Talisman Cards"), FLAIL_SWORD("Flail Sword"),
	WOVEN_CLOTH("Woven Cloth"), FLAMING_BOW("Flaming Bow"), MANDARIN_DUCK_HOOKS("Mandarin Duck Hooks"),
	TWIN_PIKE("Twin Pike"), FLAMING_SWORD("Flaming Sword"), DRAGON_COLUMN("Dragon Column"), FLAIL_BLADE("Flail Blade"),
	BLADEBOW("Bladebow"), PAIRED_FANS("Paired Fans"), EMEI_PIERCERS("Emei Piercers"), SABATONS("Sabatons");

	private String value;

	Types(String value) {
		this.value = value;
	}

	@Override
	public String getState() {
		return this.getClass().getSimpleName();
	}

	@Override
	public String getValue() {
		return value;
	}

	public static Types returnCorrectEnum(String str) {
		for (Types a : values()) {
			if (a.getValue().equalsIgnoreCase(str)) {
				return a;
			}
		}
		return null;
	}

}
