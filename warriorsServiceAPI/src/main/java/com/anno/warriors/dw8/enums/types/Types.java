package com.anno.warriors.dw8.enums.types;

import java.util.Comparator;

import com.anno.warriors.dw8.enums.DW8Enumeration;

public enum Types implements DW8Enumeration<Types>, Comparator<Types> {
	ARM_BLADE("Arm Blade"), ARM_CANNON("Arm Cannon"), ART_OF_WAR_SCROLL("Art of War Scroll"), AXE("Axe"),

	BLADE_BLOW("Bladebow"), BOMB("Bomb"), BOOMERANG("Boomerang"), BOW("Bow"), BOW_ROD("Bow & Rod"), BRUSH("Brush"),

	CHAIN_SICKLE("Chain & Sickle"), CHAIN_WHIP("Chain Whip"), CIRCLE_BLADE("Circle Blade"), CLAWS("Claws"),
	CLUB("Club"), CRESCENT_BLADE("Crescent Blade"), CROSSBOW("Crossbow"), CROSSED_PIKE("Crossed Pike"),
	CURVED_SWORD("Curved Sword"),

	DAGGER_AXE("Dagger Axe"), DOUBLE_VOULGE("Double Voulge"), DOUBLE_EDGE_TRIDENT("Double-Edge Trident"),
	DRAGON_COLUMN("Dragon Column"), DRAGON_SPEAR("Dragon Spear"), DUAL_BLADE("Dual Blade"),
	DUAL_HOOKBLADES("Dual Hookblades"), DUAL_HEADED_MACE("Dual-Headed Mace"),

	EMEI_PIERCERS("Emei Piercers"), EXTENSION_BLADE("Extension Blade"),

	FLAIL("Flail"), FLAIL_SWORD("Flail Sword"), FLAMING_BOW("Flaming Bow"), FLAMING_SWORD("Flaming Sword"),
	FLUTE("Flute"), FLYING_SWORDS("Flying Swords"), FORMATION_WAND("Formation Wand"),

	GENERALS_SWORD("General's Sword"), GLOVES("Gloves"), GREAT_AXE("Great Axe"), GREAT_SWORD("Great Sword"),

	HALBERD("Halberd"), HARP("Harp"), HORSEHAIR_WHIP("Horsehair Whip"),

	IRON_FAN("Iron Fan"), JAVELIN("Javelin"),

	LANCE("Lance"), LIGHTNING_SWORD("Lightning Sword"),

	MACE("Mace"), MANDARIN_DUCK_HOOKS("Mandarin Duck Hooks"), NINE_RINGS_BLADE("Nine Rings Blade"), NUNCHAKU("Nunchaku"),

	ORB_SCEPTER("Orb & Scepter"),

	PAIRED_FANS("Paired Fans"), PIKE("Pike"), PODAO("Podao"), PUGIL_STICK("Pugil Stick"),

	RAKE("Rake"), RAPIER("Rapier"), REVOLVING_CROSSBOW("Revolving Crossbow"),

	SABATONS("Sabatons"), SHADOW_FAN("Shadow Fan"), SHAMAN_ROD("Shaman Rod"), SHORT_PIKE("Short Pike"), SHORT_ROD("Short Rod"),
	SIEGE_SPEAR("Siege Spear"), SPEAR("Spear"), SPIKED_SHIELD("Spiked Shield"), SPINNER("Spinner"), STAFF("Staff"),
	STELE("Stele"), STRIKING_SWORD("Striking Sword"), SWALLOW_SWORDS("Swallow Swords"), SWORD("Sword"),
	SWORD_HOOK("Sword & Hook"), SWORD_SHIELD("Sword & Shield"),

	TALISMAN_CARDS("Talisman Cards"), THREE_SECTIONAL_STAFF("Three Sectional Staff"), THROWING_AXES("Throwing Axes"),
	THROWING_KNIVES("Throwing Knives"), TONFA("Tonfa"), TRISHULA("Trishula"), TWIN_AXES("Twin Axes"),
	TWIN_PIKES("Twin Pikes"), TWIN_RODS("Twin Rods"), TWIN_SWORDS("Twin Swords"),

	WAR_FAN("War Fan"), WAR_TRIDENT("War Trident"), WHEELED_HALBERD("Wheeled Halberd"), WHEELS("Wheels"),
	WINGBLADES("Wingblades"), WIRED_GLOVES("Wired Gloves"), WOVEN_CLOTH("Woven Cloth");

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

	@Override
	public int compare(Types o1, Types o2) {
		return o1.getValue().compareTo(o2.getValue());
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
