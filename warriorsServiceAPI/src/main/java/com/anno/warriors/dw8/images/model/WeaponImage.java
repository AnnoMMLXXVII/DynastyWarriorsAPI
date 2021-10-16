package com.anno.warriors.dw8.images.model;

public class WeaponImage extends DynastyWarriors8Image {

	public WeaponImage(String name, String image) {
		super(name, image);
		this.imageType = "Weapon";
	}

	@Override
	public String getImageType() {
		return imageType;
	}

	@Override
	public String toString() {
		return "WeaponImage [ " + super.toString() + "imageType=" + imageType + "]";
	}
	
	

}
