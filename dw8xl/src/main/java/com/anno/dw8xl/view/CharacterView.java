/**
 * 
 */
package com.anno.dw8xl.view;


/**
 * @author venividivicihofneondeion010101
 *
 */
public class CharacterView {
	private CharacterView() {}
	
	public static interface Officer {

	}
	
	public static interface Kingdom extends Officer {}
	public static interface Type extends Officer {
		public static interface Category extends Type {}
	}
	
	public static interface Weapon extends Officer {
		public static interface Affinity extends Weapon {
			public static interface Rarity extends Weapon {}
		}
		public static interface Type extends Weapon {
			public static interface Category extends Type {}
		}
		public static interface Length extends Weapon {};
		
		public static interface Category extends Weapon {}
		public static interface Rarity extends Weapon {}
		public static interface Attribute extends Weapon{
			public static interface Level extends Weapon {}
		}
	}
	public static interface Affinity {}
	public static interface Rarity {}
	public static interface Category {}
	public static interface Attribute {
		public static interface Level {}		
	}
	
	
	public static interface SubOfficer {
		public static interface Kingdom extends SubOfficer {}
	}
	
}
